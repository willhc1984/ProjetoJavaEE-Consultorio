package br.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dao.ConsultaDAO;
import br.com.dao.HospitalDAO;
import br.com.dao.InternacaoDAO;
import br.com.model.Consulta;
import br.com.model.Internacao;

/**
 * Servlet implementation class ControladorCadUsuario
 */
@WebServlet("/ControladorInternacao")
public class ControladorInternacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://localhost:3306/consultorio";
	static String usuario = "root";
	static String senha = "";
	static Connection conexao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorInternacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(url, usuario, senha);
			conexao.setAutoCommit(false);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int idConsulta = Integer.parseInt(request.getParameter("idConsulta"));
		int quarto = Integer.parseInt(request.getParameter("quarto"));
		String dataEntrada = request.getParameter("dataEntrada");
		String dataSaida = request.getParameter("dataSaida");
		String obs = request.getParameter("obs");
		int idFormulario = Integer.parseInt(request.getParameter("idFormulario"));

		if (idFormulario == 2) {
			Internacao internacao = new Internacao(idConsulta, quarto, dataEntrada, dataSaida, obs);
			InternacaoDAO internacaoDAO = new InternacaoDAO();
			try {
				internacaoDAO.inserir(internacao);
				session.setAttribute("mensagem", "Cadastro realizado com sucesso!");
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem", "Erro ao cadastrar: " + mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}

		else if (idFormulario == 3) {
			int idInternacao = Integer.parseInt(request.getParameter("idInternacao"));
			Internacao internacao = new Internacao(idInternacao, dataEntrada, quarto, dataSaida, obs, idConsulta);
			InternacaoDAO internacaoDAO = new InternacaoDAO();
			try {
				internacaoDAO.alterar(internacao);
				session.setAttribute("mensagem", "Cadastro alterado com sucesso!");
			} catch (SQLException | RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem", "Erro ao atualizar dados: " + mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}

		else if (idFormulario == 4) {
			int idInternacao = Integer.parseInt(request.getParameter("idInternacao"));
			InternacaoDAO internacaoDAO = new InternacaoDAO();
			try {
				internacaoDAO.excluir(idInternacao);
				session.setAttribute("mensagem", "Internação excluida do sistema!");
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem",
						"Erro ao excluir hospital: Provavelmente existe alguma consulta atribuida a este cadastro de internação - "
								+ mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}
	}
}

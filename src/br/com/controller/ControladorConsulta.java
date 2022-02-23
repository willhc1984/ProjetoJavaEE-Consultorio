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
import br.com.dao.MedicoDAO;
import br.com.model.Consulta;
import br.com.model.Medico;

/**
 * Servlet implementation class ControladorCadUsuario
 */
@WebServlet("/ControladorConsulta")
public class ControladorConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://localhost:3306/consultorio";
	static String usuario = "root";
	static String senha = "";
	static Connection conexao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorConsulta() {
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
		int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
		int idMedico = Integer.parseInt(request.getParameter("idMedico"));
		int idHospital = Integer.parseInt(request.getParameter("idHospital"));
		String data = request.getParameter("data");
		String diagnostico = request.getParameter("diagnostico");
		int idFormulario = Integer.parseInt(request.getParameter("idFormulario"));
		

		if (idFormulario == 2) {
			Consulta consulta = new Consulta(idPaciente, idMedico, idHospital, data, diagnostico);
			ConsultaDAO consultaDAO = new ConsultaDAO();
			try {
				consultaDAO.inserir(consulta);
				session.setAttribute("mensagem", "Cadastro realizado com sucesso!");
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem", "Erro ao cadastrar: " + mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}

		else if (idFormulario == 3) {
			int idConsulta = Integer.parseInt(request.getParameter("idConsulta"));
			Consulta consulta = new Consulta(idConsulta, idPaciente, idMedico, idHospital, data, diagnostico);
			ConsultaDAO consultaDAO = new ConsultaDAO();
			try {
				consultaDAO.alterar(consulta);
				session.setAttribute("mensagem", "Cadastro alterado com sucesso!");
			} catch (SQLException | RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem", "Erro ao atualizar dados: " + mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}

		else if (idFormulario == 4) {	
			int idConsulta = Integer.parseInt(request.getParameter("idConsulta"));
			ConsultaDAO consultaDAO = new ConsultaDAO();
			try {
				consultaDAO.excluir(idConsulta);
				session.setAttribute("mensagem", "Consulta foi excluido do sistema!");
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem",
						"Erro ao excluir hospital: Provavelmente existe alguma internação atribuida a esta consulta - "
								+ mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}
	}
}

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

import br.com.dao.HospitalDAO;
import br.com.dao.MedicoDAO;
import br.com.dao.UsuarioDAO;
import br.com.dao.UsuarioDAO;
import br.com.model.Hospital;
import br.com.model.Medico;
import br.com.model.Usuario;
import br.com.dao.UsuarioDAO;
import br.com.model.Usuario;

/**
 * Servlet implementation class ControladorCadUsuario
 */
@WebServlet("/ControladorHospital")
public class ControladorHospital extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://localhost:3306/consultorio";
	static String usuario = "root";
	static String senha = "";
	static Connection conexao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorHospital() {
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
		String nome = request.getParameter("nome");
		String bairro = request.getParameter("bairro");
		String endereco = request.getParameter("endereco");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String pais = request.getParameter("pais");
		int idFormulario = Integer.parseInt(request.getParameter("idFormulario"));

		if(idFormulario == 2) {
			Hospital hospital = new Hospital(nome, endereco, bairro, cidade, estado, pais);
			HospitalDAO hospitalDAO = new HospitalDAO();
			try {
				hospitalDAO.inserir(hospital);
				session.setAttribute("mensagem", "Cadastro realizado com sucesso!");
			} catch (SQLException | RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem", "Erro ao cadastrar: " + mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}
		
		else if (idFormulario == 3) {
			int idHospital = Integer.parseInt(request.getParameter("idHospital"));
			Hospital hospital = new Hospital(idHospital, nome, endereco, bairro, cidade, estado, pais);
			HospitalDAO hospitalDAO = new HospitalDAO();
			try {
				hospitalDAO.alterar(hospital);
				session.setAttribute("mensagem", "Cadastro alterado com sucesso!");
			} catch (SQLException | RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem", "Erro ao atualizar dados: " + mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}
		
		else if (idFormulario == 4) {
			int idHospital = Integer.parseInt(request.getParameter("idHospital"));
			HospitalDAO hospitalDAO = new HospitalDAO();
			try {
				hospitalDAO.excluir(idHospital);
				session.setAttribute("mensagem", "Hospital foi excluido do sistema!");
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem", "Erro ao excluir hospital: Provavelmente existe alguma consulta atribuida a este hospital - " + mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}

	}

}

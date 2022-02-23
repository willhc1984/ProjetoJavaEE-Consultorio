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

import br.com.dao.EnderecoDAO;
import br.com.dao.MedicoDAO;
import br.com.dao.PacienteDAO;
import br.com.dao.TelefoneDAO;
import br.com.dao.UsuarioDAO;
import br.com.model.Endereco;
import br.com.model.Medico;
import br.com.model.Paciente;
import br.com.model.Telefone;
import br.com.model.Usuario;

/**
 * Servlet implementation class ControladorCadPaciente
 */
@WebServlet("/ControladorMedico")
public class ControladorMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://localhost:3306/consultorio";
	static String usuario = "root";
	static String senha = "";
	static Connection conexao;

	/**
	 * Default constructor.
	 */
	public ControladorMedico() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

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
		String sexo = request.getParameter("sexo");
		String especialidade = request.getParameter("especialidade");
		String funcionario = request.getParameter("funcionario");
		String contato = request.getParameter("contato");
		int idFormulario = Integer.parseInt(request.getParameter("idFormulario"));

		if (idFormulario == 2) {
			Medico medico = new Medico(nome, sexo, especialidade, funcionario, contato);
			MedicoDAO medicoDAO = new MedicoDAO();
			try {
				medicoDAO.inserir(medico);
				session.setAttribute("mensagem", "Cadastro realizado com sucesso!");
			} catch (SQLException | RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem", "Erro ao cadastrar: " + mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}

		else if (idFormulario == 3) {
			int idMedico = Integer.parseInt(request.getParameter("idMedico"));
			Medico medico = new Medico(idMedico, nome, sexo, especialidade, funcionario, contato);
			MedicoDAO medicoDAO = new MedicoDAO();
			try {
				medicoDAO.alterar(medico);
				session.setAttribute("mensagem", "Cadastro alterado com sucesso!");
			} catch (SQLException | RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem", "Erro ao atualizar dados: " + mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}

		else if (idFormulario == 4) {
			int idMedico = Integer.parseInt(request.getParameter("idMedico"));
			MedicoDAO medicoDAO = new MedicoDAO();
			try {
				medicoDAO.excluir(idMedico);
				session.setAttribute("mensagem", "Medico foi excluido do sistema!");
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem", "Erro ao excluir médico: " + mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}

	}
}

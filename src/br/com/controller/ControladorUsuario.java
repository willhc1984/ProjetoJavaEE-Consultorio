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

import br.com.dao.UsuarioDAO;
import br.com.dao.UsuarioDAO;
import br.com.model.Usuario;
import br.com.dao.UsuarioDAO;
import br.com.model.Usuario;

/**
 * Servlet implementation class ControladorCadUsuario
 */
@WebServlet("/ControladorUsuario")
public class ControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://localhost:3306/consultorio";
	static String usuario = "root";
	static String senha = "123";
	static Connection conexao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorUsuario() {
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
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nivel_acesso = request.getParameter("nivel");
		int idFormulario = Integer.parseInt(request.getParameter("idFormulario"));

		if (idFormulario == 1) {
			try {
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = usuarioDAO.consultar(login, senha);
				if (usuario != null) {
					session.setAttribute("mensagem", "Usuário autenticado!");
					session.setAttribute("nome", usuario.getNome());
					session.setAttribute("autenticado", "true");
					response.sendRedirect("telas/adm-principal.jsp");
				} else {
					session.setAttribute("mensagem", "Usuário não autenticado!");
					session.setAttribute("autenticado", "false");
					response.sendRedirect("http://localhost:8080/Consultorio2/resultado-login.jsp");
				}
			} catch (Exception e) {
				// TODO: handle exception
				session.setAttribute("mensagem", "Usuário não autenticado! - " + e);
				session.setAttribute("autenticado", "false");
				response.sendRedirect("http://localhost:8080/Consultorio2/resultado-login.jsp");
			}
		}

		else if (idFormulario == 2) {
			Usuario usuario = new Usuario(nome, login, senha, nivel_acesso);
			System.out.println(usuario);
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			try {
				usuarioDAO.inserir(usuario);
				session.setAttribute("mensagem", "Cadastro realizado com sucesso!");
			} catch (SQLException | RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem", "Erro ao cadastrar: " + mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}

		else if (idFormulario == 3) {
			int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
			Usuario usuario = new Usuario(idUsuario, nome, login, senha, nivel_acesso);
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			try {
				usuarioDAO.alterar(usuario);
				session.setAttribute("mensagem", "Cadastro alterado com sucesso!");
			} catch (SQLException | RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem", "Erro ao atualizar dados: " + mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}

		else if (idFormulario == 4) {
			int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			try {
				usuarioDAO.excluir(idUsuario);
				session.setAttribute("mensagem", "Usuario foi excluido do sistema!");
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem", "Erro ao excluir usuário: " + mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}
	}
}

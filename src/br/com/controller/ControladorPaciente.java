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
import br.com.dao.PacienteDAO;
import br.com.dao.TelefoneDAO;
import br.com.dao.UsuarioDAO;
import br.com.model.Endereco;
import br.com.model.Paciente;
import br.com.model.Telefone;
import br.com.model.Usuario;

/**
 * Servlet implementation class ControladorCadPaciente
 */
@WebServlet("/ControladorPaciente")
public class ControladorPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://localhost:3306/consultorio";
	static String usuario = "root";
	static String senha = "";
	static Connection conexao;

	/**
	 * Default constructor.
	 */
	public ControladorPaciente() {
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
		String endereco = request.getParameter("endereco");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String pais = request.getParameter("pais");
		String sexo = request.getParameter("sexo");
		String email = request.getParameter("email");
		String data = request.getParameter("data");
		String numero = request.getParameter("numero");
		String tipo = request.getParameter("tipo");
		int idFormulario = Integer.parseInt(request.getParameter("idFormulario"));

		/*
		 * obs..: essas transações deveriam ser realizadas de forma atomica, em caso de
		 * erro seria necessario efetuar o rollback. Como o jdbc nao oferece esse
		 * recurso, os possiveis erros na aplicações foram travadas na camada view -
		 * front end.
		 */
		
		if(idFormulario == 2) {
			try {
				Paciente paciente = new Paciente(nome, sexo, email, data);
				PacienteDAO pacienteDAO = new PacienteDAO();
				pacienteDAO.inserir(paciente);
				int id_paciente = pacienteDAO.getLastId();
				
				Endereco end = new Endereco(endereco, bairro, cidade, estado, pais, id_paciente);
				EnderecoDAO endDAO = new EnderecoDAO();
				endDAO.inserir(end);			

				Telefone telefone = new Telefone(numero, tipo, id_paciente);
				TelefoneDAO telefoneDAO = new TelefoneDAO();
				telefoneDAO.inserir(telefone);	
				
				session.setAttribute("mensagem", "Cadastro realizado com sucesso!");
			} catch (SQLException | RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				String mensagem = e.getMessage();
				session.setAttribute("mensagem", "Erro ao cadastrar: " + mensagem);
			}
			response.sendRedirect("telas/resultado.jsp");
		}
		
		else if (idFormulario == 3) {
			int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
			Paciente paciente = new Paciente(idPaciente, nome, sexo, email, data);
			PacienteDAO pacienteDAO = new PacienteDAO();
			
			int idEndereco = Integer.parseInt(request.getParameter("idEndereco"));
			int idPacienteEndereco = Integer.parseInt(request.getParameter("idPacienteEndereco"));
			Endereco end = new Endereco(idEndereco, endereco, bairro, cidade, estado, pais, idPacienteEndereco);
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			
			int idTelefone = Integer.parseInt(request.getParameter("idTelefone"));
			int idPacienteTelefone = Integer.parseInt(request.getParameter("idPacienteTelefone"));
			Telefone telefone = new Telefone(idTelefone, numero, tipo, idPacienteTelefone);
			TelefoneDAO telefoneDAO = new TelefoneDAO();
			
			try {
				pacienteDAO.alterar(paciente);
				enderecoDAO.alterar(end);
				telefoneDAO.alterar(telefone);				
				session.setAttribute("mensagem", "Cadastro alterado com sucesso!");
			} catch (SQLException | RuntimeException e) {
				// TODO Auto-generated catch block
				String mensagem = e.getMessage();
				session.setAttribute("mensagem", "Erro ao atualizar dados: " + mensagem);
				e.printStackTrace();
			}
			response.sendRedirect("telas/resultado.jsp");
		}
		/*
		 * PacienteDAO.conectar(); Paciente paciente = new Paciente(nome, sexo, email,
		 * data); System.out.println(paciente); PacienteDAO.inserir(paciente);
		 * 
		 * EnderecoDAO.conectar(); int lastId = PacienteDAO.getLastId(); Endereco end =
		 * new Endereco(endereco, bairro, cidade, estado, pais, lastId);
		 * EnderecoDAO.inserir(end); System.out.println(lastId);
		 * 
		 * TelefoneDAO.conectar(); Telefone telefone = new Telefone(numero, tipo,
		 * lastId); TelefoneDAO.inserir(telefone);
		 * 
		 * PacienteDAO.desconectar(); EnderecoDAO.desconectar();
		 * TelefoneDAO.desconectar();
		 * 
		 * session.setAttribute("mensagem", "Cadastro realizado com sucesso!");
		 */

	}

}

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="br.com.dao.PacienteDAO"%>
<%@ page import="br.com.model.Paciente"%>
<%@ page import="br.com.dao.MedicoDAO"%>
<%@ page import="br.com.model.Medico"%>
<%@ page import="br.com.dao.HospitalDAO"%>
<%@ page import="br.com.model.Hospital"%>
<%@ page import="br.com.dao.ConsultaDAO"%>
<%@ page import="br.com.model.Consulta"%>
<%@ page import="br.com.dao.InternacaoDAO"%>
<%@ page import="br.com.model.Internacao"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.List"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="../css/rodape-adm.css" rel="stylesheet" type="text/css">
<link href="../css/cabecalho.css" rel="stylesheet" type="text/css">
<link href="../css/forms.css" rel="stylesheet" type="text/css">

<title>O seu Plano de Saúde!</title>
</head>

<body>

	<%@ include file="../css/cabecalho-adm.jsp"%>
	<div class="gambiarra"></div>



	<!-- HTML Form (wrapped in a .bootstrap-iso div) -->
	<div class="bootstrap-iso">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6 col-md-offset-3 col-sm-6 col-xs-12">
					<div class="formden_header">
						<h2>Alteração da internação de paciente</h2>
						<p></p>
					</div>

					<%
						Class.forName("com.mysql.jdbc.Driver"); //Descobrindo o driver		

						PacienteDAO pacienteDAO = new PacienteDAO();
						List<Paciente> pacientes = pacienteDAO.consultarTodos();
						request.setAttribute("pacientes", pacientes);

						MedicoDAO medicoDAO = new MedicoDAO();
						List<Medico> medicos = medicoDAO.consultarTodos();
						request.setAttribute("medicos", medicos);

						HospitalDAO hospitalDAO = new HospitalDAO();
						List<Hospital> hospitais = hospitalDAO.consultarTodos();
						request.setAttribute("hospitais", hospitais);

						ConsultaDAO consultaDAO = new ConsultaDAO();
						List<Consulta> consultas = consultaDAO.consultarTodos();
						request.setAttribute("consultas", consultas);

						/*int idConsulta = Integer.parseInt(request.getParameter("idConsulta"));
						Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio", "root", "");
						String query = "select c.idconsulta, p.idpaciente, p.nome, m.idmedico, m.nome, h.idhospital, h.nome, c.data, c.diagnostico from consulta c inner join paciente p on c.id_paciente = p.idpaciente inner join medico m on c.id_medico = m.idmedico inner join hospital h	on c.id_hospital = h.idhospital	where idconsulta = "
								+ idConsulta + ";";
						Statement stmt = conexao.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						Consulta consulta = null;*/

						int idInternacao = Integer.parseInt(request.getParameter("idInternacao"));
						Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio", "root", "");
						String query = "select * from internacao where idinternacao = " + idInternacao + "";
						Statement stmt = conexao.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						Internacao internacao = null;

						while (rs.next()) {
							internacao = new Internacao(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
									rs.getInt(6));
						}
						request.setAttribute("internacao", internacao);
					%>

					<form class="form-horizontal" method="post"
						action="http://localhost:8080/Consultorio2/ControladorInternacao">
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField"
								for="idConsulta">ID da Consulta <span
								class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<select class="select form-control" id="idConsulta"
									name="idConsulta" required readonly>

									<c:forEach var="row" items="${consultas}">
										<option value="${row.idConsulta}">${row.idConsulta}</option>
									</c:forEach>
									<option value="${internacao.idConsulta}" selected>${internacao.idConsulta}</option>

								</select>
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="quarto">
								Quarto <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<div class="col-sm-10">
									<input class="form-control" id="quato" name="quarto"
										placeholder="quarto do pacientel" type="number" value="${internacao.quarto}" required />
								</div>
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField"
								for="dataEntrada"> Data de entrada <span
								class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="dataEntrada" name="dataEntrada"
									placeholder="data de entrada no hospital" type="date" required />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField"
								for="dataSaida"> Data de saida <span
								class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="dataSaida" name="dataSaida"
									placeholder="data de saida do hospital" type="date" required />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="obs">
								Observações<span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="obs" name="obs"
									placeholder="observações" type="text-area"
									value="${internacao.obs}" required />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-10 col-sm-offset-2">
								<button class="btn btn-primary btn-lg outline" name="submit"
									type="submit">Alterar</button>
								<input type="hidden" name="idFormulario" value="3">
								<input type="hidden" name="idInternacao" value="${internacao.idInternacao}">
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>

	<%@ include file="../css/rodape-adm.jsp"%>

	<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>

</body>


</html>
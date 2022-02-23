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
						<h2>Alteração de consulta</h2>
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
						
						int idConsulta = Integer.parseInt(request.getParameter("idConsulta"));
						Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio", "root", "");
						String query = "select c.idconsulta, p.idpaciente, p.nome, m.idmedico, m.nome, h.idhospital, h.nome, c.data, c.diagnostico from consulta c inner join paciente p on c.id_paciente = p.idpaciente inner join medico m on c.id_medico = m.idmedico inner join hospital h	on c.id_hospital = h.idhospital	where idconsulta = " + idConsulta + ";";
						Statement stmt = conexao.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						Consulta consulta = null;
						while(rs.next()){							
							consulta = new Consulta(rs.getInt(1), rs.getInt(2), rs.getInt(4), rs.getInt(6), rs.getString(8), rs.getString(9));
						}
						request.setAttribute("consulta", consulta);
						System.out.println(query);
						System.out.println(consulta);
						
						/*System.out.println(idConsulta);
						System.out.println(query);
						Statement stmt = conexao.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						Consulta consulta = null;
						while(rs.next()){							
							consulta = new Consulta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6));
						}
						request.setAttribute("consulta", consulta);*/
								
					%>

					<form class="form-horizontal" method="post"	action="http://localhost:8080/Consultorio2/ControladorConsulta">
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField"
								for="idPaciente"> Paciente <span class="asteriskField">
									* </span>
							</label>
							<div class="col-sm-10">
								<select class="select form-control" id="idPaciente"
									name="idPaciente" required>

									<c:forEach var="row" items="${pacientes}">
										<option value="${row.idPaciente}" required>${row.idPaciente} - ${row.nome}</option>										
									</c:forEach>
									<option value="${consulta.idPaciente}" selected>${consulta.idPaciente}</option>
								</select>
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField"
								for="idMedico"> M&eacute;dico <span
								class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<select class="select form-control" id="idMedico"
									name="idMedico" required>
									<c:forEach var="row" items="${medicos}">
										<option value="${row.idMedico}">${row.idMedico}-
											${row.nome}</option>
									</c:forEach>
									<option value="${consulta.idMedico}" selected>${consulta.idMedico}</option>
									
								</select>
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField"
								for="idHospital"> Hospital <span class="asteriskField">
									* </span>
							</label>
							<div class="col-sm-10">
								<select class="select form-control" id="idHospital"
									name="idHospital" required>
									<c:forEach var="row" items="${hospitais}">
										<option value="${row.idHospital}">${row.idHospital}-
											${row.nome}</option>
									</c:forEach>
									<option value="${consulta.idHospital}" selected>${consulta.idHospital}</option>
								</select>
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="data">
								Data <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="data" name="data"
									placeholder="selecione a data da consulta" type="date" required value="${consulta.data}" />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField"
								for="diagnostico"> Diagnóstico <span
								class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="diagnostico" name="diagnostico"
									placeholder="diagnostico da consulta" type="text" required value="${consulta.diagnostico}" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10 col-sm-offset-2">
								<button class="btn btn-primary btn-lg outline" name="submit"
									type="submit">Alterar</button>
								<input type="hidden" name="idFormulario" value="3">
								<input type="hidden" name="idConsulta" value="${consulta.idConsulta }">								
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
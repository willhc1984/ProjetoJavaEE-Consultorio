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

<title>O seu Plano de Saude!</title>
</head>

<body>

	<%@ include file="../css/cabecalho-adm.jsp"%>
	<div class="gambiarra"></div>

	<%
		Class.forName("com.mysql.jdbc.Driver"); //Descobrindo o driver	
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "123");
		String consulta = 
				"select p.nome, p.email, e.endereco, e.bairro, e.cidade, t.numero, t.tipo, p.idpaciente, e.idendereco, t.idtelefone from paciente p inner join endereco e	on p.idpaciente = e.id_paciente	inner join telefone t on p.idpaciente = t.id_paciente;";
		Statement stmt = conexao.createStatement();
		ResultSet rs = stmt.executeQuery(consulta);
	%>

	<div class="bootstrap-iso">
		<div class="container">
			<h1>Relatório de pacientes</h1>
			<table class="table table-bordered">
				<thead>
					<tr>
						<TH>NOME</TH>
						<TH>EMAIL</TH>						
						<TH>ENDERECO</TH>
						<TH>BAIRRO</TH>
						<TH>CIDADE</TH>
						<TH>CONTATO</TH>
						<TH>TIPO</TH>
						<TH>OPÇÕES</TH>
					</tr>
				</thead>
				<tbody>
					<%
						while (rs.next()) {
					%>
					<TR>
						<TD><%=rs.getString(1)%></TD>
						<TD><%=rs.getString(2)%></TD>
						<TD><%=rs.getString(3)%></TD>
						<TD><%=rs.getString(4)%></TD>
						<TD><%=rs.getString(5)%></TD>
						<TD><%=rs.getString(6)%></TD>
						<TD><%=rs.getString(7)%></TD>
						<TD>
							<form method="post"
								action="http://localhost:8080/Consultorio2/ControladorPaciente">
							<a href="http://localhost:8080/Consultorio2/telas/edit_paciente.jsp?idPaciente=<%=rs.getInt(8)%>&idEndereco=<%=rs.getInt(9)%>&idTelefone=<%=rs.getInt(10)%>"><button
									type="button" class="btn btn-default">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true">
								</button></a>							

								<input type="hidden" name="idFormulario" value="4"> <input
									type="hidden" name="idConsulta" value="<%=rs.getInt(8)%>">

								<button type="submit" class="btn btn-default">
									<span class="glyphicon glyphicon-trash" aria-hidden="true">
								</button>
							</form>
						</TD>
					</TR>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>




	<%@ include file="../css/rodape-adm.jsp"%>

	<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
</body>


</html>
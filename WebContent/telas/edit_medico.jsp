<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<%@ page import="br.com.model.Medico"%>
<%@ page import="br.com.dao.MedicoDAO"%>

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

	<div class="bootstrap-iso">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6 col-md-offset-3 col-sm-6 col-xs-12">
					<div class="formden_header">
						<h2>Alterar cadastro de médico</h2>
						<p></p>
					</div>
					
					<%
						Class.forName("com.mysql.jdbc.Driver"); //Descobrindo o driver				 
						int idMedico = Integer.parseInt(request.getParameter("idMedico"));
						MedicoDAO medicoDAO = new MedicoDAO();
						Medico medico = medicoDAO.consultarId(idMedico);
						request.setAttribute("medico", medico);				
					%>
					
					<form class="form-horizontal" method="post"
						action="http://localhost:8080/Consultorio2/ControladorMedico">
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField"
								for="medico"> Nome <span class="asteriskField">
									* </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="nome" name="nome"
									placeholder="nome do medico" type="text" value="${medico.nome}" />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField"> Sexo
								<span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<div class="radio">
									<label class="radio"> <input name="sexo" type="radio"
										value="M" /> Masculino
									</label>
								</div>
								<div class="radio">
									<label class="radio"> <input name="sexo" type="radio"
										value="F" /> Feminino
									</label>
								</div>
								<div class="radio">
									<label class="radio"> <input name="sexo" type="radio"
										value="?" /> N&atilde;o informado
									</label>
								</div>
							</div>
						</div>

						<div class="form-group ">
							<label class="control-label col-sm-2" for="select">
								Especialidade </label>
							<div class="col-sm-10">
								<select class="select form-control" id="select" name="especialidade">
									<option value="Cirurgia Geral">Cirurgia Geral</option>
									<option value="Cirurgia Toraxica">Cirurgia Toraxica</option>
									<option value="Psiquiatria">Psiquiatria</option>
									<option value="Patologia">Patologia</option>
									<option value="Second Choice">Patologia</option>
									<option value="Patologia">Geriatria</option>
									<option value="Cardiologia">Cardiologia</option>
									<option value="Cirurgia Plastica">Cirurgia Plastica</option>
									<option value="Endócrinologia">Endócrinologia</option>
								</select>
							</div>
						</div>

						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField">
								Funcion&aacute;rio? <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<div class="radio">
									<label class="radio"> <input name="funcionario"
										type="radio" value="S" /> Sim
									</label>
								</div>
								<div class="radio">
									<label class="radio"> <input name="funcionario"
										type="radio" value="N" /> N&atilde;o
									</label>
								</div>
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2" for="contato">
								Contato </label>
							<div class="col-sm-10">
								<input class="form-control" id="contato" name="contato"
									placeholder="digite um contato para o medico" type="text" alue="${medico.contato}" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10 col-sm-offset-2">
								<button class="btn btn-primary btn-lg outline" name="submit"
									type="submit">Alterar</button>
									<input type="hidden" name="idFormulario" value="3">
									<input type="hidden" name="idMedico" value="${medico.idMedico}">
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
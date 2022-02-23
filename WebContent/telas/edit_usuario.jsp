
<%@page import="br.com.dao.UsuarioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.sql.*"%>

<%@ page import="br.com.dao.UsuarioDAO"%>
<%@ page import="br.com.model.Usuario"%>


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

<title>Consultório Odonto Pratic!</title>
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
						<h2>Editar usu&aacute;rio de sistema</h2>
						<p></p>
					</div>

					<%
						Class.forName("com.mysql.jdbc.Driver"); //Descobrindo o driver				 
						int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
						UsuarioDAO usuarioDAO = new UsuarioDAO();
						Usuario usuario = usuarioDAO.consultarId(idUsuario);
						request.setAttribute("usuario", usuario);				
					%>

					<form class="form-horizontal" method="post"
						action="http://localhost:8080/Consultorio2/ControladorUsuario">
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="nome">
								Nome <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="nome" name="nome"
									placeholder="nome do usuario" type="text" value="${usuario.nome}" />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2" for="login"> Login
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="especialidade" name="login"
									placeholder="login do usuario" type="text" value="${usuario.login}" />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="senha">
								Senha <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="senha" name="senha"
									placeholder="digite uma senha" type="password" value="${usuario.senha}" />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2"> Nivel de acesso </label>
							<div class="col-sm-10">
								<div class="radio">
									<label class="radio"> <input name="nivel" type="radio"
										value="Administrador" /> Administrador
									</label>
								</div>
								<div class="radio">
									<label class="radio"> <input name="nivel" type="radio"
										value="Usuario" selected /> Usuario
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10 col-sm-offset-2">
								<button class="btn btn-primary btn-lg outline" name="submit"
									type="submit">Cadastrar</button>
								<input type="hidden" name="idUsuario" value="${usuario.idusuario}">
								<input type="hidden" name="idFormulario" value="3">
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
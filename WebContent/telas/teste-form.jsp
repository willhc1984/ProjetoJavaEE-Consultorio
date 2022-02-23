<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpSession"%>


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
<link href="../css/principal.css" rel="stylesheet" type="text/css">

<title>Consultório Odonto Pratic!</title>
</head>

<body>

	<%@ include file="../css/cabecalho-adm.jsp"%>
	<div class="gambiarra"></div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 col-md-offset-3 col-sm-6 col-xs-12">
				<form method="post">
					<div class="form-group ">
						<label class="control-label requiredField" for="paciente">
							Nome <span class="asteriskField"> * </span>
						</label> <input class="form-control" id="paciente" name="paciente"
							placeholder="nome do paciente" type="text" />
					</div>
					<div class="form-group ">
						<label class="control-label requiredField" for="endereco">
							Endere&ccedil;o <span class="asteriskField"> * </span>
						</label> <input class="form-control" id="endereco" name="endereco"
							placeholder="rua, avenida, logradouro..." type="text" />
					</div>
					<div class="form-group ">
						<label class="control-label requiredField" for="bairro">
							Bairro <span class="asteriskField"> * </span>
						</label> <input class="form-control" id="bairro" name="bairro"
							placeholder="digite o nome do bairro" type="text" />
					</div>
					<div class="form-group ">
						<label class="control-label requiredField" for="name3">
							Cidade <span class="asteriskField"> * </span>
						</label> <input class="form-control" id="name3" name="name3"
							placeholder="digite a cidade" type="text" />
					</div>
					<div class="form-group ">
						<label class="control-label requiredField" for="select">
							Estado <span class="asteriskField"> * </span>
						</label> <select class="select form-control" id="select" name="select">
							<option value="SP">SP</option>
							<option value="MG">MG</option>
							<option value="RJ">RJ</option>
							<option value="MS">MS</option>
							<option value="PR">PR</option>
							<option value="RS">RS</option>
							<option value="AM">AM</option>
							<option value="TO">TO</option>
						</select>
					</div>
					<div class="form-group">
						<div>
							<button class="btn btn-primary " name="submit" type="submit">
								Cadastrar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<%@ include file="../css/rodape-adm.jsp"%>

	<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>

</body>


</html>
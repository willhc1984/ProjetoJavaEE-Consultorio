<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="br.com.dao.HospitalDAO"%>
<%@ page import="br.com.model.Hospital"%>


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
						<h2>Alterar cadastro de hospital</h2>
						<p></p>
					</div>
					
					<%
						Class.forName("com.mysql.jdbc.Driver"); //Descobrindo o driver				 
						int idHospital = Integer.parseInt(request.getParameter("idHospital"));
						HospitalDAO hospitalDAO = new HospitalDAO();
						Hospital hospital = hospitalDAO.consultarId(idHospital);
						request.setAttribute("hospital", hospital);				
					%>
					
					<form class="form-horizontal" method="post" action="http://localhost:8080/Consultorio2/ControladorHospital">
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="nome">
								Nome <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="nome" name="nome"
									placeholder="nome do hospital" type="text" value="${hospital.nome}" />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField"
								for="endereco"> Endere&ccedil;o <span
								class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="endereco" name="endereco"
									placeholder="endere&ccedil;o do hospital" type="text" value="${hospital.endereco}" />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="bairro">
								Bairro <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="bairro" name="bairro"
									placeholder="bairro do hospital" type="text" value="${hospital.bairro}" />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="cidade">
								Cidade <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="cidade" name="cidade"
									placeholder="cidade do hospital" type="text" value="${hospital.cidade}" />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="Estado">
								Estado <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<select class="select form-control" id="Estado" name="estado">
									<option value="SP">SP</option>
									<option value="RJ">RJ</option>
									<option value="MG">MG</option>
									<option value="RS">RS</option>
									<option value="PR">PR</option>
									<option value="AM">AM</option>
								</select>
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="pais">
								Pais <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="pais" name="pais"
									placeholder="digite o pais do hospital" type="text" value="${hospital.pais}" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10 col-sm-offset-2">
								<button class="btn btn-primary btn-lg outline" name="submit"
									type="submit">Alterar</button>
									<input type="hidden" name="idFormulario" value="3">
									<input type="hidden" name="idHospital" value="${hospital.idHospital}">
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
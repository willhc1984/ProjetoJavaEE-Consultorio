
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="br.com.dao.PacienteDAO"%>
<%@ page import="br.com.dao.EnderecoDAO"%>
<%@ page import="br.com.dao.TelefoneDAO"%>
<%@ page import="br.com.model.Paciente"%>
<%@ page import="br.com.model.Endereco"%>
<%@ page import="br.com.model.Telefone"%>

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


	<!-- HTML Form (wrapped in a .bootstrap-iso div) -->
	<div class="bootstrap-iso">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6 col-md-offset-3 col-sm-6 col-xs-12">
					<div class="formden_header">
						<h2>Alterar dados do paciente</h2>
						<p></p>
					</div>
					
					<%
						Class.forName("com.mysql.jdbc.Driver"); //Descobrindo o driver				 
						int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
						PacienteDAO pacienteDAO = new PacienteDAO();
						Paciente paciente = pacienteDAO.consultarId(idPaciente);
						request.setAttribute("paciente", paciente);
						//System.out.println(paciente);
						
						Class.forName("com.mysql.jdbc.Driver"); //Descobrindo o driver				 
						int idEndereco = Integer.parseInt(request.getParameter("idEndereco"));
						EnderecoDAO enderecoDAO = new EnderecoDAO();
						Endereco endereco = enderecoDAO.consultarId(idEndereco);
						request.setAttribute("endereco", endereco);
						//System.out.println(endereco);
						
						Class.forName("com.mysql.jdbc.Driver"); //Descobrindo o driver				 
						int idTelefone = Integer.parseInt(request.getParameter("idTelefone"));
						TelefoneDAO telefoneDAO = new TelefoneDAO();
						Telefone telefone = telefoneDAO.consultarId(idTelefone);
						request.setAttribute("telefone", telefone);
						//System.out.println(telefone);
					%>
					
					<form class="form-horizontal" method="post"
						action="http://localhost:8080/Consultorio2/ControladorPaciente">
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField"
								for="paciente"> Nome <span class="asteriskField">
									* </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="paciente" name="nome"
									placeholder="nome do paciente" type="text" maxlength="30" value="${paciente.nome}" />
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
							<label class="control-label col-sm-2" for="email"> Email
								<span class="asteriskField">* 
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="email" name="email"
									placeholder="digite o seu email" type="email" maxlength="30"
									value="${paciente.email}" required />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="date">
								Data de nascimento <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="date" name="data"
									placeholder="M&ecirc;s/Dia/Ano" type="date" value="${paciente.data}" required />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField"
								for="endereco"> Endere&ccedil;o <span
								class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="endereco" name="endereco"
									placeholder="rua, avenida, logradouro..." type="text"
									maxlength="50" value="${endereco.endereco}" />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="bairro">
								Bairro <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="bairro" name="bairro"
									placeholder="digite o nome do bairro" type="text"
									maxlength="15" value="${endereco.bairro}" />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="cidade">
								Cidade <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="name3" name="cidade"
									placeholder="digite a cidade" type="text" maxlength="15" value="${endereco.cidade}" />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="select">
								Estado <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<select class="select form-control" id="select" name="estado">
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
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="pais">
								Pais <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="pais" name="pais"
									placeholder="digite o pais" type="text" maxlength="15" value="${endereco.pais}" />
							</div>
						</div>

						<div class="form-group ">
							<label class="control-label col-sm-2" for="numero">
								Telefone <span class="asteriskField">*
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="numero" name="numero"
									placeholder="numero do telefone" type="text" maxlength="15"
									required value="${telefone.numero}"/>
							</div>
						</div>

						<div class="form-group ">
							<label class="control-label col-sm-2"> Tipo de telefone <span
								class="asteriskField">*</label>
							<div class="col-sm-10">
								<div class="radio">
									<label class="radio"> <input name="tipo" type="radio"
										value="CELULAR" /> Celular
									</label>
								</div>
								<div class="radio">
									<label class="radio"> <input name="tipo" type="radio"
										value="RESIDENCIAL" /> Residencial
									</label>
								</div>
								<div class="radio">
									<label class="radio"> <input name="tipo" type="radio"
										value="COMERCIAL" /> Comercial
									</label>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-10 col-sm-offset-2">
								<button class="btn btn-primary btn-lg outline" name="submit"
									type="submit">Alterar</button>
								<input type="hidden" name="idFormulario" value="3">
								<input type="hidden" name="idPaciente" value="${paciente.idPaciente}">
								<input type="hidden" name="idEndereco" value="${endereco.idEndereco}">
								<input type="hidden" name="idTelefone" value="${telefone.idTelefone}">
								<input type="hidden" name="idPacienteEndereco" value="${endereco.id_paciente}">
								<input type="hidden" name="idPacienteTelefone" value="${telefone.id_paciente}">
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
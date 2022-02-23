
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


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
						<h2>Cadastro de pacientes</h2>
						<p></p>
					</div>
					<form class="form-horizontal" method="post"
						action="http://localhost:8080/Consultorio2/ControladorPaciente">
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField"
								for="paciente"> Nome <span class="asteriskField">
									* </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="paciente" name="nome"
									placeholder="nome do paciente" type="text" maxlength="30" />
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
									required />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="date">
								Data de nascimento <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="date" name="data"
									placeholder="M&ecirc;s/Dia/Ano" type="date" required />
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
									maxlength="50" />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="bairro">
								Bairro <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="bairro" name="bairro"
									placeholder="digite o nome do bairro" type="text"
									maxlength="15" />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="cidade">
								Cidade <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="name3" name="cidade"
									placeholder="digite a cidade" type="text" maxlength="15" />
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
									placeholder="digite o pais" type="text" maxlength="15" />
							</div>
						</div>

						<div class="form-group ">
							<label class="control-label col-sm-2" for="numero">
								Telefone <span class="asteriskField">*
							</label>
							<div class="col-sm-10">
								<input class="form-control" id="numero" name="numero"
									placeholder="numero do telefone" type="text" maxlength="15"
									required />
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
									type="submit">Cadastrar</button>
								<input type="hidden" name="idFormulario" value="2">
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
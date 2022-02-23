<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css"> 
	<link href="css/signin.css" rel="stylesheet" type="text/css"> 
	
	<title>Plano de Saude</title>
</head>

<body style="background-image: url(img/convenio2.jpg); background-size: cover">	
	<div class="container">
	    <div class="row vertical-offset-100">
	        <div class="col-md-4 col-md-offset-4">
	            <div class="panel panel-default">
	                <div class="panel-heading">                                
	                    <div class="row-fluid user-row">
	                        <img src="img/conveniologo.png" class="img-responsive" alt="Conxole Admin"/>
	                        <h3 class="text-center">MediSan</h3>
	                        <p align="center">Entrar no sistema de gerenciamento</p>
	                    </div>
	                </div>
	                <div class="panel-body">
	                    <form accept-charset="UTF-8" role="form" class="form-signin" action="http://localhost:8080/Consultorio2/ControladorUsuario" method="post">
	                        <fieldset>
	                            <label class="panel-login">
	                                <div class="login_result"></div>
	                            </label>
	                            <input class="form-control" placeholder="Login" id="login" type="text" name="login">
	                            <input class="form-control" placeholder="Senha" id="senha" type="password" name="senha">
	                            <br></br>
	                            <input class="btn btn-lg btn-success btn-block" type="submit" id="login" value="Entrar »">
	                            <input type="hidden" name="idFormulario" value="1">
	                        </fieldset>
	                    </form>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	
</body>


</html>
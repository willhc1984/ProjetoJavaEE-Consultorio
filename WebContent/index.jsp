<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Tela principal</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/rodape.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="container-fluid">
		<!-- Topper w/ logo 
		<div class="row hidden-xs topper">
			<div class="col-xs-7 col-sm-7">
				<a href="#"><img am-TopLogo alt="logo da empresa"
					src="img/odontologo.jpg" class="img-responsive"></a>
			</div>
			<div class="col-xs-5 col-xs-offset-1 col-sm-5 col-sm-offset-0 text-right ">
				<p am-CallNow>Tel..: 15 3225-7856</p>
			</div>
		</div>
		<!-- End Topper -->

		<!-- Navigation -->
		<div class="row">
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">

					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex1-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand visible-xs-inline-block nav-logo" href="/"><img
						src="/images/logo-dark-inset.png" class="img-responsive" alt=""></a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-ex1-collapse">

					<ul class="nav navbar-nav js-nav-add-active-class">
						<li><a href="#"><img alt="logo da empresa"
								src="i#" class="img-responsive"></a></li>
						<li><a href="/index.html">Home</a></li>
						<li class="active"><a href="/markets.html">O Consultório</a></li>
						<li><a href="/buy.html">Tratamentos</a></li>
						<li><a href="/svstrike.html">Videos</a></li>
						<li><a href="/training.html">Depoimentos</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Empresa <b class="caret"></b></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="about.html">Sobre Nós</a></li>
								<li><a href="careers.html">Contato</a></li>
								<li><a href="press-release.html">Trabalhe Conosco</a></li>
							</ul></li>
					</ul>

				</div>
				<!-- /.navbar-collapse -->
			</div>
			</nav>
		</div>
	</div>

	<!-- Carrossel -->
	<div class="gambiarra"></div>
	<div class="container hidden-xs">
		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="img/carrossel1.jpg" alt="...">
					<div class="carousel-caption">...</div>
				</div>
				<div class="item">
					<img src="img/carrossel2.jpg" alt="...">
					<div class="carousel-caption">...</div>
				</div>
				<div class="item">
					<img src="img/carrossel3.jpg" alt="...">
					<div class="carousel-caption">...</div>
				</div>
			</div>

			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	
	<div class="gambiarra"></div>
	
	<%@ include file="css/rodape.jsp"%>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->

	<!-- For the demo ad only -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

	<!-- Include all compiled plugins (below), or include individual files as needed -->

</body>

</html>
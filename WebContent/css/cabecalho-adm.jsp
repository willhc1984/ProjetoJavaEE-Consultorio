
<%
	if (session.getAttribute("autenticado") != "true") {
		session.setAttribute("mensagem", "Usuário não autenticado. Favor se autenticar!");
		response.sendRedirect("http://localhost:8080/Consultorio2/resultado-login.jsp");
%>

<%
	}
%>

<div class="navbar-wrapper">
	<div class="container-fluid">
		<nav class="navbar navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"><span class="glyphicon glyphicon-header" aria-hidden="true"></span></a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="../telas/adm-principal.jsp"
							class="">Home</a></li>
						<li class=" dropdown"><a href="#" class="dropdown-toggle "
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Cadastros <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="../telas/cad_paciente.jsp">Paciente</a></li>
								<li><a href="../telas/cad_medico.jsp">Medico</a></li>
								<li><a href="../telas/cad_hospital.jsp">Hospital</a></li>
								<li><a href="../telas/cad_consulta.jsp">Consulta</a></li>
								<li><a href="../telas/cad_internacao.jsp">Internação</a></li>
								<li><a href="../telas/cad_usuario.jsp">Usuario</a></li>
							</ul></li>
						<li class=" dropdown"><a href="#" class="dropdown-toggle "
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Relatórios <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="../telas/rel_paciente.jsp">Paciente</a></li>
								<li><a href="../telas/rel_medico.jsp">Medico</a></li>
								<li><a href="../telas/rel_hospital.jsp">Hospital</a></li>
								<li><a href="../telas/rel_consulta.jsp">Consulta</a></li>
								<li><a href="../telas/rel_internacao.jsp">Internação</a></li>
								<li><a href="../telas/rel_usuario.jsp">Usuario</a></li>
							</ul></li>


					</ul>
					<ul class="nav navbar-nav pull-right">
						<li class=""><a href="#">${nome}</a></li>
						<li class=""><a href="../logout.jsp">Sair</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</div>

<div class="gambiarra"></div>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.petshop.gerenciador.modelo.Agendamento" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>Pet Care | Horários Marcados</title>
		<link type="text/css" rel="stylesheet" href="./static/css/bootstrap.min.css" />
		<link type="text/css" rel="stylesheet" href="./static/css/personalizacao.css" />
		<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet"/>
		<link rel="shortcut icon" type="image/png" href="./static/image/logo.png"/>
	</head>
	<body>
		<c:if test="${not empty nome }">
			Agendamento ${nome} cadastrado com sucesso!
		</c:if>
		<div id="content-form" class="container justify-content-center">
			<ul class="nav nav-tabs">
				<li class="nav-item">
					<a class="nav-link" href="paginas">Home</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Cliente</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="paginas?acao=InicioCadastroCliente&pacote=cliente.">Cadastrar</a>
						<a class="dropdown-item" href="paginas?acao=ListaClientes&pacote=cliente.">Lista</a>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Veterinario</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="paginas?acao=InicioCadastroVeterinario&pacote=veterinario.">Cadastrar</a>
						<a class="dropdown-item" href="paginas?acao=ListaVeterinarios&pacote=veterinario.">Lista</a>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Pets</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="paginas?acao=InicioCadastroPet&pacote=pet.">Cadastrar</a>
						<a class="dropdown-item" href="paginas?acao=ListaPets&pacote=pet.">Lista</a>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle active" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Consultas</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="paginas?acao=InicioCadastroAgendamento&pacote=agendamento.">Cadastrar</a>
						<a class="dropdown-item" href="paginas?acao=ListaAgendamentos&pacote=agendamento.">Lista</a>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="paginas?acao=Logout">Sair</a>
				</li>		
			</ul>
			<div class="row">
				<h2 class="text-center col-12"><img id="alinhamento-icon" src="./static/image/agendamento.svg">Horários Marcados</h2>
				<ul id="lista" class="col-12">
					<li id="info-lista" class="row">
						<h5 class="col-4 col-md-9">Nome do cliente</h5>
						<h5 class="col-2 col-md-1">Dados</h5>
						<h5 class="col-2 col-md-1">Editar</h5>
						<h5 class="col-2 col-md-1">Excluir</h5>
					</li> 
					<c:forEach items="${listaNome}" var="agendamentos">
						<li class="row">
							<p class="col-4 col-md-9">${agendamentos.idAgendamento} | ${agendamentos.nomeCliente} | ${agendamentos.data} | ${agendamentos.hora}</p>
							<a href="paginas?acao=MostraAgendamento&pacote=agendamento.&tipo=Exibe&id=${agendamentos.idAgendamento}" ><img class="icon-lista" src="./static/image/informacoes.svg"></a>
							<a href="paginas?acao=MostraAgendamento&pacote=agendamento.&tipo=Altera&id=${agendamentos.idAgendamento}" ><img class="icon-lista" src="./static/image/lapis.svg"></a>
							<a href="paginas?acao=RemoveAgendamento&pacote=agendamento.&id=${agendamentos.idAgendamento}"><img class="icon-lista" src="./static/image/lixo.svg">s</a>
						</li> 
					</c:forEach>
				</ul>
			</div>
		</div>
		<script src="./static/js/jquery.js"></script>
		<script src="./static/js/popper.min.js"></script>
		<script src="./static/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$('.dropdown-toggle').dropdown()
		</script>
	</body>
</html>
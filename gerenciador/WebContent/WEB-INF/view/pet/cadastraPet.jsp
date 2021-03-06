<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List,br.com.petshop.gerenciador.modelo.Cliente" %>
<c:url value="/paginas" var="linkServletNovoPet"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>Pet Care | Cadastro de Pet</title>
		<link type="text/css" rel="stylesheet" href="./static/css/bootstrap.min.css" />
		<link type="text/css" rel="stylesheet" href="./static/css/personalizacao.css" />
		<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet"/>
		<link rel="shortcut icon" type="image/png" href="./static/image/logo.png"/>
	</head>
	<body>
		<div id="content-form" class="container justify-content-center">
			<ul class="nav nav-tabs">
				<li class="nav-item">
					<a class="nav-link" href="paginas?acao=Index&pacote=home.">Home</a>
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
					<a class="nav-link dropdown-toggle active" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Pets</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="paginas?acao=InicioCadastroPet&pacote=pet.">Cadastrar</a>
						<a class="dropdown-item" href="paginas?acao=ListaPets&pacote=pet.">Lista</a>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Consultas</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="paginas?acao=InicioCadastroAgendamento&pacote=agendamento.">Cadastrar</a>
						<a class="dropdown-item" href="paginas?acao=ListaAgendamentos&pacote=agendamento.">Lista</a>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="paginas?acao=Logout">Sair</a>
				</li>		
			</ul>
			<form action="${ linkServletNovoPet}" method="post">
				<h2 class="text-center"><img id="alinhamento-icon" src="./static/image/pet.svg">Cadastro de Pet</h2>
				<div class="row">
					<div class="form-group col-12">
						<label for="nomePet">Nome do pet</label>
  						<input id="nomePet" name="nomePet" type="text" class="form-control" required>
					</div>
					<div class="form-group col-12 col-md-6">
						<label for="idDono">Respons�vel</label>
  						<select id="idDono" name="idDono" class="form-control" required>
						    <c:forEach  items="${listaNome}" var="clientes">
						        <option value="<c:out value='${clientes.id}' />"
						            <c:if test="${param.selectValue == clientes})"> selected </c:if>  >
						            <c:out value="${clientes.nome}" />
						        </option>
						    </c:forEach>
						</select>
					</div>
					<div class="form-group col-12 col-md-6">
						<label for="especie">Esp�cie</label>
  						<input id="especie" name="especie" type="text" class="form-control" required>
					</div>
					<div class="form-group col-12 col-md-6">
						<label for="raca">Ra�a</label>
  						<input id="raca" name="raca" type="text" class="form-control" required>
					</div>
					<div class="form-group col-12 col-md-6">
						<label for="porte">Porte</label>
  						<input id="porte" name="porte" type="text" class="form-control" required>
					</div>
					<div class="col-12 col-md-6 offset-md-3 align-self-center">
						<button id="button-style" type="submit" class="btn">Cadastrar</button>
					</div>							
					<input type="hidden" name="pacote" value="pet.">
					<input type="hidden" name="acao" value="NovoPet">
				</div>
			</form>
			<script src="./static/js/jquery.js"></script>
			<script src="./static/js/popper.min.js"></script>
			<script src="./static/js/bootstrap.min.js"></script>
			<script src="./static/js/jquery.mask.min.js"></script>
			<script src="./static/js/jquery.mask.js"></script>
			<script src="./static/js/mascaras.js"></script>
			<script type="text/javascript">
				$('.dropdown-toggle').dropdown()
			</script>
		</div>
	</body>
</html>
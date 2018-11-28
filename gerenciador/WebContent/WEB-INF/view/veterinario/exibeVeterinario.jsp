<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/paginas" var="linkServletAlteraVeterinario"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>Pet Care | Dados do Veterinário</title>
		<link type="text/css" rel="stylesheet" href="./static/css/bootstrap.min.css" />
		<link type="text/css" rel="stylesheet" href="./static/css/personalizacao.css" />
		<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet"/>
		<link rel="shortcut icon" type="image/png" href="./static/image/logo.png"/>
	</head>
	<body>
		<div id="content-form" class="container justify-content-center">
			<ul class="nav nav-tabs">
				<li class="nav-item">
					<a class="nav-link " href="paginas">Home</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Cliente</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="paginas?acao=InicioCadastroCliente&pacote=cliente.">Cadastrar</a>
						<a class="dropdown-item" href="paginas?acao=ListaClientes&pacote=cliente.">Lista</a>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle active" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Veterinario</a>
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
			<form action="${linkServletAlteraVeterinario}" method="post">
				<h2 class="text-center"><img id="alinhamento-icon" src="./static/image/veterinario.svg">Dados de ${veterinario.nomeVeterinario}</h2>
				<div class="row">
					<div class="form-group col-12 align-self-center">
						<label for="nomeVeterinario">Nome do veterinário</label>
  						<input id="nomeVeterinario" name="nomeVeterinario" value="${veterinario.nomeVeterinario}" type="text" class="form-control" disabled>
					</div>
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="cep">CEP</label>
  						<input id="cep" name="cep" value="${veterinario.cep}" type="text" class="form-control" disabled>
					</div>
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="numero">Número</label>
  						<input id="numero" name="numero" value="${veterinario.numero}" type="number" class="form-control" disabled>
					</div>
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="cpfCnpj">CPF/CNPJ</label>
 						<input id="cpfCnpj" name="cpfCnpj" value="${veterinario.cpfCnpj}" type="text" class="form-control" disabled>
					</div>
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="dataNascimento">Data de Nascimento</label>
  						<input id="dataNascimento" name="dataNascimento" value="${veterinario.dataNascimento}" type="date" class="form-control" disabled>
					</div>
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="telefone">Telefone</label>
  						<input id="telefone" name="telefone" value="${veterinario.telefone}" type="tel" class="form-control" disabled>
					</div>
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="celular">Celular</label>
  						<input id="celular" name="celular" value="${veterinario.celular}" type="tel" class="form-control" disabled>
					</div>
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="numeroRegistro">Número de registro</label>
 						<input id="numeroRegistro" name="numeroRegistro" value="${veterinario.numeroRegistro}" type="text" class="form-control" disabled>
					</div>
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="formacao">Formação</label>
 						<input id="formacao" name="formacao" value="${veterinario.formacao}" type="text" class="form-control" disabled>
					</div>
				</div>
			</form>
			<script src="./static/js/jquery.js"></script>
			<script src="./static/js/popper.min.js"></script>
			<script src="./static/js/bootstrap.min.js"></script>
			<script type="text/javascript">
				$('.dropdown-toggle').dropdown()
			</script>
		</div>
	</body>
</html>
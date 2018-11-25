<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/paginas" var="linkServletNovoCliente"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>Pet Care | Cadastro de Cliente</title>
		<link type="text/css" rel="stylesheet" href="./static/css/bootstrap.min.css" />
		<link type="text/css" rel="stylesheet" href="./static/css/personalizacao.css" />
		<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet"/>
		<link rel="shortcut icon" type="image/png" href="./static/image/logo.png"/>
	</head>
	<body>
		<a href="paginas?acao=Logout">Sair</a>
		<div id="content-form" class="container justify-content-center">
			<form action="${ linkServletNovoCliente}" method="post">
				<div class="row">
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="nome">Nome</label>
  							<input id="nome" name="nome" type="text" class="form-control">
					</div>
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="telefone">Telefone</label>
  							<input id="telefone" name="telefone" type="tel" class="form-control">
					</div>
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="celular">Celular</label>
  							<input id="celular" name="celular" type="tel" class="form-control">
					</div>
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="dataNascimento">Data de Nascimento</label>
  							<input id="dataNascimento" name="dataNascimento" type="date" class="form-control">
					</div>
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="cpfCnpj">CPF/CNPJ</label>
  							<input id="cpfCnpj" name="cpfCnpj" type="text" class="form-control">
					</div>
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="cep">CEP</label>
  							<input id="cep" name="cep" type="text" class="form-control">
					</div>
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="numeroEndereco">Número</label>
  							<input id="numeroEndereco" name="numeroEndereco" type="number" class="form-control">
					</div>
					<div class="form-group col-12 col-md-6 align-self-center">
						<label for="planoSaude">Plano de saúde</label>
  							<input id="planoSaude" name="planoSaude" type="text" class="form-control">
					</div>						
					<input type="hidden" name="pacote" value="cliente.">
					<div class="col-12 col-md-6 offset-md-3 align-self-center">
						<button id="button-style" type="submit" class="btn">Cadastrar</button>
					</div>
					<input type="hidden" name="acao" value="NovoCliente">
				</div>	
			</form>
			<script type="text/javascript" src="./static/js/jquery.js"></script>
			<script type="text/javascript" src="./static/js/materialize.min.js"></script>
		</div>
	</body>
</html>
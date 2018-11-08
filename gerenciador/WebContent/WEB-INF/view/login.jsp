<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/paginas" var="linkServletNovoCliente"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>Pet Care | Login</title>
		<link type="text/css" rel="stylesheet" href="./static/css/bootstrap.min.css" />
		<link type="text/css" rel="stylesheet" href="./static/css/personalizacao.css" />
		<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet"/>
		<link rel="shortcut icon" type="image/png" href="./static/image/logo.png"/>
	</head>
	<body>
		<div class="container">
			<div id="content-login" class="row justify-content-center">
	    		<div id="login" class="col-10 col-sm-8 col-md-6 col-lg-4 col-xl-3 align-self-center">
					<form id="form-login" action="${linkServletNovoCliente}" method="post">
						<div id="login-logo">
							<h1 id="titulo-login">Pet Care</h3>
							<img src="./static/image/logo.svg">
						</div>
						<div class="form-group">
							<label for="usuario">Usuário</label>
   							<input name="user" type="text" class="form-control" id="usuario">
						</div>
						<div class="form-group">
							<label for="senha">Senha</label>
   							<input name="senha" type="password" class="form-control" id="senha">
						</div>
						<button id="button-login" type="submit" class="btn">Entrar</button>
						<input type="hidden" name="acao" value="Login">
					</form>
					<script type="text/javascript" src="./static/js/jquery.js"></script>
					<script type="text/javascript" src="./static/js/materialize.min.js"></script>
				</div>
			</div>	
		</div>
	</body>
</html>
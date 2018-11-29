<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/paginas" var="linkServletNovoAgendamento"/>

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
			<form action="${ linkServletNovoAgendamento}" method="post">
				<h2 class="text-center"><img id="alinhamento-icon" src="./static/image/pet.svg">Agendamento de Horário</h2>
				<div class="row">
					<div class="form-group col-12">
						<label for="idPet">Selecione um Pet:</label>
						<select id="idPet" name="idPet" class="form-control" disabled> 
						    <c:forEach  items="${listaNomeP}" var="pets" >
							        <option value="<c:out value='${pets.idPet}'/>"
							        <c:if test="${agendamento.idPet == pets.idPet}"> 
						            selected 
						       		 </c:if>>
							            <c:out value="${pets.nomePet}" />
							        </option>
				
						    </c:forEach>
						</select>
					</div>
					<div class="form-group col-12 col-md-6">
						<label for="idVeterinario">Selecione um veterinário:</label>
						<select id="idVeterinario" name="idVeterinario" class="form-control" disabled>
						    <c:forEach  items="${listaNomeV}" var="veterinarios">
						        <option value="<c:out value='${veterinarios.idVeterinario}'/>"
						        <c:if test="${agendamento.idVeterinario == veterinarios.idVeterinario}"> 
						            selected 
						        </c:if>>
						            <c:out value="${veterinarios.nomeVeterinario}" />
						        </option>
						    </c:forEach>
						</select>
					</div>
					<div class="form-group col-12 col-md-6">
						<label for="idCliente">Selecione um cliente:</label>
						<select id="idDono" name="idDono" class="form-control" disabled>
						    <c:forEach  items="${listaNomeC}" var="clientes">
						        <option value="<c:out value='${clientes.id}'/>">
						            <c:out value="${clientes.nome}" />
						        </option>
						    </c:forEach>
						</select>
					</div>
					<div class="form-group col-12 col-md-6">
						<label for="idCliente">Selecione uma data:</label>
  						<input id="idCliente" name="data" type="date" class="form-control" value="${agendamento.data}"  disabled>
					</div>
					<div class="form-group col-12 col-md-6">
						<label for="hora">Selecione um horário:</label>
  						<input id="hora" name="hora" type="time" class="form-control" value="${agendamento.hora}" disabled>
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
	
		
			
		</form>
	</body>
</html>
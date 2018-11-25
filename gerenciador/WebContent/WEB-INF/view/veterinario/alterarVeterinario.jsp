<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/paginas" var="linkServletAlteraVeterinario"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera Veterinario</title>
</head>
<body>
	<a href="paginas?acao=Logout">Sair</a>

	<form action="${linkServletAlteraVeterinario}" method="post">
		Nome:<input type="text" name="nomeVeterinario" value="${veterinario.nomeVeterinario}">
		Telefone:<input type="tel" name="telefone" value="${veterinario.telefone}">
		Celular:<input type="tel" name="celular" value="${veterinario.celular}">
		Data de Nascimento:<input type="date" name="dataNascimento" value="${veterinario.dataNascimento}">
		CPF/CNPJ:<input type="text" name="cpfCnpj" value="${veterinario.cpfCnpj}">
		CEP:<input type="text" name="cep" value="${veterinario.cep}">
		Número:<input type="number" name="numero" value="${veterinario.numero}">
		Numero de Registro:<input type="text" name="numeroRegistro" value="${veterinario.numeroRegistro}">
		Formação <input type="text" name="numeroRegistro" value="${veterinario.formacao}">
		<input type="hidden" name="idVeterinario" value="${veterinario.idVeterinario}">
		<input type="hidden" name="pacote" value="veterinario.">
		<input type="hidden" name="acao" value="AlteraVeterinario">
		<input type="submit">
	</form>
</body>
</html>
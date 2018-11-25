<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/paginas" var="linkServletNovoVeterinario"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<a href="paginas?acao=Logout">Sair</a>
	<form action="${ linkServletNovoVeterinario}" method="post">
		Nome do veterinário:<input type="text" name="nomeVeterinario">
		Celular:<input type="text" name="celular">
		CEP:<input type="text" name="cep">
		Numero:<input type="number" name="numero">
		CPF/CNPJ:<input type="text" name="cpfCnpj">
		Data de Nascimento:<input type="date" name="dataNascimento">
		Telefone:<input type="text" name="telefone">
		Número de registro:<input type="text" name="numeroRegistro">
		Formação:<input type="text" name="formacao">
	
		<input type="hidden" name="pacote" value="veterinario.">
		<input type="submit">
		<input type="hidden" name="acao" value="NovoVeterinario">
	</form>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/paginas" var="linkServletAlteraCliente"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera Cliente</title>
</head>
<body>
	<a href="paginas?acao=Logout">Sair</a>

	<form action="${linkServletAlteraCliente}" method="post">
		Nome:<input type="text" name="nome" value="${cliente.nome}">
		Telefone:<input type="tel" name="telefone" value="${cliente.telefone}">
		Celular:<input type="tel" name="celular" value="${cliente.celular}">
		Data de Nascimento:<input type="date" name="dataNascimento" value="${cliente.dataNascimento}">
		CPF/CNPJ:<input type="text" name="cpfCnpj" value="${cliente.cpfCnpj}">
		CEP:<input type="text" name="cep" value="${cliente.cep}">
		Número:<input type="number" name="numeroEndereco" value="${cliente.numeroEndereco}">
		Plano de saúde:<input type="text" name="planoSaude" value="${cliente.planoSaude}">
		
		<input type="hidden" name="id" value="${cliente.id}">
		<input type="hidden" name="pacote" value="cliente.">
		<input type="hidden" name="acao" value="AlteraCliente">
		<input type="submit">
	</form>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/paginas" var="linkServletAlteraCliente"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exibe cliente</title>
</head>
<body>
	
	<a href="paginas?acao=Logout">Sair</a>
	<form action="${linkServletAlteraCliente}" method="post">
		Nome:<input type="text" name="nome" value="${cliente.nome}" disabled>
		Telefone:<input type="tel" name="telefone" value="${cliente.telefone}" disabled>
		Celular:<input type="tel" name="celular" value="${cliente.celular}" disabled>
		Data de Nascimento:<input type="date" name="dataNascimento" value="${cliente.dataNascimento}" disabled>
		CPF/CNPJ:<input type="text" name="cpfCnpj" value="${cliente.cpfCnpj}" disabled>
		CEP:<input type="text" name="cep" value="${cliente.cep}" disabled>
		Número:<input type="number" name="numeroEndereco" value="${cliente.numeroEndereco}" disabled>
		Plano de saúde:<input type="text" name="planoSaude" value="${cliente.planoSaude}" disabled>
		
		<input type="hidden" name="pacote" value="cliente.">
		<input type="hidden" name="id" value="${cliente.id}")>
		<input type="submit" name="acao" value="RemoveCliente">
		<input type="submit" name="acao" value="ListaClientes">
	</form>
</body>
</html>

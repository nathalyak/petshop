<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/paginas" var="linkServletNovoCliente"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<a href="paginas?acao=Logout">Sair</a>
	<form action="${ linkServletNovoCliente}" method="post">
		Nome:<input type="text" name="nome">
		Telefone:<input type="tel" name="telefone" >
		Celular:<input type="tel" name="celular" >
		Data de Nascimento:<input type="date" name="dataNascimento" val>
		CPF/CNPJ:<input type="text" name="cpfCnpj">
		CEP:<input type="text" name="cep">
		Número:<input type="number" name="numeroEndereco" >
		Plano de saúde:<input type="text" name="planoSaude">
		
		<input type="hidden" name="pacote" value="cliente.">
		<input type="submit">
		<input type="hidden" name="acao" value="NovoCliente">
	</form>
</body>
</html>
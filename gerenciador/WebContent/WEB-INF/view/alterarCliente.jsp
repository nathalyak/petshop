<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/ControlaRequisicoes" var="linkServletAlteraCliente"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	

	<form action="${linkServletAlteraCliente}" method="post">
		Nome:<input type="text" name="nome" value="${cliente.nome}")>
		<input type="hidden" name="id" value="${cliente.id}")>
		<input type="hidden" name="acao" value="AlteraCliente")>
		<input type="submit">
	</form>
</body>
</html>

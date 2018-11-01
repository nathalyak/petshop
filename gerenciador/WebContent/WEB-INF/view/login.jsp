<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/ControlaRequisicoes" var="linkServletNovoCliente"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	

	<form action="${ linkServletNovoCliente}" method="post">
		Usuario:<input type="text" name="user">
		Senha:<input type="password" name="senha">
		<input type="submit">
		<input type="hidden" name="acao" value="Login">
	</form>
</body>
</html>
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
		Nome:<input type="text" name="nome">
		<input type="submit">
		<input type="hidden" name="acao" value="NovoCliente">
	</form>
</body>
</html>
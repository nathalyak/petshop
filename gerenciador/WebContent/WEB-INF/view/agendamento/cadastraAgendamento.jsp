<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/paginas" var="linkServletNovoAgendamento"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<a href="paginas?acao=Logout">Sair</a>
	<form action="${ linkServletNovoAgendamento}" method="post">
		Selecione um veterinário:<input type="text" name="idVeterinario">
		Selecione um Pet:<input type="text" name="idPet">
		Selecione um Pet:<input type="text" name="idCliente">
		Selecione uma Data:<input type="text" name="data">
		Selecione um horário:<input type="text" name="hora">

	
		<input type="hidden" name="pacote" value="agendamento.">
		<input type="submit">
		<input type="hidden" name="acao" value="NovoAgendamento">
	</form>
</body>
</html>
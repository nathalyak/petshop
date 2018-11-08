<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/paginas" var="linkServletNovoPet"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<a href="paginas?acao=Logout">Sair</a>
	<form action="${ linkServletNovoPet}" method="post">
		Nome:<input type="text" name="nomePet">
		Selecione o responsável:<input type="number" name="idDono">
		Espécie:<input type="text" name="especie" >
		Raça:<input type="text" name="raca" val>
		Porte:<input type="text" name="porte">
	
		<input type="hidden" name="pacote" value="pet.">
		<input type="submit">
		<input type="hidden" name="acao" value="NovoPet">
	</form>
</body>
</html>
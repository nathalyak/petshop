<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/paginas" var="linkServletAlteraPet"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera Pet</title>
</head>
<body>
	<a href="paginas?acao=Logout">Sair</a>

	<form action="${linkServletAlteraPet}" method="post">
		Nome:<input type="text" name="nomePet" value="${pet.nomePet}">
		Espécie:<input type="text" name="especie" value="${pet.especie}">
		<select name="idDono">
		    <c:forEach  items="${listaNome}" var="clientes">
		        <option value="<c:out value='${clientes.id}'/>"
		            <c:if test="${clientes.id == pet.idDono}"> 
		            selected 
		            </c:if> 
		             >
		            <c:out value="${clientes.nome}" />
		        </option>
		    </c:forEach>
		</select>
		
		Raça:<input type="text" name="raca" value="${pet.raca}">
		Porte:<input type="text" name="porte" value="${pet.porte}">
		<input type="hidden" name="idPet" value="${pet.idPet}">
		<input type="hidden" name="pacote" value="pet.">
		<input type="hidden" name="acao" value="AlteraPet">
		<input type="submit">
	</form>
</body>
</html>

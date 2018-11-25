<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List,br.com.petshop.gerenciador.modelo.Cliente" %>
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
		Selecione o responsável:
		<select name="idDono">
		    <c:forEach  items="${listaNome}" var="clientes">
		        <option value="<c:out value='${clientes.id}' />"
		            <c:if test="${param.selectValue == clientes})"> selected </c:if>  >
		            <c:out value="${clientes.nome}" />
		        </option>
		    </c:forEach>
		</select>
		
		Espécie:<input type="text" name="especie" >
		Raça:<input type="text" name="raca" val>
		Porte:<input type="text" name="porte">
		
		<input type="hidden" name="pacote" value="pet.">
		<input type="submit">
		<input type="hidden" name="acao" value="NovoPet">
	</form>
</body>
</html>
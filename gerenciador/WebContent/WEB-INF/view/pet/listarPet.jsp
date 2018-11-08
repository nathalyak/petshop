<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.petshop.gerenciador.modelo.Pet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty nome }">
		Pet ${nome} cadastrado com sucesso!
	</c:if>
	<a href="paginas?acao=Logout">Sair</a>
	<ul>	
		<c:forEach items="${listaNome}" var="pets">
			
			<li>${pets.nomePet}
			<a href="paginas?acao=RemovePet&pacote=pet.&id=${pets.idPet}" > Remover</a>
			<a href="paginas?acao=MostraPet&pacote=pet.&tipo=Altera&id=${pets.idPet}" > Alterar</a>
			<a href="paginas?acao=MostraPet&pacote=pet.&tipo=Exibe&id=${pets.idPet}" > Exibir dados do pet</a>
			</li> 
		</c:forEach>
		<a href="paginas?acao=Index" > Voltar para a tela inicial</a>
	</ul>
</body>
</html>
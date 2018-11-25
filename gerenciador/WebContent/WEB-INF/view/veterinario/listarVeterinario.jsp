<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.petshop.gerenciador.modelo.Veterinario" %>
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
		Veterinario ${nome} cadastrado com sucesso!
	</c:if>
	<a href="paginas?acao=Logout">Sair</a>
	<ul>	
		<c:forEach items="${listaNome}" var="veterinarios">
			
			<li>${veterinarios.nomeVeterinario}
			<a href="paginas?acao=RemoveVeterinario&pacote=veterinario.&id=${veterinarios.idVeterinario}" > Remover</a>
			<a href="paginas?acao=MostraVeterinario&pacote=veterinario.&tipo=Altera&id=${veterinarios.idVeterinario}" > Alterar</a>
			<a href="paginas?acao=MostraVeterinario&pacote=veterinario.&tipo=Exibe&id=${veterinarios.idVeterinario}" > Exibir dados do veterinario</a>
			</li> 
		</c:forEach>
		<a href="paginas?acao=Index" > Voltar para a tela inicial</a>
	</ul>
</body>
</html>
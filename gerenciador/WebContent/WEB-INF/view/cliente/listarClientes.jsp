<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.petshop.gerenciador.modelo.Cliente" %>
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
		Cliente ${nome} cadastrado com sucesso!
	</c:if>
	<a href="paginas?acao=Logout">Sair</a>
	<ul>	
		<c:forEach items="${listaNome}" var="clientes">
			
			<li>${clientes.nome}
			<a href="paginas?acao=RemoveCliente&pacote=cliente.&id=${clientes.id}" > Remover</a>
			<a href="paginas?acao=MostraCliente&pacote=cliente.&tipo=Altera&id=${clientes.id}" > Alterar</a>
			<a href="paginas?acao=MostraCliente&pacote=cliente.&tipo=Exibe&id=${clientes.id}" > Exibir dados do cliente</a>
			</li> 
		</c:forEach>
		<a href="paginas?acao=Index" > Voltar para a tela inicial</a>
	</ul>
</body>
</html>
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
	<a href="ControlaRequisicoes?acao=Logout">Sair</a>
	<ul>	
		<c:forEach items="${listaNome}" var="clientes">
			
			<li>${clientes.nome}
			<a href="ControlaRequisicoes?acao=RemoveCliente&id=${clientes.id}" > Remove</a>
			<a href="ControlaRequisicoes?acao=MostraCliente&id=${clientes.id}" > Altera</a></li> 
		</c:forEach>
	</ul>
</body>
</html>
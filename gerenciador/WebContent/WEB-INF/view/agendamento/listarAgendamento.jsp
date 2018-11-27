<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.petshop.gerenciador.modelo.Agendamento" %>
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
		Agendamento ${nome} cadastrado com sucesso!
	</c:if>
	<a href="paginas?acao=Logout">Sair</a>
	<ul>	
		<c:forEach items="${listaNome}" var="agendamentos">
			
			<li>${agendamentos.idAgendamento} | ${agendamentos.nomeCliente} | ${agendamentos.data} | ${agendamentos.hora}
			<a href="paginas?acao=RemoveAgendamento&pacote=agendamento.&id=${agendamentos.idAgendamento}" > Remover</a>
			<a href="paginas?acao=MostraAgendamento&pacote=agendamento.&tipo=Altera&id=${agendamentos.idAgendamento}" > Alterar</a>
			<a href="paginas?acao=MostraAgendamento&pacote=agendamento.&tipo=Exibe&id=${agendamentos.idAgendamento}" > Exibir dados do agendamento</a>
			</li> 
		</c:forEach>
		<a href="paginas?acao=Index" > Voltar para a tela inicial</a>
	</ul>
</body>
</html>
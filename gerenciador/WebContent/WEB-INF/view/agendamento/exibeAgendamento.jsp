<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/paginas" var="linkServletNovoAgendamento"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de Agendamentos</title>
</head>
<body>
	
	<a href="paginas?acao=Logout">Sair</a>
	<form action="${ linkServletNovoAgendamento}" method="post">

		Selecione um Cliente:
		<select name="idDono" disabled>
		    <c:forEach  items="${listaNomeC}" var="clientes">
		        <option value="<c:out value='${clientes.id}'/>"
		        <c:if test="${agendamento.idCliente == clientes.id}"> 
		            selected 
		        </c:if> >
		            <c:out value="${clientes.nome}" />
		        </option>
		    </c:forEach>
		</select>
		
		Selecione um Veterinario:
		<select name="idVeterinario" disabled>
		    <c:forEach  items="${listaNomeV}" var="veterinarios">
		        <option value="<c:out value='${veterinarios.idVeterinario}'/>"
		        <c:if test="${agendamento.idVeterinario == veterinarios.idVeterinario}"> 
		            selected 
		        </c:if>>
		            <c:out value="${veterinarios.nomeVeterinario}" />
		        </option>
		    </c:forEach>
		</select>
		
		Selecione um Pet:
		<select name="idPet" disabled> 
		    <c:forEach  items="${listaNomeP}" var="pets" >

			        <option value="<c:out value='${pets.idPet}'/>"
			        <c:if test="${agendamento.idPet == pets.idPet}"> 
		            selected 
		       		 </c:if>>
			            <c:out value="${pets.nomePet}" />
			        </option>

		    </c:forEach>
		</select>
		
		Escolha uma data para agendamento:<input type="date" value="${agendamento.data}" name="data" disabled>
		
		Escolha uma hora para agendamento:<input type="time" value="${agendamento.hora}" name="hora" disabled>

	
		<input type="hidden" name="pacote" value="agendamento.">
		<input type="hidden" name="id" value="${agendamento.idAgendamento}")>
		<input type="submit" name="acao" value="RemoveAgendamento">
		<input type="submit" name="acao" value="ListaAgendamentos">
	</form>
</body>
</html>
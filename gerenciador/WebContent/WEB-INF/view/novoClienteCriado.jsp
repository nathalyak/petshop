<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<body>
		<c:if test="${not empty nome }">
		Cliente ${nome} cadastrado com sucesso!
		</c:if>
		
		<c:if test="${empty nome }">
		Nenhum cliente cadastrada
		</c:if>
	</body>
</html>
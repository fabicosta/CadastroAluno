<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seja bem-vindo</title>
</head>
<body>
	<c:if test="${logado}">
		<jsp:forward page="/AlunoController?action=listaAluno"></jsp:forward>
	</c:if>
	<c:if test="${not logado}">
		<jsp:forward page="/LoginController?action=login"></jsp:forward>
	</c:if>
</body>
</html> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>
</head>
<body>
	<form action="LoginController" method="post">
		<fieldset>
			<c:if test='${not empty "${mensagem}"}'>
				<h3 style="color:red;"><c:out value="${mensagem}" /></h3>
			</c:if>
			
			<div>
				<label for="login">Login</label> <input type="text" name="login" value="" placeholder="Login" />
			</div>
			<div>
				<label for="senha">Senha</label> <input type="password" name="senha" value="" placeholder="Senha" />
			</div>
			<div>
				<input type="submit" value="Enviar" />
			</div>
		</fieldset>
	</form>
</body>
</html>
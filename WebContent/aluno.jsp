<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Adicionar novo Aluno</title>
</head>
<body>
	<form action="AlunoController.do" method="post">
		<fieldset>
			<div>
				<label for="id">Identificação do Aluno</label> <input type="text"
					name="id" value="<c:out value="${aluno.id}" />"
					readonly="readonly" placeholder="Identificação" />
			</div>
			<div>
				<label for="primeiroNome">Primeiro Nome</label> <input type="text"
					name="primeiroNome" value="<c:out value="${aluno.primeiroNome}" />"
					placeholder="Primeiro Nome" />
			</div>
			<div>
				<label for="ultimoNome">Último Nome</label> <input type="text"
					name="ultimoNome" value="<c:out value="${aluno.ultimoNome}" />"
					placeholder="Último Nome" />
			</div>
			<div>
				<label for="curso">Curso</label> <input type="text" name="curso"
					value="<c:out value="${aluno.curso}" />" placeholder="Curso" />
			</div>
			<div>
				<label for="idade">Year</label> <input type="text" name="idade"
					value="<c:out value="${aluno.idade}" />" placeholder="Idade" />
			</div>
			<div>
				<input type="submit" value="Enviar" />
			</div>
		</fieldset>
	</form>
</body>
</html>
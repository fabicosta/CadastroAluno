<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Alunos</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Identificação</th>
				<th>Primeiro Nome</th>
				<th>Último Nome</th>
				<th>Curso</th>
				<th>Idade</th>
				<th colspan="2">Ação</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${alunos}" var="aluno">
				<tr>
					<td><c:out value="${aluno.id}" /></td>
					<td><c:out value="${aluno.primeiroNome}" /></td>
					<td><c:out value="${aluno.ultimoNome}" /></td>
					<td><c:out value="${aluno.curso}" /></td>
					<td><c:out value="${aluno.idade}" /></td>
					<td><a
						href="AlunoController.do?action=alterar&id=<c:out value="${aluno.id}"/>">Alterar</a></td>
					<td><a
						href="AlunoController.do?action=excluir&id=<c:out value="${aluno.id}"/>">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="AlunoController.do?action=incluir">Incluir Aluno</a>
	</p>
</body>
</html>
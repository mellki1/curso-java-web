<%@page import="java.util.List"%>
<%@page import="br.com.curso.java.web.Aluno"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/removeAluno" var="linkServletRemoveAluno"/>
<c:url value="/mostraAlunoParaEditar" var="linkServletMostraAlunoParaEditar"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de alunos</title>
</head>
<style>
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
<body>
	<c:if test="${not empty nomeAluno }">
		<h2>Aluno ${nomeAluno} cadastrado com sucesso.</h2>
	</c:if>
	<br>
<table>
	<c:if test="${ empty alunosList }">
		<h2>Nenhum aluno cadastrado.</h2>
	</c:if>
	<tr>
		<th>Nome</th>
		<th>Email</th>
		<th>Curso</th>
		<th>Data de Criação</th>
	</tr>
	<c:forEach items="${alunosList}" var="aluno">
		<tr>
			<td>${aluno.nome}</td>
			<td>${aluno.email}</td>
			<td>${aluno.curso}</td>
			<td><fmt:formatDate value="${aluno.data}" pattern="dd/MM/yyyy"/></td>
			<td><a href="${linkServletMostraAlunoParaEditar}?id=${aluno.id}" >editar</a></td>
			<td><a href="${linkServletRemoveAluno}?id=${aluno.id}" >remover</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
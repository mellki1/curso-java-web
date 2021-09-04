<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/EditaAluno" var="linkServletEditaAluno"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Criando Aluno</title>
</head>
<body>
<form action=${linkServletEditaAluno}?id=${aluno.id} method="post">
	Nome: <input type="text" name="nome" value="${aluno.nome}"/>
	Email: <input type="text" name="email" value="${aluno.email}"/>
	Curso: <input type="text" name="curso" value="${aluno.curso}"/>
	Data criação: <input type="text" name="data" value="${aluno.dataFormatada}"/>
	<input type="submit"/>
</form>
</body>
</html>
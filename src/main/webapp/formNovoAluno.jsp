<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/cadastroAluno" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action=${linkServletNovaEmpresa} method="post">
	Nome: <input type="text" name="nome"/>
	Email: <input type="text" name="email"/>
	Curso: <input type="text" name="curso"/>
	<input type="submit"/>
</form>
</body>
</html>
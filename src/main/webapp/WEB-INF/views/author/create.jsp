<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Author</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <h1>Create Author</h1>
    <form:form action="${pageContext.request.contextPath}/authors/create" method="post" modelAttribute="author">
        <label for="name">Name:</label>
        <form:input path="name" required="required" />

        <label for="email">Email:</label>
        <form:input path="email" type="email" required="required" />

        <input type="submit" value="Create Author" />
    </form:form>
    <br>
    <a href="${pageContext.request.contextPath}/authors">Back to Authors List</a>
</body>
</html>
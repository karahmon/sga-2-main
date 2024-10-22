<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Book</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <h1>Update Book</h1>
    <form:form action="${pageContext.request.contextPath}/books/update" method="post" modelAttribute="book">
        <form:hidden path="id" />

        <label for="title">Title:</label>
        <form:input path="title" required="required" />

        <label for="isbn">ISBN:</label>
        <form:input path="isbn" required="required" />

        <label for="author">Author:</label>
        <form:select path="author.id">
            <c:forEach items="${authors}" var="author">
                <form:option value="${author.id}">${author.name}</form:option>
            </c:forEach>
        </form:select>

        <input type="submit" value="Update Book" />
    </form:form>
    <br>
    <a href="${pageContext.request.contextPath}/books">Back to Books List</a>
</body>
</html>
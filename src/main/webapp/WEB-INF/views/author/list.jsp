<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Authors List</title>
    <link rel="stylesheet"   href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <h1>Authors List</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Books</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${authors}" var="author">
            <tr>
                <td>${author.id}</td>
                <td>${author.name}</td>
                <td>${author.email}</td>
                <td>
                    <c:forEach items="${author.books}" var="book">
                        ${book.title}<br>
                    </c:forEach>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/authors/update/${author.id}">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/authors/create">Add New Author</a>
    <br>
    <a href="${pageContext.request.contextPath}/">Back to Home</a>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books</title>
    </head>
    <body bgcolor="#C0C0C0">
        <a href="${pageContext.request.contextPath}">Back to index page</a><br />
        <h1>Books</h1>
        <c:forEach var="book" items="${books}">     
            <b>ID:</b> ${book.id} <b>Author:</b> ${book.author} <b>Title:</b> ${book.title} <b>Publisher:</b> ${book.publisher} <b>Year:</b> ${book.year}
            <br />
        </c:forEach>
    </body>
</html>

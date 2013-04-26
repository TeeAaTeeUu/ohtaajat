<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books</title>
    </head>
    <body bgcolor="#C0C0C0">
        <a href="${pageContext.request.contextPath}/">Back to index page</a><br />
        <h1>Books</h1>
        <c:forEach var="book" items="${books}">
            ${book}
            <form:form action="${pageContext.request.contextPath}/app/books/${book.id}/" method="DELETE">
                <input type="submit" value="Poista" />
            </form:form>
            <br />
        </c:forEach>
    </body>
</html>

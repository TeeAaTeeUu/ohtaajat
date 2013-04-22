<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Articles</title>
    </head>
    <body bgcolor="#C0C0C0">
        <a href="${pageContext.request.contextPath}">Back to index page</a><br />
        <h1>Articles</h1>
        <c:forEach var="article" items="${articles}">     
            <b>ID:</b> ${article.id} <b>Author:</b> ${article.author} <b>Title:</b> ${article.title} <b>Journal:</b> ${article.journal} <b>Year:</b> ${article.year}
            <form:form action="${pageContext.request.contextPath}/app/articles/${article.id}/" method="DELETE">
                <input type="submit" value="Poista" />
            </form:form>
            <br />
        </c:forEach>
    </body>
</html>

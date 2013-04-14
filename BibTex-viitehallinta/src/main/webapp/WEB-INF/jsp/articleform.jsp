<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new article</title>
    </head>
    <body bgcolor="#C0C0C0">
        <a href="${pageContext.request.contextPath}">Back to index page</a><br />
        <h1><U>Article</U></h1>
        <form:form commandName="article" action="${pageContext.request.contextPath}/app/articles/new" method="POST">
            Author:
            <form:input path="author" /><form:errors path="author" />
            <br>
            Title:
            <form:input path="title" /><form:errors path="title" />
            <br>
            Journal:
            <form:input path="journal" /><form:errors path="journal" />
            <br>
            Year:
            <form:input path="year" /><form:errors path="year" />
            <br>
            <input type="submit" value="Luo" />
            <input type="reset" value="Tyhjennä" />
        </form:form>
        ${message}
    </body>
</html>

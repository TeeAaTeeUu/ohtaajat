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
            <hr />
            <h3>Optional information</h3>
            Volume:
            <form:input path="volume" /><form:errors path="volume" />
            <br />
            Number:
            <form:input path="number" /><form:errors path="number" />
            <br />
            Pages:
            <form:input path="pages" /><form:errors path="month" />
            <br />
            Month:
            <form:input path="month" /><form:errors path="month" />
            <br />
            Note:
            <form:input path="note" /><form:errors path="note" />
            <br />
            Key:
            <form:input path="key" /><form:errors path="key" />
            <br />
            <input type="submit" value="Create" />
            <input type="reset" value="Empty" />
        </form:form>
        ${message}
    </body>
</html>

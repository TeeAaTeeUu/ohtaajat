

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kirja</title>
    </head>
    <body bgcolor="#C0C0C0">
        
        <a href="books">Kirja listaus</a>
        <br>
        
        <h1><U>Kirja</U></h1>
        
        <form:form commandName="book" action="${pageContext.request.contextPath}/app/book" method="POST">
            Author:
            <form:input path="author" /><form:errors path="author" />
            <br>
            Title:
            <form:input path="title" /><form:errors path="title" />
            <br>
            Year:
            <form:input path="year" /><form:errors path="year" />
            <br>
            Publisher:
            <form:input path="publisher" /><form:errors path="publisher" />
            <br>
            <input type="submit" value="Muunna" />
            <input type="reset" value="Tyhjennä" />
        </form:form>
        ${message}


    </body>
</html>

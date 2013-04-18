<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new inproceeding</title>
    </head>
    <body bgcolor="#C0C0C0">
        <a href="${pageContext.request.contextPath}">Back to index page</a><br />
        
        <h1><U>Inproceeding</U></h1>
        <hr />
        
                <form:form commandName="inproceeding" action="${pageContext.request.contextPath}/app/inproceedings/new" method="POST">
            Author:
            <form:input path="author" /><form:errors path="author" />
            <br>
            Title:
            <form:input path="title" /><form:errors path="title" />
            <br>
            Journal:
            <form:input path="booktitle" /><form:errors path="journal" />
            <br>
            Year:
            <form:input path="year" /><form:errors path="year" />
            <br>
            <hr />
            <h3>Optional information</h3>
            Editor:
            <form:input path="editor" /><form:errors path="editor" />
            <br />
            Pages:
            <form:input path="pages" /><form:errors path="month" />
            <br />
            Organization:
            <form:input path="organization" /><form:errors path="organization" />
            <br />
            Publisher:
            <form:input path="publisher" /><form:errors path="publisher" />
            <br />
            Address:
            <form:input path="address" /><form:errors path="address" />
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
            <hr />
            <h3>Custom cite (optional)</h3>
            Cite:
            <form:input path="cite" /><form:errors path="cite" />
            <br />
            <hr />
            <input type="submit" value="Create" />
            <input type="reset" value="Empty" />
        </form:form>
        ${message}
    </body>
</html>

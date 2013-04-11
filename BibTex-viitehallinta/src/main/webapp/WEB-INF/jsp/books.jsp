<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kirjat</title>
    </head>
    <body bgcolor="#C0C0C0">
        <a href="book">Kirjan luonti</a>
        <a href="books/bibtex">Kirjojen listaus BibTextinä</a>
        <h1>Kirjat</h1>
        <c:forEach var="book" items="${books}">
            ${entry.book}          
            <b>ID:</b> ${book.id}
            <c:forEach var="field" items="${book.fields}">
            <b>${field.name}:</b> ${field.value}
        </c:forEach>
            <br>
        </c:forEach>
            

            
        
    </body>
</html>

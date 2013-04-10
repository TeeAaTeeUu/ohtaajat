<%-- 
    Document   : booksInBibTex
    Created on : 10.4.2013, 15:44:23
    Author     : Teemu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#C0C0C0">
        <a href="/BibTex-viitehallinta/app/book">Kirjan luonti</a>
        <a href="/BibTex-viitehallinta/app/books">Kirjojen listaus</a>

        <h1>Kirjat BibTextinä:</h1>


        <textarea rows="15" cols="70">${books}</textarea> 

    </body>
</html>

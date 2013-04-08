<%-- 
    Document   : books
    Created on : 5.4.2013, 22:42:20
    Author     : Tero
--%>

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
        <h1>Kirjat</h1>
        <c:forEach var="id" items="${books}">
            ${id}<br>
        </c:forEach>
            
        
    </body>
</html>

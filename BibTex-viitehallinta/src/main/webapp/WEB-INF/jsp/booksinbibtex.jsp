<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kirjat bibtex</title>
    </head>
    <body bgcolor="#C0C0C0">
        <a href="${pageContext.request.contextPath}/app/book">Kirjan luonti</a>
        <a href="${pageContext.request.contextPath}/app/books">Kirjojen listaus</a>

        <h1>Kirjat BibTextinä:</h1>
        
        ${books}


    </body>
</html>

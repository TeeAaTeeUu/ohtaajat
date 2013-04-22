<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inproceedings</title>
    </head>
    <body bgcolor="#C0C0C0">
        <a href="${pageContext.request.contextPath}">Back to index page</a><br />
        <h1>Inproceedings</h1>
        <c:forEach var="inproceeding" items="${inproceedings}">     
            <b>ID:</b> ${inproceeding.id} <b>Author:</b> ${inproceeding.author} <b>Title:</b> ${inproceeding.title} <b>Booktitle:</b> ${inproceeding.booktitle} <b>Year:</b> ${inproceeding.year}
            <form:form action="${pageContext.request.contextPath}/app/inproceedings/${inproceeding.id}/" method="DELETE">
                <input type="submit" value="Poista" />
            </form:form>
            <br />
        </c:forEach>
    </body>
</html>

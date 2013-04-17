<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
    </head>
    <body bgcolor="#C0C0C0">
        <a href="${pageContext.request.contextPath}">Back to index page</a><br />
        <h1>${title}</h1>
        <form>
            Author: <input type="input" name="author" /><br />
            <input type="submit" value="Hae" />
        </form>
        <c:forEach var="entry" items="${entries}">
            ${entry}
        </c:forEach>
    </body>
</html>

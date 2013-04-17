<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BibTex-viitehallinta</title>
    </head>
    <body bgcolor="#C0C0C0">
        <a href="${pageContext.request.contextPath}/app/books/new">Create new book</a><br />
        <a href="${pageContext.request.contextPath}/app/books">List books</a><br />
        <a href="${pageContext.request.contextPath}/app/books/bibtex">List books in bibtex</a><br /><br />
        <a href="${pageContext.request.contextPath}/app/articles/new">Create new article</a><br />
        <a href="${pageContext.request.contextPath}/app/articles">List articles</a><br />
        <a href="${pageContext.request.contextPath}/app/articles/bibtex">List articles in bibtex</a><br /><br />
        <a href="${pageContext.request.contextPath}/app/inproceedings/new">Create new inproceeding</a><br />
        <a href="${pageContext.request.contextPath}/app/inproceedings">List inproceedings</a><br />
        <a href="${pageContext.request.contextPath}/app/inproceedings/bibtex">List inproceedings in bibtex</a><br /><br />
        <a href="${pageContext.request.contextPath}/app/entries">Search entries</a><br />
    </body>
</html>


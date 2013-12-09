<%-- 
    Document   : hi
    Created on : 2013-12-04, 10:01:17
    Author     : galbanie <galbanie at setrukmarcroger@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 class="ui-widget-header">Les Articles</h1>
<c:forEach var="article" items="${applicationScope.articles}">
    <article class="article-mini">
        <header>
            <h2>Titre</h2>
            <span>Categorie</span>
        </header>
        <p>Contenu</p>
        <footer>
            <span>Emetter</span>
            <span>Date de publication</span>
        </footer>
        <a>Consulter</a>
    </article>
</c:forEach>

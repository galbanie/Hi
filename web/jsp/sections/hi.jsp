<%-- 
    Document   : hi
    Created on : 2013-12-04, 10:01:17
    Author     : galbanie <galbanie at setrukmarcroger@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:out value="${sessionScope.usager.getClass().name}" />
<h1 class="ui-widget-header">Help Me</h1>
<c:forEach var="article" items="${applicationScope.articles}">
    <article class="article-mini">
        <header>
            <h2 class="ui-widget-header">${article.titre}</h2>
            <div>
                <span class="span-cat">Catégorie : <a href="#">${article.categorie.nom}</a></span>
                <span class="span-publication">(date publication)${article.publication}</span>
                <hr class="clearboth" style="margin: 0; visibility: hidden;" />
            </div>
            
        </header>
        <p>${article.contenus[0].text}</p>
        <footer>
            <span>Emetteur</span>
            <span>Date de publication</span>
        </footer>
        <a>Consulter</a>
    </article>
</c:forEach>

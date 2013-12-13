<%-- 
    Document   : addTopic
    Created on : 2013-12-12, 16:33:11
    Author     : galbanie <galbanie at setrukmarcroger@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="ui-widget-header">Ajouter un article</h1>
<form id="form-add-topic" method="POST" action="${pageContext.request.contextPath}/sujet">
    <input type="hidden" name="formulaire" value="addTopic" />
    <label>
        Catégorie :
        <select name="categorie">
            <optgroup label="Programmation">
                <option value="Java">Java</option>
                <option value="C#">C#</option>
                <option value="C++">C++</option>
            </optgroup>
            <optgroup label="Photographie">
                <option value="HDR">HDR</option>
                <option value="Magic Lantern">Magic Lantern</option>
                <option value="Bonnes Pratiques">Bonnes Pratiques</option>
            </optgroup>
        </select>
    </label>
    <label>
        Titre :
        <input type="text" id="titre" name="titre"/>
    </label>
    <label>
        Contenu :
        <textarea id="contenu" name="contenu" rows="7" cols="140"></textarea>
    </label>
    
    <button type="submit" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-focus">
        <span class="ui-button-text">Ajouter</span>
    </button>
</form>

<%-- 
    Document   : logOn
    Created on : 28 nov. 2013, 07:55:30
    Author     : galbanie <galbanie at setrukmarcroger@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table id="page-table">
    <tr>
        <td id="page-td">
            <section id="box-logOn" class="ui-widget ui-widget-content ui-corner-all" style="display: block;">
            <h1 class="ui-widget-header">Connexion</h1>
            <form id="form-connexion" method="POST">
                <input type="hidden" name="formulaire" value="connexion" />
                <label>
                    Identifiant :
                    <input class="ui-corner-all" type="text" name="username" />
                </label>

                <label>
                    Mot de passe :
                    <input class="ui-corner-all" type="password" name="password" />
                </label>
                
                <button type="submit" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-focus">
                    <span class="ui-button-text">Connexion</span>
                </button>
                <a href="#" id="link-dialog-pwdforget" class="ui-state-default ui-corner-all">Mot de passe oublié ?</a>
            </form>
            
            <form id="form-inscription" style="display: none;" method="POST">
                <input type="hidden" name="formulaire" value="inscription" />
                <label>
                    Email :
                    <input class="ui-corner-all" type="text" name="email" />
                </label>

                <label>
                    Identifiant :
                    <input class="ui-corner-all" type="password" name="username" />
                </label>
                
                <label>
                    Mot de passe :
                    <input class="ui-corner-all" type="password" name="password" />
                </label>

                <label>
                    Confirmation :
                    <input class="ui-corner-all" type="password" name="confirm" />
                </label>
                
                <button type="submit" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-focus">
                    <span class="ui-button-text">Inscription</span>
                </button>
                
            </form>
            
        </section>
        </td>
    </tr>
</table>

<div id="box-btn-logon" class="ui-widget ui-widget-content">
    <span class="ui-button-text">Inscription</span>
</div>

<div id="box-btn-guessIn" class="ui-widget ui-widget-content">
    <span class="ui-button-text">Invité</span>
    <form method="POST"><input type="hidden" name="guess" value="true" /></form>
</div>

<div id="box-dialog-pwdforget">
    <form>
        <input type="hidden" name="formulaire" value="pwdforget" />
        <label>
            Email :
            <input class="ui-corner-all" type="text" name="email" />
        </label>
    </form>
</div>
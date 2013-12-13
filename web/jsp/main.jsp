<%-- 
    Document   : main
    Created on : 28 nov. 2013, 16:39:59
    Author     : galbanie <galbanie at setrukmarcroger@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav id="menu-main">
    <ul>
        <li><a href="${pageContext.request.contextPath}">Help I</a></li>
        <c:if test="${not empty sessionScope.usager}" >
        <li>
            <a>Topic</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/sujet?action=add">Ajouter</a></li>
                <li><a>visionner</a></li>
                <li><a>Editer</a></li>
            </ul>
        </li>
        </c:if>
        <c:if test="${empty sessionScope.usager}" ><li><a href="${pageContext.request.contextPath}/register?guess=false">Connexion</a></li></c:if>
        <li><a>Règles</a></li>
        <li><a>Contact</a></li>
    </ul>
</nav>

<section id="box-main-menu">
    
    <c:if test="${not empty sessionScope.usager}">
        <aside id="aside-menu-user" class="ui-widget-content">
        <h3 class="ui-widget-header">Controle membre</h3>
        <div id="box-main-info-user">
            <img id="box-main-info-user-img" src="${pageContext.request.contextPath}/css/natif/images/Profil_default.jpg" alt="" width="90" height="70" />
            <div>
                <a href="#">${sessionScope.usager.identifiant}</a>
            </div>
        </div>
        <nav id="menu-user">
            <ul>
                <li><a href="#">Mes articles</a></li>
                <li><a href="#">Mes Reponses</a></li>
                <li><a href="#">Les Alertes</a></li>
                <c:if test="${sessionScope.usager.getClass().simpleName eq 'Moderateur' or sessionScope.usager.getClass().simpleName eq 'Administrateur'}"><li><a href="#">Gestionnaires des articles</a></li></c:if>
                <c:if test="${sessionScope.usager.getClass().simpleName eq 'Administrateur'}"><li><a href="#">Gestionnaires des utilisateurs</a></li></c:if>
                <li><a href="${pageContext.request.contextPath}/register?user=deconnexion" class="deconnexion">Déconnexion</a></li>
            </ul>
        </nav>
    </aside>
    </c:if>
    
    <aside id="aside-menu-cat">
        <nav id="menu-cat">
            <h3 class="ui-widget-header">Catégories</h3>
            <ul class="menu">
                <li class="item1"><a href="#">Programmation<span>340</span></a>
                    <ul>
                        <li class="subitem1"><a href="#">Java <span>14</span></a></li>
                        <li class="subitem2"><a href="#">C# <span>6</span></a></li>
                        <li class="subitem3"><a href="#">C++ <span>2</span></a></li>
                    </ul>
		</li>
		<li class="item2"><a href="#">Photographie <span>147</span></a>
                    <ul>
			<li class="subitem1"><a href="#">HDR <span>14</span></a></li>
			<li class="subitem2"><a href="#">Magic Lantern <span>6</span></a></li>
			<li class="subitem3"><a href="#">Bonnes pratiques <span>2</span></a></li>
                    </ul>
		</li>
		<li class="item3"><a href="#">Vidéographie <span>340</span></a>
                    <ul>
			<li class="subitem1"><a href="#">Tournage <span>14</span></a></li>
			<li class="subitem2"><a href="#">Montage <span>6</span></a></li>
			<li class="subitem3"><a href="#">Accessoires <span>2</span></a></li>
                    </ul>
		</li>
		<li class="item4"><a href="#">Windows <span>222</span></a>
                    <ul>
			<li class="subitem1"><a href="#">Logiciels <span>14</span></a></li>
			<li class="subitem2"><a href="#">Strange “Stuff” <span>6</span></a></li>
			<li class="subitem3"><a href="#">Automatic Fails <span>2</span></a></li>
                    </ul>
		</li>
		<li class="item5"><a href="#">Mac OS <span>16</span></a>
                    <ul>
			<li class="subitem1"><a href="#">Idevise <span>14</span></a></li>
			<li class="subitem2"><a href="#">Strange “Stuff” <span>6</span></a></li>
			<li class="subitem3"><a href="#">Automatic Fails <span>2</span></a></li>
                    </ul>
		</li>
	</ul>
        </nav>
        <!--initiate accordion-->
        <script type="text/javascript">
                $(function() {

                    var menu_ul = $('.menu > li > ul'),
                           menu_a  = $('.menu > li > a');

                    menu_ul.hide();

                    menu_a.click(function(e) {
                        e.preventDefault();
                        if(!$(this).hasClass('active')) {
                            menu_a.removeClass('active');
                            menu_ul.filter(':visible').slideUp('normal');
                            $(this).addClass('active').next().stop(true,true).slideDown('normal');
                        } else {
                            $(this).removeClass('active');
                            $(this).next().stop(true,true).slideUp('normal');
                        }
                    });

                });
        </script>
    </aside>
</section>

<section id="box-main-content">
    <c:if test="${not empty requestScope.arborescence}">
    <nav id="menu-section">
        <ul>
            <li><a>${requestScope.article.categorie.parent.parent.nom}</a> > </li>
            <li><a>${requestScope.article.categorie.parent.nom}</a></li>
            <li><a>${requestScope.article.categorie.nom}</a></li>
            <li><a>${requestScope.article.titre}</a></li>
        </ul>
    </nav>
    <hr class="separateur" />
    </c:if>
    <section >
    <c:choose>
        <c:when test="${empty requestScope.section}"><jsp:include page="sections/hi.jsp" /></c:when>
        <c:otherwise><jsp:include page="sections/${requestScope.section}.jsp" /></c:otherwise>
    </c:choose>
    </section>
</section>

<hr class="clearboth hidden" />
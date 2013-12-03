<%-- 
    Document   : main
    Created on : 28 nov. 2013, 16:39:59
    Author     : galbanie <galbanie at setrukmarcroger@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav id="menu-main">
    <ul><li>Help I</li>
      <li>
        Règles
        <ul>
          <li>Web Design</li>
          <li>Web Development</li>
          <li>Illustrations</li>
        </ul>
      </li>
      <li>Contact</li>
    </ul>
</nav>

<section id="box-main-menu">
    
    <c:if test="${empty sessionScope.usager}">
        <aside id="aside-menu-user" class="ui-widget-content">
        <h3 class="ui-widget-header">Controle membre</h3>
        <div id="box-main-info-user">
            
        </div>
        <nav id="menu-user">
            <!--ul id="menu-accordeon">
               <li><a href="#">Lien menu 1</a>
                  <ul>
                     <li><a href="#">lien sous menu 1</a></li>
                     <li><a href="#">lien sous menu 1</a></li>
                     <li><a href="#">lien sous menu 1</a></li>
                     <li><a href="#">lien sous menu 1</a></li>
                  </ul>
               </li>
                <li><a href="#">Lien menu 2</a>
                  <ul>
                     <li><a href="#">Lien sous menu 2</a></li>
                     <li><a href="#">Lien sous menu 2</a></li>
                     <li><a href="#">Lien sous menu 2</a></li>
                     <li><a href="#">Lien sous menu 2</a></li>
                  </ul>
               </li>
               <li><a href="#">Lien menu 3</a>
                  <ul>
                     <li><a href="#">Lien sous menu 3</a></li>
                     <li><a href="#">Lien sous menu 3</a></li>
                     <li><a href="#">Lien sous menu 3</a></li>
                     <li><a href="#">Lien sous menu 3</a></li>
                  </ul>
               </li>
            </ul-->
            
            <!--ul class="menu">
                <li class="item1"><a href="#">Friends <span>340</span></a>
                    <ul>
                        <li class="subitem1"><a href="#">Cute Kittens <span>14</span></a></li>
                        <li class="subitem2"><a href="#">Strange “Stuff” <span>6</span></a></li>
                        <li class="subitem3"><a href="#">Automatic Fails <span>2</span></a></li>
                    </ul>
		</li>
		<li class="item2"><a href="#">Videos <span>147</span></a>
                    <ul>
			<li class="subitem1"><a href="#">Cute Kittens <span>14</span></a></li>
			<li class="subitem2"><a href="#">Strange “Stuff” <span>6</span></a></li>
			<li class="subitem3"><a href="#">Automatic Fails <span>2</span></a></li>
                    </ul>
		</li>
		<li class="item3"><a href="#">Galleries <span>340</span></a>
                    <ul>
			<li class="subitem1"><a href="#">Cute Kittens <span>14</span></a></li>
			<li class="subitem2"><a href="#">Strange “Stuff” <span>6</span></a></li>
			<li class="subitem3"><a href="#">Automatic Fails <span>2</span></a></li>
                    </ul>
		</li>
		<li class="item4"><a href="#">Podcasts <span>222</span></a>
                    <ul>
			<li class="subitem1"><a href="#">Cute Kittens <span>14</span></a></li>
			<li class="subitem2"><a href="#">Strange “Stuff” <span>6</span></a></li>
			<li class="subitem3"><a href="#">Automatic Fails <span>2</span></a></li>
                    </ul>
		</li>
		<li class="item5"><a href="#">Robots <span>16</span></a>
                    <ul>
			<li class="subitem1"><a href="#">Cute Kittens <span>14</span></a></li>
			<li class="subitem2"><a href="#">Strange “Stuff” <span>6</span></a></li>
			<li class="subitem3"><a href="#">Automatic Fails <span>2</span></a></li>
                    </ul>
		</li>
	</ul-->
            <ul>
                <li><a href="#">menu 1</a></li>
                <li><a href="#">menu 2</a></li>
                <li><a href="#">menu 3</a></li>
            </ul>
        </nav>
    </aside>
    </c:if>
    
    <aside id="aside-menu-cat">
        
    </aside>
</section>

<section id="box-main-content">
    
</section>

<hr class="clearboth hidden" />
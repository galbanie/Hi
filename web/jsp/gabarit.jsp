<%-- 
    Document   : gabarit
    Created on : 2013-10-16, 14:16:13
    Author     : galbanie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/natif/base.css" type="text/css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/natif/style.css" type="text/css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dot-luv/jquery-ui-1.10.3.custom.css" type="text/css" />
        
        <script src="js/jquery-1.9.1.js" type="text/javascript" ></script>
        <script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript" ></script>
        
        <script src="js/hi.js" type="text/javascript" ></script>
        
        <title>hi | Help I</title>
    </head>
    <body>
        <section>
        <c:choose>
            <c:when test="${not empty sessionScope.usager or sessionScope.guess eq true}">
                <jsp:include page="" />
            </c:when>
            <c:otherwise>
                <jsp:include page="logOn.jsp" />
            </c:otherwise>
        </c:choose>
        </section>
    </body>
</html>

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
        <title>hi | Help I</title>
    </head>
    <body>
        <c:out value="${pageContext.request.localAddr}" default="galbanie" />
        
    </body>
</html>

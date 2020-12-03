<%-- 
    Document   : login
    Created on : 09/11/2020, 23:35:42
    Author     : Sara
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/login.css" rel="stylesheet"/>
        <title>JSP Page</title>
    </head>
    <%-- <%@include file="header.jsp"%> --%>
    <body class="fundoLogin">
        
        <img class="slogan" src="./imagens/slogan_sem_fundo_1.png" alt="slogan" width=200 height=100>
        <br>
        <h1 class="login">LOGIN</h1>
        
        <a class="usuario"> Usuário </a><br/>
         <a class="senha"> Senha </a>
         
         <form action="LoginServlet" method="POST">
             <div class="form-group">
            
            <input name="login" class="form-control1" required>
        </div>
        
        <div class="form-group">
            
            <input type="password" name="senha" class="form-control2" required>
        </div>
            <br>
        <button type="submit" class="btn btn-primary">ENTRAR</button>
        
        
        <c:if test="${param.erro != null}">
            
            <div class="alert alert-danger" role="alert">
            Usuário/Senha inválidos
            </div>
            
        </c:if>
        
        </form>
        
    </body>
</html>



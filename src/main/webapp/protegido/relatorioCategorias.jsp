<%-- 
    Document   : relatorioCategorias
    Created on : 01/12/2020, 19:31:10
    Author     : Matheus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file = "../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
       <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        
        <title>Relatório de Produtos</title>
    </head>
    <body>
        <h1>Relatório de Categorias | Detalhe Produtos</h1>
        <form action="<c:url value="/RelatorioCategorias"/>" method="GET">
            
            <label>Período</label></br>
            <p> De:<input type="text" name="de" onkeypress="$(this).mask('00/00/0000');" placeholder="dd/mm/aaaa" size="10" minlength="10" required="true"></input> 
            Até:<input type="text" name="ate" onkeypress="$(this).mask('00/00/0000');" placeholder="dd/mm/aaaa" size="10" minlength="10" required="true"></input></p>
            
                 Filial:
                  <select name="filial">
                  <option value="Shop_SportsSP_1">Shop_SportsSP_1</option>
                  <option value="Shop_SportsSP_2">Shop_SportsSP_2</option>
                  <option value="Shop_SportsSP_3">Shop_SportsSP_3</option>
                  <option value="Shop_SportsRJ_1">Shop_SportsRJ_1</option>
                  </select>
            
            
            <button type="submit" class="btn btn-success btn-sm"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right-square-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm2.5 8.5a.5.5 0 0 1 0-1h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5z"/>
</svg></button>
            <a href="<c:url value="/index.jsp"/>"><button type="button" class="btn btn-primary btn-sm"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-house" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
  <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
</svg></button></a>
            
        </form>
    </body>
</html>

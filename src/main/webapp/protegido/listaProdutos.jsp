<%-- 
    Document   : listaProdutos
    Created on : 16/10/2020, 22:11:46
    Author     : Matheus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html>
    <%@include file = "../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/produtos.css" rel="stylesheet">
        
        <title>Produtos</title>
        
        <script lang="text/javasript">
          function mostrarModalExclusao(id, produto){
             
              $("#nomeProduto").html(produto);
               $("#idProduto").val(id);
              $("#modalExclusao").modal('show');
          }
          
          function excluirProduto(){
              var id = $("#idProduto").val();
               $.get( "ExcluirProduto?idProduto="+id, function( resposta ) {
                    $('#modalExclusao').modal('show');
                    if (resposta === "true") {
                        
                        console.log("Excluido!");
                    } else {
                        console.log("Erro!");
                    }
                    window.location.reload();
                });
          }
                
        </script>  
    </head>
    
    <body>
       <%-- <header>
            <a href="index.jsp">
                <img src="imagens/slogan_sem_fundo_1.png" alt="Logo da Loja" />
            </a>
        </header> --%>
        
        <main class="container">
            <h1>Lista de Produtos</h1>
            <table id = "tbprodutos" class="table" width=50 height=50>
                <thead class="thead-light">
                <th scope="col">Código</th>
                <th scope="col">Produto</th>
                <th scope="col">Categoria</th>
                 <th scope="col">Tamanho</th>
                <th scope="col">Valor</th>
                <th scope="col">Filial</th>
                <th scope="col">Estoque</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </thead>
            <tbody>
                <c:forEach var="produto" items="${listaProdutos}">
                    <tr>
                        <td>${produto.id}</td> 
                        <td>${produto.produto}</td> 
                        <td>${produto.categoria}</td>
                        <td>${produto.tamanho}</td>
                        <td>${produto.valor}</td> 
                        <td>${produto.filial}</td>
                        <td>${produto.estoque}</td> 

                        <td><a href="AlterarProduto?id=${produto.id}">Alterar</a></td> 
                        <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao(${produto.id},' ${produto.produto}')">Excluir</button></td>

                    </tr>

                </c:forEach>


            </tbody>
        </table>
            <div class="modal fade" id="modalExclusao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h5 class="modal-title" id="exampleModalLabel">Confirmar Exclusão</h5>
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                      </button>
                    </div>
                    <div class="modal-body">
                        Confirmar exclusão do Produto  <label id="nomeProduto"></label> ?
                        <input id="idProduto" hidden/>

                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                      <button type="button" class="btn btn-primary" onclick="excluirProduto()">Confirmar</button>
                    </div>
                  </div>
                </div>
              </div>


            <a href="index.jsp">MENU</a>
        </main>
        
        <footer>
            © 2020 SEXTETO SECRETO, TODOS OS DIREITOS RESERVADOS
        </footer>
       
    </body>
    
</html>


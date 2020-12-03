<%-- 
    Document   : listaClientes
    Created on : 14/10/2020, 22:34:54
    Author     : Sara
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file = "../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="css/style.css" rel="stylesheet">
        <title>JSP Page</title>
        
        <script lang="text/javasript">
          function mostrarModalExclusao(id, nome){
             
              $("#nomeCliente").html(nome);
               $("#idCliente").val(id);
              $("#modalExclusao").modal('show');
          }
          
          function excluirCliente(){
              var id = $("#idCliente").val();
               $.get( "ExcluirCliente?idCliente="+id, function( resposta ) {
                    $('#modalExclusao').modal('hide');
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
        <header>
            <a href="index.jsp">
                <img src="imagens/slogan_sem_fundo_1.png" alt="Logo da Loja" />
            </a>
        </header>
        
        <main class="container">
            <h1>Lista de Clientes</h1>
            <table id="tbclientes"class="table">
                <thead class="thead-light">
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">Cpf</th>
                <th scope="col">Sexo</th>
                <th scope="col">Email</th>
                <th scope="col">Celular</th>
                <th scope="col">Rua</th>
                <th scope="col">Bairro</th>
                <th scope="col">Cep</th>
                <th scope="col">Cidade</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </thead>
            <tbody>
                <c:forEach var="cliente" items="${listaClientes}">
                    <tr>
                        <td>${cliente.id}</td> 
                        <td>${cliente.nome}</td>
                        <td>${cliente.cpf}</td> 
                        <td>${cliente.sexo}</td>  
                        <td>${cliente.email}</td> 
                        <td>${cliente.celular}</td> 
                        <td>${cliente.rua}</td> 
                        <td>${cliente.bairro}</td> 
                        <td>${cliente.cep}</td> 
                        <td>${cliente.cidade}</td> 
                        <td><a href="AlterarCliente?id=${cliente.id}">Alterar</a></td> 
                        <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao(${cliente.id},' ${cliente.nome}')">Excluir</button></td>

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
                        Confirmar exclusão do Cliente  <label id="nomeCliente"></label> ?
                        <input id="idCliente" hidden/>

                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                      <button type="button" class="btn btn-primary" onclick="excluirCliente()">Confirmar</button>
                    </div>
                  </div>
                </div>
              </div>
            </br>
            <a href="/protegido/index.jsp">MENU</a>
        </main>
        
        <footer>
            © 2020 SEXTETO SECRETO, TODOS OS DIREITOS RESERVADOS
        </footer>
    </body>
</html>

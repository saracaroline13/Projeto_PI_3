<%-- 
    Document   : listaFuncionario
    Created on : 09/10/2020, 14:00:38
    Author     : Matheus
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
             
              $("#nomeFuncionario").html(nome);
               $("#idFuncionario").val(id);
              $("#modalExclusao").modal('show');
          }
          
          function excluirFuncionario(){
              var id = $("#idFuncionario").val();
               $.get( "ExcluirFuncionario?idFuncionario="+id, function( resposta ) {
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
            <h1>Lista de Funcionarios</h1>
            <table id="tbFuncionarios" class="table">
                <thead class="thead-light">
                    <th scope="col">Matricula</th>
                    <th scope="col">Filial</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Cpf</th>
                    <th scope="col">Sexo</th>
                    <th scope="col">Data_Nasc</th>
                    <th scope="col">Estado_Civil</th>
                    <th scope="col">Cargo</th>
                    <th scope="col">Salario</th>
                    <th scope="col">Email</th>
                    <th scope="col">Contato</th>
                    <th scope="col">Rua</th>
                    <th scope="col">Bairro</th>
                    <th scope="col">Cep</th>
                    <th scope="col">Cidade</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </thead>
                <tbody>
                    <c:forEach var="funcionario" items="${listaFuncionarios}">
                        <tr>
                            <td>${funcionario.id}</td> 
                            <td>${funcionario.filial}</td> 
                            <td>${funcionario.nome}</td>
                            <td>${funcionario.cpf}</td> 
                            <td>${funcionario.sexo}</td> 
                            <td>${funcionario.data_nasc}</td> 
                            <td>${funcionario.estado_civil}</td> 
                            <td>${funcionario.cargo}</td> 
                            <td>${funcionario.salario}</td> 
                            <td>${funcionario.email}</td> 
                            <td>${funcionario.contato}</td> 
                            <td>${funcionario.rua}</td> 
                            <td>${funcionario.bairro}</td> 
                            <td>${funcionario.cep}</td> 
                            <td>${funcionario.cidade}</td> 
                            <td><a href="AlterarFuncionario?id=${funcionario.id}">Alterar</a></td> 
                            <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao(${funcionario.id},' ${funcionario.nome}')">Excluir</button></td>
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
                          Confirmar exclusão do Funcionario  <label id="nomeFuncionario"></label> ?
                          <input id="idFuncionario" hidden/>

                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary" onclick="excluirFuncionario()">Confirmar</button>
                      </div>
                    </div>
                </div>
            </div>
            </br>
            <a href="index.jsp">MENU</a>
        </main>
        <footer>
            © 2020 SEXTETO SECRETO, TODOS OS DIREITOS RESERVADOS
        </footer>
    </body>
</html>

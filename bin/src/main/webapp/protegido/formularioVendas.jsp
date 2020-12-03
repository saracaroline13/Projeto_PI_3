<%-- 
    Document   : FormularioVendas
    Created on : 28/10/2020, 00:50:22
    Author     : Matheus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html lang="pt_BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Vendas</title>                        

    </head>
    <body>
        
         <h1><center>Formulário de Vendas</center></h1></br>
        
        <form action="FinalizarVenda" method="POST" class="container">
            
            <input name="data_venda" id="data" onkeypress="$(this).mask('00/00/0000');" required="true"/></br>
            <label for="id_funcionario" required="true">Matricula Funcionário</label>
            <input type="text" name="id_funcionario" required="true">
                  Filial
                  <select name="filial">
                  <option value="Shop_SportsSP_1">Shop_SportsSP_1</option>
                  <option value="Shop_SportsSP_2">Shop_SportsSP_2</option>
                  <option value="Shop_SportsSP_3">Shop_SportsSP_3</option>
                  <option value="Shop_SportsRJ_1">Shop_SportsRJ_1</option>
                  </select></br>

            <label for="cliente">CPF Cliente</label>
            <input type="cpf_cliente" name="cpf_cliente" maxlength="11"></br>
        
       

            <h2>Produtos</h2>
            <table id="tbproduto" class="table table-bordered table-hover">
                <thead class="thead-light">
                <th scope="col">ID produto</th>
                <th scope="col">Produto</th>
                <th scope="col">Categoria</th>
                <th scope="col">Tamanho</th>
                <th scope="col">Valor</th>
                <th scope="col">Filial</th>
                <th scope="col">Qtd. Estoque</th>
                <th scope="col">Adicionar</th>
                </thead>
                <tbody>
                    <c:forEach var="produto" items="${listaProdutos}">
                        <tr class="produto">
                            <td class="produto--id">${produto.id}</td>
                            <td class="produto--produto">${produto.produto}</td>
                            <td class="produto--categoria">${produto.categoria}</td>
                            <td class="produto--tamanho">${produto.tamanho}</td>
                            <td class="produto--valor">${produto.valor}</td>
                            <td class="produto--filial">${produto.filial}</td>
                            <td class="produto--estoque">${produto.estoque}</td>
                            <td class="produto--add"><button type="button" class="btn btn-primary" onclick="addCarrinho(${produto.id}, ' ${produto.produto}', ' ${produto.tamanho}',${produto.valor},${produto.estoque}, this)"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-cart-plus-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM4 14a1 1 0 1 1 2 0 1 1 0 0 1-2 0zm7 0a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM9 5.5a.5.5 0 0 0-1 0V7H6.5a.5.5 0 0 0 0 1H8v1.5a.5.5 0 0 0 1 0V8h1.5a.5.5 0 0 0 0-1H9V5.5z"/>
</svg></button></td>
                        </tr>     
                    </c:forEach> 
                </tbody>
            </table>


            <script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
            <script src="//cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>


            <script>
                                $(document).ready(function () {
                                    $('#tbproduto').DataTable({
                                        "language": {
                                            "lengthMenu": "Mostrando _MENU_ registros por página",
                                            "zeroRecords": "Nada encontrado",
                                            "info": "Mostrando página _PAGE_ de _PAGES_",
                                            "infoEmpty": "Nada Encontrado",
                                            "infoFiltered": "(filtrado de _MAX_ registros no total)"
                                        }
                                    });
                                });
            </script>


            <h2>Carrinho</h2>
            <table id="tbCarrinho" class="table table-bordered table-hover" >
                <thead class="thead-dark">
                <th scope="col">ID produto</th>
                <th scope="col">Produto</th>
                <th scope="col">Tamanho</th>
                <th scope="col">Quantidade</th>
                <th scope="col">Valor</th>
                <th scope="col">Retirar</th>
                </thead>
                <tbody>

                </tbody>
            </table>




            <section class="pagamento">
                <h2>Pagamento</h2></br>
                <input type="radio" name="tipopagamento" value="Dinheiro"/>Dinheiro </br>
                <input type="radio" name="tipopagamento" value="Cartão de Débito"/>Cartão de Débito </br>
                <input type="radio" name="tipopagamento" value="Cartão de Crédito"/>Cartão de Crédito </br>
                <input type="radio" name="tipopagamento" value="Cartão Presente"/>Cartão Presente </br>
            </section></br>
            
            <!--<label>Desconto: </h3><input type="text"/>-->
            <p align="left"><label>Total Compra:</label><b>R$</><b id="totaldacompra" name="tipo_pagamento">0</b></p>

            <section class="finalizar">
                <button type="submit" class="btn btn-success">Finalizar</button>
                <a href="index.jsp"><button type="button" class="btn btn-primary" >Cancelar</button></a>
            </section>



        </form>


        <script lang="text/javascript">
            var tb;
            
            function addCarrinho(id, produto, tamanho, valor, obj) {
                //identificar a quantidade
                tb = document.getElementById("tbCarrinho");//armazena a tabela que irá adicionar o produto do cliente
                    var qtdLinhas = tb.rows.length;//quantidade linhas                    


                    let produtos = $('.produto--id');
                    let produtoIndice = 0;

                    //forEach(armazena um item do array por vez, o índice desse item no array)
                    produtos.toArray().forEach((item, indice) => {//selecionar o produto correto de acordo com o ID e armazenar o indice dele
                        let idItemAtual = $(item).text();
                        if (+idItemAtual === +id) {//verifica quando o indice de dentro do array que contem o valor da tag == indice passado
                            produtoIndice = indice;//armazenando o indice
                        }
                    });

                    //document.querySelectorAll('produto--estoque')  == $('.produto--estoque')  => Retorna um Array/Lista
                    let tagEstoque = $('.produto--estoque')[produtoIndice];//pegar a quantidade de estoque do produto correto
                //
                if ($(tagEstoque).text() <= 0) {
                    alert("Produto sem estoque suficiente");
                } 
                else {
                    tb = document.getElementById("tbCarrinho");//armazena a tabela que irá adicionar o produto do cliente
                    var qtdLinhas = tb.rows.length;//quantidade linhas                    


                    let produtos = $('.produto--id');
                    let produtoIndice = 0;

                    //forEach(armazena um item do array por vez, o índice desse item no array)
                    produtos.toArray().forEach((item, indice) => {//selecionar o produto correto de acordo com o ID e armazenar o indice dele
                        let idItemAtual = $(item).text();
                        if (+idItemAtual === +id) {//verifica quando o indice de dentro do array que contem o valor da tag == indice passado
                            produtoIndice = indice;//armazenando o indice
                        }
                    });

                    //document.querySelectorAll('produto--estoque')  == $('.produto--estoque')  => Retorna um Array/Lista
                    let tagEstoque = $('.produto--estoque')[produtoIndice];//pegar a quantidade de estoque do produto correto
                    let adicionouItem = $(tagEstoque).text() > 0;
                    $(tagEstoque).text(adicionouItem == true ? +$(tagEstoque).text() - 1 : 0);//if ternario                    


                    if (adicionouItem) {
                        let listaIdsCarrinho = $('.carrinho--produto-id');
                        let indiceCarrinho = null;

                        listaIdsCarrinho.toArray().forEach((item, indice) => {
                            let idItemAtual = $(item).text();
                            if (+idItemAtual === +id) {
                                indiceCarrinho = indice;
                            }
                        });

                        if (indiceCarrinho == null) {
                            var linha = tb.insertRow(qtdLinhas);//adiciona em baixo de onde não tem linha
                            var cellCodigo = linha.insertCell(0);
                            var cellProduto = linha.insertCell(1);
                            var cellTamanho = linha.insertCell(2);
                            var cellQuantidade = linha.insertCell(3)
                            var cellValor = linha.insertCell(4);
                            const cellRemover = linha.insertCell(5);

                            cellCodigo.innerHTML = id;
                            cellCodigo.classList.add('carrinho--produto-id');
                            cellProduto.innerHTML = produto;
                            cellTamanho.innerHTML = tamanho;
                            cellQuantidade.innerHTML = 1;
                            cellQuantidade.classList.add('carrinho--produto-quantidade');
                            cellValor.innerHTML = valor;
                            cellValor.classList.add('carrinho--produto-valor');
                            cellRemover.innerHTML = cellRemover.innerHTML + "<button type='button' class='btn btn-secondary' onclick='removerLinha(this)'>-</button>";
                            
                             $(function(){
                                var total = 0;
                                $('.carrinho--produto-valor').each(function(){
                                  total += parseFloat(jQuery(this).text());
                                });

                                $('#totaldacompra').html(total);

                              });
                            
                            
                        } else {
                            let quantidadeProduto = $('.carrinho--produto-quantidade')[indiceCarrinho];
                            let valorProduto = $('.carrinho--produto-valor')[indiceCarrinho];
                            $(quantidadeProduto).text(+$(quantidadeProduto).text() + 1);
                            $(valorProduto).text(+valor * +$(quantidadeProduto).text());
                             
                               $(function(){
                                var total = 0;
                                $('.carrinho--produto-valor').each(function(){
                                  total += parseFloat(jQuery(this).text());
                                });

                                $('#totaldacompra').html(total);

                              });
                            
                            
                        }
                    }
                    //
                    function adicionaritemnasessao(id){
                        $.get("CarrinhoServlet?id="+id, function( resposta){
                           console.log("OK"); 
                        });
                    }
                    //
                    adicionaritemnasessao(id);
                }
                
            }
            
            function removerLinha(obj) {

                //parentNode -> Seleciona o pai do objeto passado
                //children -> Seleciona todos os filhos, gerando um vetor
                //debugger;
                // Capturamos a referência da TR (linha) pai do objeto
                var objTR = obj.parentNode.parentNode;
                // Capturamos a referência da TABLE (tabela) pai da linha
                var objTable = objTR.parentNode;
                // Capturamos o índice da linha
                var indexTR = objTR.rowIndex;
                // Chamamos o método de remoção de linha nativo do JavaScript, passando como parâmetro o índice da linha  

                let id = +$(objTR.children[0]).text();
                let quantidadeCarrinho = $('.carrinho--produto-quantidade')[indexTR - 1];
                if ($(quantidadeCarrinho).text() == 1) {

                    objTable.deleteRow(indexTR);
                    $(function(){
                                var total = 0;
                                $('.carrinho--produto-valor').each(function(){
                                  total += parseFloat(jQuery(this).text());
                                });

                                $('#totaldacompra').html(total);

                              });
                    
                             
                } else {
                    let valorCarrinho = $('.carrinho--produto-valor')[indexTR - 1];
                    let valor = +$(valorCarrinho).text()/+$(quantidadeCarrinho).text();
                    $(quantidadeCarrinho).text($(quantidadeCarrinho).text() - 1);
                    $(valorCarrinho).text(+valor * +$(quantidadeCarrinho).text());
                     $(function(){
                                var total = 0;
                                $('.carrinho--produto-valor').each(function(){
                                  total += parseFloat(jQuery(this).text());
                                });

                                $('#totaldacompra').html(total);

                              });

                            
                }

                //---------PARTE DE PEGAR O INDICE CORRETO DA LINHA DA TBPRODUTO
                let produtos = $('.produto--id');
                let produtoindex = 0;
                //console.log('id: ', id);id
                produtos.toArray().forEach((item, index) => {//selecionar o produto correto de acordo com o ID e armazenar o indice dele
                    let currentId = $(item).text();
                    if (+currentId === +id) {
                        console.log('Current Id: ', currentId);
                        produtoindex = index;//armazenando o indice
                    }
                });
                //COLOCANDO UM VALOR NO INDICE DA LINHA QUE ACHAMOS A CIMA
                let tagEstoque = $('.produto--estoque')[produtoindex];//pegar a quantidade de estoque do produto correto                
                $(tagEstoque).text(+$(tagEstoque).text() + 1);//if ternario   

                 //
                    function retiraritemnasessao(id){
                        $.get("CarrinhoServletMinus?currentId="+id, function( resposta){
                           console.log("retiradoo"); 
                        });
                    }
                    //
                    retiraritemnasessao(id);
            }
            
           
            
        </script>
        
        
    </body>
</html>

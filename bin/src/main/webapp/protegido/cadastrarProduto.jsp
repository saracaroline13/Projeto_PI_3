<%-- 
    Document   : cadastrarProduto
    Created on : 16/10/2020, 22:22:43
    Author     : Matheus
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html>
    <%@include file = "../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet">
        <title>Cadastrar Produto</title>
    </head>
    
    <body>
        <header>
            <a href="index.jsp">
                <img src="imagens/slogan_sem_fundo_1.png" alt="Logo da Loja" />
            </a>
        </header>
        
        <main class="container">
            <h1>Cadastro de Produto</h1>
            <form action="CadastrarProduto" method="POST">
                <p>Nome do Produto</p>
                <input name="produto" class="form-control" required="true"/></br>

                  <p>Categoria do Produto</p>
                  <select name="categoria">
                  <option value="Calçados">Calçados</option>
                  <option value="Roupas">Roupas</option>
                  <option value="Equipamentos">Equipamentos</option>
                  </select></br>

                  <p>Tamanho</p>
                  <input name="tamanho" class="form-control" required="true"/></br>

                  <p>Preço</p>
                  <input name ="valor" class="form-control" required="true"/></br>

                  <p>Categoria do Produto</p>
                  <select name="filial">
                  <option value="Shop_SportsSP_1">Shop_SportsSP_1</option>
                  <option value="Shop_SportsSP_2">Shop_SportsSP_2</option>
                  <option value="Shop_SportsSP_3">Shop_SportsSP_3</option>
                  <option value="Shop_SportsRJ_1">Shop_SportsRJ_1</option>
                  </select></br>

                  <p>Quantidade em Estoque</p>
                  <input name="estoque" class="form-control" required="true"/></br>



                <button type="submit" class="btn btn-primary">Concluir</button>

            </form>
        </main>
        
        <footer>
            © 2020 SEXTETO SECRETO, TODOS OS DIREITOS RESERVADOS
        </footer>
    </body>
</html>

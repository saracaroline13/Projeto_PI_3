<%-- 
    Document   : alterarCliente
    Created on : 14/10/2020, 22:34:17
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html>
    <%@include file = "../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <title>Atualização de Cliente</title>
    </head>
    <body>
        <header>
            <a href="index.jsp">
                <img src="imagens/slogan_sem_fundo_1.png" alt="Logo da Loja" />
            </a>
        </header>
        
        <main class="container">
            <h1>Alteração de Cadastro do Cliente: ${cliente.nome}</h1>
            </br>
            <form action="AlterarCliente" method="POST">
                <p>Matricula</p>
                    <input name="id" value="${cliente.id}" readonly="true" />
                <p>Nome</p>
                    <input name ="nome" value="${cliente.nome}" class="form-control" required="true"/>
                <p>CPF</p>
                    <input name ="cpf" value="${cliente.cpf}" class="form-control" required="true"/>
                <p>Sexo</p>
                    <input name="sexo" value="${cliente.sexo}" class="form-control" required="true"/>
                <p>E-mail</p>
                    <input name="email" value="${cliente.email}" class="form-control" required="true"/>
                <p>Celular</p>
                    <input name="celular" value="${cliente.celular}" class="form-control" onkeypress="$(this).mask('(00)00000-0000');" required="true"/>
                <p>Rua</p>
                    <input name="rua" value="${cliente.rua}" class="form-control" required="true"/>
                <p>Bairro</p>
                    <input name="bairro" value="${cliente.bairro}" class="form-control" required="true"/>
                <p>CEP</p>
                    <input name="cep" value="${cliente.cep}" class="form-control" onkeypress="$(this).mask('00000-000');" required="true"/>
                <p>Cidade</p>
                    <input name="cidade" value="${cliente.cidade}" class="form-control" required="true"/></br>

            <button type="submit">Concluir</button>
        </main>
                
        <footer>
            © 2020 SEXTETO SECRETO, TODOS OS DIREITOS RESERVADOS
        </footer>
    </body>
</html>

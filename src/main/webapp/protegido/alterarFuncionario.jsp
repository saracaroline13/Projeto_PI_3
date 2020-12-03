<%-- 
    Document   : alterarFuncionario
    Created on : 09/10/2020, 16:21:16
    Author     : Matheus
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html>
    <%@include file = "../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet">
        <title>Atualização de Funcionario</title>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <header>
            <a href="index.jsp">
                <img src="imagens/slogan_sem_fundo_1.png" alt="Logo da Loja" />
            </a>
        </header>
        
        <main class="container">
        <h1>Alteração de Cadastro do Funcionario: ${funcionario.nome}</h1>
        </br>
        <form action="AlterarFuncionario" method="POST">
            <p>Matricula</p>
            <input name="id" value="${funcionario.id}" readonly="true" />
            
            <p>Filial</p>
            <input name="filial" value="${funcionario.filial}" class="form-control" readonly="true"/>
            <p>Nome</p>
            <input name ="nome" value="${funcionario.nome}" class="form-control" required="true"/>
            <p>CPF</p>
            <input name ="cpf" value="${funcionario.cpf}" class="form-control" required="true"/>
            <p>Sexo</p>
            <input name="sexo" value="${funcionario.sexo}" class="form-control" required="true"/>
            <p>Data Nascimento</p>
            <input name="data_nasc" value="${funcionario.data_nasc}" onkeypress="$(this).mask('00/00/0000');" class="form-control" required="true"/>
            <p>Estado Civil</p>
            <input name="estado_civil" value="${funcionario.estado_civil}" class="form-control" required="true"/>
            <p> Cargo</p>
            <input name="cargo" value="${funcionario.cargo}" class="form-control" required="true"/>
            <p> Salario</p>
            <input name="salario" value="${funcionario.salario}" class="form-control" required="true"/>
            <p>E-mail</p>
            <input name="email" value="${funcionario.email}" class="form-control" required="true"/>
            <p>Celular</p>
            <input name="contato" value="${funcionario.contato}" onkeypress="$(this).mask('(00)00000-0000');" class="form-control" required="true"/>
            <p>Rua</p>
            <input name="rua" value="${funcionario.rua}" class="form-control" required="true"/>
            <p>Bairro</p>
            <input name="bairro" value="${funcionario.bairro}" class="form-control" required="true"/>
            <p>CEP</p>
            <input name="cep" value="${funcionario.cep}" onkeypress="$(this).mask('00000-000');" class="form-control" required="true"/>
            <p>Cidade</p>
            <input name="cidade" value="${funcionario.cidade}" class="form-control" required="true"/></br>
            
            <button type="submit">Concluir</button>
            </main>
        <footer>
            © 2020 SEXTETO SECRETO, TODOS OS DIREITOS RESERVADOS
        </footer>
    </body>
</html>

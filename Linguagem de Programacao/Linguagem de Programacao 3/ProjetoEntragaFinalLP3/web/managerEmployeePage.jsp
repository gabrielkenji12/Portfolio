<%-- 
    Document   : managerEmployeePage.jsp
    Created on : 25/09/2017, 13:03:38
    Author     : 41528387
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if(session.getAttribute("admin") == null) {
        response.sendRedirect("index.jsp?error=Acesso negado");
        return;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GERENCIAMENTO DE FUNCIONARIO</title>
    </head>
    <body>
        <h1>Gerenciar Funcionarios</h1>
        <form action="FrontController" method="POST">
            <p>Opções:</p>
            <p>1- Registrar novo funcionario</p>
            <p>2- Visualizar Todos Funcionarios Cadastrados</p>
            <p>3- Pesquisar Funcionario pelo ID</p>
            <p>4- Atualizar Funcionario Cadastrado</p>
            <p>5- Deletar Funcionario</p>
            <p>
                <input type="text" name="controladorAcesso"/>
            </p>
            <input type="hidden" name="control" value="EmployeeAcessController"/>
            <p>
                <input type="submit" value="ESCOLHA"/>
            </p>
            <a href="managerPage.jsp">Voltar </a>
        </form>
    </body>
</html>

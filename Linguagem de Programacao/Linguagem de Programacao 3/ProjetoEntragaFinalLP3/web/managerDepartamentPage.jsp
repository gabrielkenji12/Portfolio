<%-- 
    Document   : managerDepartamentPage.jsp
    Created on : 25/09/2017, 22:03:16
    Author     : BadJapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Departament</title>
    </head>
    <body>
        <h1>Gerenciar Departamentos</h1>
         <form action="FrontController" method="POST">
            <p>Opções:</p>
            <p>1- Registrar novo Departamento</p>
            <p>2- Visualizar Todos Departamentos</p>
            <p>3- Atualizar Departamento Cadastrado</p>
            <p>4- Deletar Departamento</p>
            <p>
                <input type="text" name="controladorAcesso"/>
            </p>
            <input type="hidden" name="control" value="DepartamentAcessController"/>
            <p>
                <input type="submit" value="ESCOLHA"/>
            </p>
            <a href="managerPage.jsp">Voltar </a>
        </form>
    </body>
</html>

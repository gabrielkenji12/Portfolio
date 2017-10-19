<%-- 
    Document   : registerDepartament.jsp
    Created on : 25/09/2017, 22:10:21
    Author     : BadJapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <fieldset>
            <legend>Registrar Novo Departamento</legend>
            <form action="FrontController" method="POST">
                <p>
                    <label for="nameID">Nome:</label><br>
                    <input type="text" name="name" id="nameID"/>
                </p>
                <input type="hidden" name="control" value="DepartamentController.register"/>
                <p>
                    <input type="submit" value="REGISTRAR"/>
                </p>
            </form>
            <fieldset>
                <legend>Resultado </legend>
                <p>
                    ${resultCreate}
                </p>
                <br><br>
                <a href="managerDepartamentPage.jsp">VOLTAR</a>
            </fieldset>
        </fieldset>
    </body>
</html>

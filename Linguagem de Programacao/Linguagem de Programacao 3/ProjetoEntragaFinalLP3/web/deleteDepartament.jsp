<%-- 
    Document   : deleteDepartament.jsp
    Created on : 25/09/2017, 22:25:09
    Author     : BadJapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete</title>
    </head>
    <body>
        <fieldset>
            <legend>Excluir Departamento</legend>
            <form action="FrontController" method="POST">
                <p>
                    <label for="searchID">ID:</label><br>
                    <input type="text" name="search" id="searchID"/>
                </p>
                <input type="hidden" name="control" value="DepartamentController.delete"/>
                <p>
                    <input type="submit" value="EXCLUIR"/>
                </p>
            </form>
        </fieldset>
        <fieldset>
            <legend>Resultado </legend>
            <p>
                ${resultDelete}
            </p>
            <br><br>
             <a href="managerDepartamentPage.jsp">VOLTAR</a>
        </fieldset>
    </body>
</html>

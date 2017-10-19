<%-- 
    Document   : updateDepartament.jsp
    Created on : 25/09/2017, 22:21:13
    Author     : BadJapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <fieldset>
            <legend>Atualizar Departamento</legend>
            <form action="FrontController" method="POST">
                <p>
                    <label for="searchID">ID:</label><br>
                    <input type="text" name="search" id="searchID"/>
                </p>
                <p>
                    <label for="nameID">Name:</label><br>
                    <input type="text" name="name" id="nameID"/>
                </p>
                <input type="hidden" name="control" value="DepartamentController.update"/>
                <p>
                    <input type="submit" value="ATUALIZAR"/>
                </p>
            </form>
        </fieldset>
        <fieldset>
            <legend>Resultado </legend>
            <p>
                ${resultUpdate}
            </p>
            <br><br>
             <a href="managerDepartamentPage.jsp">VOLTAR</a>
        </fieldset>
    </body>
</html>

<%-- 
    Document   : deleteEmployee.jsp
    Created on : 25/09/2017, 16:52:05
    Author     : BadJapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DELETE</title>
    </head>
    <body>
        <fieldset>
            <legend>Excluir Funcionario</legend>
            <form action="FrontController" method="POST">
                <p>
                    <label for="searchID">ID:</label><br>
                    <input type="text" name="search" id="searchID"/>
                </p>
                <input type="hidden" name="control" value="EmployeeController.delete"/>
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
             <a href="managerEmployeePage.jsp">VOLTAR</a>
        </fieldset>
    </body>
</html>

<%-- 
    Document   : readByIdEmployee.jsp
    Created on : 25/09/2017, 16:51:41
    Author     : BadJapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>READ BY ID</title>
    </head>
    <body>
        <fieldset>
            <legend>BUSCAR FUNCIONARIO PELO ID</legend>
         <form action="FrontController" method="POST">
                <p>
                    <label for="searchID">ID:</label><br>
                    <input type="text" name="searchID" id="searchID"/>
                </p>
                <input type="hidden" name="control" value="EmployeeController.readById"/>
                <p>
                    <input type="submit" value="BUSCAR"/>
                </p>
         </form>
        </fieldset>
        <br><br>
        <fieldset>
            <legend>Resultado</legend>
                <br>
                <p>
                    ${employee}
                </p><br>
                <a href="managerEmployeePage.jsp">VOLTAR</a>
        </fieldset>
    </body>
</html>

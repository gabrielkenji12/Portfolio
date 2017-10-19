<%-- 
    Document   : updateEmployee.jsp
    Created on : 25/09/2017, 16:51:54
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
            <legend>Atualizar Funcionario</legend>
            <form action="FrontController" method="POST">
                <p>
                    <label for="searchID">ID:</label><br>
                    <input type="text" name="search" id="searchID"/>
                </p>
                <p>
                    <label for="nameID">Name:</label><br>
                    <input type="text" name="name" id="nameID"/>
                </p>
                <p>
                    <label for="adressID">Adress:</label><br>
                    <input type="text" name="adress" id="adressID"/>
                </p>
                <p>
                    <label for="telID">Fone number:</label><br>
                    <input type="text" name="tel" id="telID"/>
                </p>
                <p>
                    <label for="emailID">Email:</label><br>
                    <input type="text" name="email" id="emailID"/>
                </p>
                <p>
                    <label for="departamentID">Departament:</label><br>
                    <input type="text" name="departament" id="departamentID"/>
                </p>
                <input type="hidden" name="control" value="EmployeeController.update"/>
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
             <a href="managerEmployeePage.jsp">VOLTAR</a>
        </fieldset>
    </body>
</html>

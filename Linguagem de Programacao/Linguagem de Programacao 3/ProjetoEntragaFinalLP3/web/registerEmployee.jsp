<%-- 
    Document   : CadastroFuncionario
    Created on : Sep 24, 2017, 7:57:23 PM
    Author     : Matheus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="projeto_lp3_projects.entities.Departament"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <fieldset>
            <legend>Registrar Novo Funcionario</legend>
            <form action="FrontController" method="POST">
                <p>
                    <label for="nameID">Nome:</label><br>
                    <input type="text" name="name" id="nameID"/>
                </p>
                <p>
                    <label for="adressID">Endereço:</label><br>
                    <input type="text" name="adress" id="adressID"/>
                </p>
                <p>
                    <label for="cpfID">CPF:</label><br>
                    <input type="text" name="cpf" id="cpfID"/>
                </p>
                <p>
                    <label for="telID">Telefone:</label><br>
                    <input type="text" name="tel" id="telID"/>
                </p>
                <p>
                    <label for="emailID">Email:</label><br>
                    <input type="text" name="email" id="emailID"/>
                </p>
                <p>
                    <label for="birthdayID">Nascimento:</label><br>
                    <input type="text" name="birthday" id="birthdayID"/>
                </p>
                <p>
                    ${departaments}<br /><br><br>
                    <label for="departamentID">Departamento:</label><br>
                    <input type="text" name="departament" id="departamentID"/>
                </p>
                <input type="hidden" name="control" value="EmployeeController.register"/>
                <p>
                    <input type="submit" value="REGISTRAR"/>
                </p>
            </form>
            <fieldset>
                <legend>Resultado </legend>
                <p>
                    ${resultCreate}
                    ${resultBirthday}
                </p>
                <br><br>
                <a href="managerEmployeePage.jsp">VOLTAR</a>
            </fieldset>
        </fieldset>
    </body>
</html>

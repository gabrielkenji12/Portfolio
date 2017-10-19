<%-- 
    Document   : readAllEmployee.jsp
    Created on : 25/09/2017, 16:51:16
    Author     : BadJapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>READ ALL</title>
    </head>
    <body>
        <h1>TODOS OS FUNCIONÁRIOS CADASTRADOS</h1>
        <p> ${employees}</p>
        <br><br>
        <a href="managerEmployeePage.jsp">VOLTAR</a>
    </body>
</html>

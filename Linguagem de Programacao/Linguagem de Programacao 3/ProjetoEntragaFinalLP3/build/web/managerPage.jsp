<%-- 
    Document   : home
    Created on : Sep 24, 2017, 7:34:22 PM
    Author     : Matheus
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
        <title>HOME</title>
    </head>
    <body>
        <h1>Pagina de Admistrador</h1>
        <form action="FrontController" method="GET">
            <p>Opções:</p>
            <p>1- Gerenciar funcionários</p>
            <p>2- Gerenciar projetos</p>
            <p>3- Gerenciar departamentos</p>
            <p>
                <input type="text" name="controladorAcesso"/>
            </p>
            <input type="hidden" name="control" value="AccessController"/>
            <p>
                <input type="submit" value="ESCOLHA"/>
            </p>
        </form>
        <form action="FrontController" method="GET">
            <input type="hidden" name="control" value="logoffController"/>
            <input type="submit" value="LOGOFF"/>
        </form>
    </body>
</html>

<%-- 
    Document   : LoginFuncionario
    Created on : Sep 24, 2017, 7:57:56 PM
    Author     : Matheus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <fieldset>
            <legend>Admnistrador</legend>
            <form action="FrontController" method="GET">
                <p>
                    <label for="usernameID">Username:</label><br>
                    <input type="text" name="username" id="usernameID"/>
                </p>
                <p>
                    <label for="pwdID">Password:</label><br>
                    <input type="password" name="password" id="pwdIDLogin"/>
                </p>
                <input type="hidden" name="control" value="EnterAsADMController"/>
                <p>
                    <input type="submit" value="LOGIN"/>
                </p>
            </form>
        </fieldset>
        
    </body>
</html>

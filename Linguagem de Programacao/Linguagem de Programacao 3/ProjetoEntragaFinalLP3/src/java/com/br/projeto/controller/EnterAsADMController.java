/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projeto.controller;

/**
 *
 * @author 31618571
 */
public class EnterAsADMController extends AbstractController{

    @Override
    public void execute() {
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        
        if(username.equals("admin") && pwd.equals("123") ){
            request.getSession().setAttribute("admin", username);
            returnPage = "managerPage.jsp";
        }else{
            returnPage = "index.jsp";
        }
    }
    
}

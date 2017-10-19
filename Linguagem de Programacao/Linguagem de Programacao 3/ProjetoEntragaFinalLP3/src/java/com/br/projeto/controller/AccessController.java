/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projeto.controller;

/**
 *
 * @author Matheus
 */
public class AccessController extends AbstractController{

    @Override
    public void execute() {
        String access = request.getParameter("controladorAcesso");
        switch(access){
            case "1":
                returnPage = "managerEmployeePage.jsp";
                break;
            case "2":
                returnPage = "managerProjectsPage.jsp";
                break;
            case "3":
                returnPage = "managerDepartamentPage.jsp";
                break;
            default:
                returnPage = "errorAccess.jsp";
                break;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projeto.controller;

/**
 *
 * @author BadJapa
 */
public class logoffController extends AbstractController{

    @Override
    public void execute() {
        request.getSession().removeAttribute("admin");
        returnPage = "index.jsp";
    }
    
}

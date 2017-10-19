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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31618571
 */
public class ControlerFactory{
    
    public static Controller getControllerByName(String name){
        Controller controller = null;
        try {
            controller = (Controller)Class.forName("com.br.projeto.controller."+name).newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControlerFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControlerFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlerFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return controller;
    }
    
}

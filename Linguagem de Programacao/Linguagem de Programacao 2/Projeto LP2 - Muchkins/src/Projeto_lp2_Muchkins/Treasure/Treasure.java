/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Treasure;

import java.io.Serializable;

/**
 *
 * @author 41528387
 */
public abstract class Treasure implements Serializable{
    protected  String name;

    public Treasure(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }
    
    
    
    
}

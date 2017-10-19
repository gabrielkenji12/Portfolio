/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Job;

import java.io.Serializable;

/**
 *
 * @author 31618571
 */
public enum TypeJob implements Serializable{
    W("Warrior"),Wz("Wizard"),A("Archer"),R("Rogue");
    
    public String typeJobEnum;
    TypeJob(String type){
        typeJobEnum = type;
    }
    
    public String getJob(){
        return typeJobEnum;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Race;

import java.io.Serializable;

/**
 *
 * @author 31618571
 */
public enum TypeRace implements Serializable{
    H("Human"),D("Demon"),E("Elf"),Dw("Dwarf");
    
    public String typeRaceEnum;
    TypeRace(String type){
        typeRaceEnum = type;
    }
    
    public String getType(){
        return typeRaceEnum;
    }
}

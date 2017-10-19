/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Treasure;

import Projeto_lp2_Muchkins.Treasure.Treasure;
import java.io.Serializable;

/**
 *
 * @author 41528387
 */
public class Item extends Treasure implements Serializable{
    
    private String effect;

    public Item(String effect, String name) {
        super(name);
        this.effect = effect;
    }

    public String getEffect() {
        return effect;
    }

    @Override
    public String toString() {
        return "Nome = " + super.name +", Effeito = " + effect;
    }
    
    
    
}

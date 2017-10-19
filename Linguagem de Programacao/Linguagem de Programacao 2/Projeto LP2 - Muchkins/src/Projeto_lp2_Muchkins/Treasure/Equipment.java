/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Treasure;

import Projeto_lp2_Muchkins.Treasure.TypeEquip;
import Projeto_lp2_Muchkins.Treasure.Treasure;
import java.io.Serializable;

/**
 *
 * @author 41528387
 */
public class Equipment extends Treasure implements Serializable{
    
    private int gold;
    private int powerBonus;
    private TypeEquip typeEquip;

    public Equipment(int gold, int powerBonus, TypeEquip typeEquip, String name) {
        super(name);
        this.gold = gold;
        this.powerBonus = powerBonus;
        this.typeEquip = typeEquip;
    }

    public int getGold() {
        return gold;
    }

    public int getPowerBonus() {
        return powerBonus;
    }

    public TypeEquip getTypeEquip() {
        return typeEquip;
    }

    @Override
    public String toString() {
        return "Nome = " + super.name + ", Gold = " + gold + ", Poder = " + powerBonus + ", typeEquip = " + typeEquip;
    }

    
    
    
}

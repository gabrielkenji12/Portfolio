/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Monster;

import java.io.Serializable;

/**
 *
 * @author 41528387
 */
public class Monster implements Serializable{
    
    private int level;
    private String badThingText;
    private int badThing;
    private int goldDrop;
    private String name;
    private int power;

    public Monster(int level, String badThingText, int goldDrop, String name, int power) {
        this.level = level;
        this.badThingText = badThingText;
        this.goldDrop = goldDrop;
        this.name = name;
        this.power = power;
    }


    public int getLevel() {
        return level;
    }

    public String getBadThingText() {
        return badThingText;
    }

    public int getBadThing() {
        return badThing;
    }

    

    public int getGoldDrop() {
        return goldDrop;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Nome = " + name + "\nNivel = " + level + "\nCoisa Ruim = " + badThingText + "\nGold = " + goldDrop + "\nPoder = " + power;
    }

    

    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Match;

import java.io.Serializable;

/**
 *
 * @author 31618571
 */
public class Dice implements Serializable{
    private static Dice instance;
    public int selectedFace;
    
    private Dice(){
        this.selectedFace = 1;//Quando cria a face do dado vai ser 1
    }
    
    public static Dice getInstance(){
        if (instance == null){
            instance = new Dice();
        }
        return instance;
    }
    
    public int rodarDado(){
        int min = 1;
        int max = 6;
        selectedFace = min + (int)(Math.random() * ((max - min)+ 1));
        return selectedFace;
        
    }

}

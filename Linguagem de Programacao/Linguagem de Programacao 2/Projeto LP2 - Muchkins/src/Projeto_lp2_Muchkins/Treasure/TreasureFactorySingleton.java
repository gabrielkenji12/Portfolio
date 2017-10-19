/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Treasure;

import Projeto_lp2_Muchkins.Util.IOUtil;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 41528387
 */
public class TreasureFactorySingleton implements Serializable{
 
    private static TreasureFactorySingleton instance;
    private List<Treasure> treasures;
    File file = new File("treasures.txt");

    public TreasureFactorySingleton() {
        treasures = IOUtil.loadTreasures(file);
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }
    
    
    public Treasure newInstance(int escolha){
        Treasure t = null;
        return t;
    }
    
    public static TreasureFactorySingleton getInstance(){
        if (instance == null) {
            instance = new TreasureFactorySingleton();
        }
        return instance;
    }
    
    public Treasure ramdonTreasure(){
        int min = 0; 
        int max = treasures.size()-1;
        int escolha = min + (int)(Math.random() * ((max - min)+ 1));
        Treasure t = treasures.get(escolha);
        
        return t;
    }
    
    public Treasure ramdonStartingTreasure(){
        int min = 0;
        int max = 12;
        int escolha = min + (int)(Math.random() * ((max - min)+ 1));
        Treasure t = treasures.get(escolha);
        return t;
    }
    
    public void showTreasures(){
        for (Treasure treasure : treasures) {
            System.out.println(treasure);
            System.out.println("");
        }
    }
}

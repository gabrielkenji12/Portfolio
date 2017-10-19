/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Dungeon;

import Projeto_lp2_Muchkins.Monster.Monster;
import Projeto_lp2_Muchkins.Monster.MonsterFactorySingleton;
import Projeto_lp2_Muchkins.Treasure.Treasure;
import Projeto_lp2_Muchkins.Treasure.TreasureFactorySingleton;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 41528387
 */
public class Dungeon implements Serializable {

    private String name;
    private Treasure treasure;
    private Monster monster;
    private ArrayList<String> names;

    public Dungeon() {
        this.names = new ArrayList<>();

        String d1 = "The Dancing Vault";
        String d2 = "The Howling Tombs";
        String d3 = "Dragon Lair";
        String d4 = "The Murky Burrows";
        String d5 = "The Depraved Catacombs";
        String d6 = "The Swamp Labyrinth";
        names.add(d1);
        names.add(d2);
        names.add(d3);
        names.add(d3);
        names.add(d5);
        names.add(d6);
    }

    public String getName() {
        return name;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public Monster getMonster() {
        return monster;
    }

    public void createDungeon(int playerLevel) {
        MonsterFactorySingleton mfs = MonsterFactorySingleton.getInstance();
        TreasureFactorySingleton tfs = TreasureFactorySingleton.getInstance();

        randomName();
        //Gera um numero aleatoria para decidir se a dungeon terá ou nao monstros;
        int probabity = 1 + (int) (Math.random() * ((9 - 1) + 1));
        if (probabity == 6) {
            this.treasure = tfs.ramdonTreasure();
            this.monster = null;
        } else {
            do{
                this.monster = mfs.randomMonster();
                this.treasure = tfs.ramdonTreasure();
            }while(this.monster.getPower() > playerLevel + 4);
        }
    }

    public void randomName() {
        int min = 0;
        int max = names.size() - 1;
        int escolha = min + (int) (Math.random() * ((max - min) + 1));
        try {
            this.name = names.get(escolha);
        } catch (IndexOutOfBoundsException ex) {
            this.name = "Dragon Lair";
        }
    }

    @Override
    public String toString() {
        return "Dungeon{" + "name=" + name + ", treasure=" + treasure + ", monster=" + monster + '}';
    }

}

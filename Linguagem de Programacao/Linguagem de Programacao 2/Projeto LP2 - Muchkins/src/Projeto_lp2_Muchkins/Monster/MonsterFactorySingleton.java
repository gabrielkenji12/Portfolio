/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Monster;

import Projeto_lp2_Muchkins.Util.IOUtil;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 41528387
 */
public class MonsterFactorySingleton implements Serializable {

    private static MonsterFactorySingleton instance;
    private List<Monster> monster;
    private File f = new File("monsters.txt");

    public MonsterFactorySingleton() {
        this.monster = IOUtil.loadMonsters(f);
    }

    public static MonsterFactorySingleton getInstance() {
        if (instance == null) {
            instance = new MonsterFactorySingleton();
        }
        return instance;
    }

    public Monster randomMonster() {
        Monster m = null;
        try {
            int min = 0;
            int max = monster.size() - 1;
            int escolha = min + (int) (Math.random() * ((max - min) + 1));
            m = monster.get(escolha);
        } catch (NullPointerException | IndexOutOfBoundsException ex) {
            m = monster.get(5);
        }
        return m;
    }

    public void showMonsters() {
        for (Monster m : monster) {
            System.out.println(m);
            System.out.println("");
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.GameFiles;

import Projeto_lp2_Muchkins.Monster.Monster;
import Projeto_lp2_Muchkins.Treasure.Equipment;
import Projeto_lp2_Muchkins.Treasure.Item;
import Projeto_lp2_Muchkins.Treasure.Treasure;
import Projeto_lp2_Muchkins.Treasure.TypeEquip;
import Projeto_lp2_Muchkins.Util.IOUtil;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author 41528387
 */
public class GameFiles {

    public GameFiles() {
        File f1 = new File("monsters.txt");
        File f2 = new File("treasures.txt");
        
        ArrayList<Treasure> treasures = new ArrayList<>();
        Equipment e1 = new Equipment(300, 2, TypeEquip.ONEHAND, "Steel Sword");
        Equipment e2 = new Equipment(500, 3, TypeEquip.ONEHAND, "Rod of Wisdom");
        Equipment e3 = new Equipment(700, 5, TypeEquip.ONEHAND, "Mageblade");
        Equipment e4 = new Equipment(800, 5, TypeEquip.ONEHAND, "Espada Enferrujada");
        Equipment e5 = new Equipment(1000, 7, TypeEquip.ONEHAND, "Thief Dagger");
        Equipment e22 = new Equipment(900, 5, TypeEquip.ONEHAND, "Flame Sword");
        Equipment e23 = new Equipment(300, 2, TypeEquip.ONEHAND, "Iron Axe");
        Equipment e24 = new Equipment(500, 3, TypeEquip.ONEHAND, "Big Shield");
        
        Equipment e6 = new Equipment(600, 5, TypeEquip.TWOHAND, "Soul Staff");
        Equipment e7 = new Equipment(800, 7, TypeEquip.TWOHAND, "Heartseeker");
        Equipment e8 = new Equipment(1000, 10, TypeEquip.TWOHAND, "Soulless Greatsword");
        Equipment e9 = new Equipment(1500, 12, TypeEquip.TWOHAND, "Thunder Hammer");
        
        Equipment e10 = new Equipment(300, 2, TypeEquip.HEAD, "Mage Hat");
        Equipment e11 = new Equipment(300, 1, TypeEquip.HEAD, "Iron Helm");
        Equipment e12 = new Equipment(500, 3, TypeEquip.HEAD, "Priest Mantle");
        Equipment e13 = new Equipment(600, 4, TypeEquip.HEAD, "Shadow Helmet");
        Equipment e14 = new Equipment(600, 4, TypeEquip.HEAD, "Flame Hat");
        Equipment e15 = new Equipment(800, 6, TypeEquip.HEAD, "Dragon Crown");
        
        Equipment e16 = new Equipment(200, 1, TypeEquip.FOOT, "Walker of Vengeance");
        Equipment e17 = new Equipment(300, 2, TypeEquip.FOOT, "Iron Walkers");
        Equipment e18 = new Equipment(300, 3, TypeEquip.FOOT, "Scaled Walkers");
        Equipment e19 = new Equipment(400, 3, TypeEquip.FOOT, "Frozen Hells");
        Equipment e20 = new Equipment(400, 3, TypeEquip.FOOT, "Burning Sabatons");
        Equipment e21 = new Equipment(500, 4, TypeEquip.FOOT, "Dragon Warboots");
        
        Item i1 = new Item("Suba 1 Nivel", "Fortify Potion");
        Item i2 = new Item("Suba 1 Nivel", "Power Potion");
        Item i3 = new Item("Suba 1 Nivel", "Wisdow Potion");
        Item i4 = new Item("Suba 1 Nivel", "Vitality Potion");
        Item i5 = new Item("Suba 1 Nivel", "Druid Potion");
        Item i6 = new Item("Suba 1 Nivel", "Phoenix Down");
        
        treasures.add(e1);
        treasures.add(e2);
        treasures.add(e24);
        treasures.add(e23);
        treasures.add(e10);
        treasures.add(e11);
        treasures.add(e12);
        treasures.add(e16);
        treasures.add(e17);
        treasures.add(e18);
        treasures.add(i1);
        treasures.add(i2);
        treasures.add(e3);
        treasures.add(i3);
        treasures.add(e4);
        treasures.add(e5);
        treasures.add(e6);
        treasures.add(e7);
        treasures.add(e8);
        treasures.add(e9);
        treasures.add(e13);
        treasures.add(e14);
        treasures.add(e15);
        treasures.add(e19);
        treasures.add(e20);
        treasures.add(e21);
        treasures.add(i4);
        treasures.add(i5);
        treasures.add(i6);
        
        
        ArrayList<Monster>monster = new ArrayList<>();
        Monster m1 = new Monster(1, "Perde 300 golds", 100, "Mr Bones", 2);
        Monster m2 = new Monster(2, "Perde seu Chapeu", 200, "Shadow Thief", 3);
        Monster m3 = new Monster(2, "Perde 300 golds", 200, "Miss Bones", 3);
        Monster m4 = new Monster(2, "Perde sua Bota", 200, "Lizzard Guy", 3);
        Monster m5 = new Monster(3, "Perde 1 Nivel", 300, "Little Witch", 4);
        Monster m6 = new Monster(3, "Perde 1 Nivel", 400, "Hungry Chicken", 5);
        Monster m7 = new Monster(4, "Perde 500 golds", 400, "Dirty Rat", 5);
        Monster m8 = new Monster(5, "Perde 500 golds", 400, "Carnivorous Plant", 6);
        Monster m9 = new Monster(5, "Perde 2 Niveis", 400, "Centaur", 6);
        Monster m10 = new Monster(6, "Perde seu Chapeu", 500, "Big Foot", 7);
        Monster m11 = new Monster(6, "Perde 500 golds", 600, "Green Thing", 8);
        Monster m12 = new Monster(7, "Perde 2 Niveis", 600, "Man Eater", 9);
        Monster m13 = new Monster(7, "Perde 500 golds", 600, "Magic Dragon", 10);
        Monster m14 = new Monster(8, "Perde 1000 golds", 700, "Blood Dragon", 11);
        Monster m15 = new Monster(9, "Perde 3 Niveis", 700, "Face Sucker", 12);
        Monster m16 = new Monster(10, "Perde sua Bota", 1000, "The Loch Ness Monster", 15);
        monster.add(m1);
        monster.add(m2);
        monster.add(m3);
        monster.add(m4);
        monster.add(m5);
        monster.add(m6);
        monster.add(m7);
        monster.add(m8);
        monster.add(m9);
        monster.add(m10);
        monster.add(m11);
        monster.add(m12);
        monster.add(m13);
        monster.add(m14);
        monster.add(m15);
        monster.add(m16);
        
        IOUtil.saveArrayMonsters(f1, monster);
        IOUtil.saveArrayTreasures(f2, treasures);
    }
    
   
}

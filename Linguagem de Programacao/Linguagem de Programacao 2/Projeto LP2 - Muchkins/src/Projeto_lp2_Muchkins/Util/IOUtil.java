/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Util;

import Projeto_lp2_Muchkins.Match.Match;
import Projeto_lp2_Muchkins.Monster.Monster;
import Projeto_lp2_Muchkins.Treasure.Treasure;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author BadJapa
 */
public class IOUtil {

    public static void salvaPartidas(File file, ArrayList<Match> partidas) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(partidas);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException ex) {
            System.out.println("Problema no fluxo de saída");
        }

    }

    public static ArrayList<Match> carregaPartidas(File file) {
        ArrayList<Match> p = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            p = (ArrayList<Match>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException ex) {
            System.out.println("Problema no fluxo de entrada");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problema ao criar o objeto pessoa");
        }

        return p;
    }

    public static void saveArrayMonsters(File file, ArrayList<Monster> monsters) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(monsters);
            fos.close();
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException ex) {
            System.out.println("Problema no fluxo de saída");
        }
    }

    public static void saveArrayTreasures(File file, ArrayList<Treasure> treasures) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(treasures);
            fos.close();
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException ex) {
           System.out.println("Problema no fluxo de saída");
        }
    }

    public static ArrayList<Monster> loadMonsters(File file) {
        ArrayList<Monster> m = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            m = (ArrayList<Monster>) ois.readObject();

            ois.close();
            fis.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException ex) {
            System.out.println("Problema no fluxo de entrada!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problema ao criar o objeto pessoa!");
        }
        return m;
    }
        

    public static ArrayList<Treasure> loadTreasures(File file) {
        ArrayList<Treasure> t = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            t = (ArrayList<Treasure>) ois.readObject();

            ois.close();
            fis.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException ex) {
            System.out.println("Problema no fluxo de entrada!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problema ao criar o objeto pessoa!");
        }
        return t;
    }

}

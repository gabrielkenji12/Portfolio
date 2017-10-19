/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula10;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author BadJapa
 */
public class TestMain {

    public static void main(String[] args) {
       
        ATM a = new ATM ("entradaBanks.txt");
        Bank b = new Bank ("entrada4.txt");
        Bank b1 = new Bank (55, "banco");
        ATM a1 = new ATM(b1, 0.1);
     
        System.out.println(b.find(100));
        System.out.println(a.find(11));
        
    }
}

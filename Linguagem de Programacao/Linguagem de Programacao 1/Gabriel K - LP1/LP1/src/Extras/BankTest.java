/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extras;

import Aula08.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 41528387
 */
public class BankTest {
 public static void main(String[] args) throws IOException {
        Bank b = new Bank("entrada3.txt");
       
        System.out.println("Salto Total:" + b.getTotalBalance()); 
        System.out.println("Busca: " + b.find(100));
        System.out.println(b.SavingsAccounts());
        System.out.println(b.accounts());
        
        BankAccount b1 = new BankAccount (125,"147895","Daniel",1000.0);
        b.changeAccount(b.find(111),b1);
        System.out.println(b.find(111));
        System.out.println(b.find(125));
        
        Bank b2 = new Bank("entrada3.1.txt");
        b.importAccounts(b2);
        
        System.out.println(b.toString());
        
        ArrayList <BankAccount> test = b.sort();
        System.out.println("");
        System.out.println(test.toString());
        
    }
    
}

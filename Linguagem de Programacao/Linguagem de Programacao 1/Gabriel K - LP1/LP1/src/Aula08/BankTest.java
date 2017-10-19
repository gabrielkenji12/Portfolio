/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula08;

import java.io.IOException;

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
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula07;

import java.io.IOException;

/**
 *
 * @author BadJapa
 */
public class bankArrayTest {
    
    public static void main(String[] args) throws IOException {
        Bank b = new Bank();
        b.addAccount(new BankAccount (100,"123","Gabriel Kenji", 1500.0));
        b.addAccount(new BankAccount(112,"456","Carreta Furacão", 830.0));
        b.dump();
        System.out.println("Salto Total:" + b.getTotalBalance()); 
        System.out.println("Busca: " + b.find(100));
        System.out.println("Busca: " + b.find(90));
        
        
    }
    
}

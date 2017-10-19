/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula09;

/**
 *
 * @author BadJapa
 */
public class TestMain {

    public static void main(String[] args) {
        Bank b = new Bank ("entrada4.txt");
        System.out.println("Busca: " + b.find(100));
        System.out.println(b.getAccountType(b.find(160)));
        System.out.println(b.regularAccounts());
        System.out.println(b.SavingsAccounts());
        System.out.println(b.lawAccounts());
        
        
    }
}

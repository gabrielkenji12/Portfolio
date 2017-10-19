/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula06;

import java.io.BufferedReader;

import java.io.FileReader;

/**
 *
 * @author 41528387
 */
public class Bank {
    
    private BankAccount accounts [];
    private int last;
    
    public Bank(){
        accounts = new BankAccount[100];
        last = 0;
    }
    
    public Bank(String file){
        last = 0;
        try {
            BufferedReader r = new BufferedReader(new FileReader(file));
            
            if (r != null) {
                String linha = r.readLine();
                int q = Integer.parseInt(linha); // quebra a linha e transforma em inteiro
                
                for (int i = 0; i < q; i++) {
                    linha = r.readLine();
                
                    String contas [] = linha.split("#");  
                    int accountNumber = Integer.parseInt(contas[0]);
                    String password = contas[1];
                    String owner = contas[2];
                    double balance = Double.parseDouble(contas[3]);
                    accounts[last] = new BankAccount(accountNumber, password, owner, balance);
                    last++;
                }
            
                
                r.close();
            }

        } catch (Exception e) {
            System.exit(-1);
        }
    }
    
    public void addAcccount (BankAccount a){
        if(last <= 99){
            accounts[last] =  a;
            last++;
        }
    }
    
    public double getTotalBalance(){
        double soma = 0.0;
        for(int i=0; i< last; i++){
            soma = soma + accounts[i].getBalance();    
        }
        return soma;
    }
    
    public BankAccount find (int accountNumber){
        for(int i=0; i < last; i++){
            if(accounts[i].getAccountNumber() == accountNumber){
                return accounts[i]; // achou na posição i
            }
        }
        return null; // não achou
    }
    
    
}

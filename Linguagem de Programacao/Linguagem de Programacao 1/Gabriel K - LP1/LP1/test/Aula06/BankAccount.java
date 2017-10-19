/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula06;

/**
 *
 * @author 41528387
 */
public class BankAccount {
    
    double balance;
    String owner;
    
    
    public BankAccount (double balance){
        this.balance = balance;
        
    }
    
    public BankAccount (double balance, String owner){
        this.balance = balance;
        this.owner = owner;
        
    }
    
    public double getBalance() {

        // Consulta o saldo da conta bancária
        return balance;

    }
    
    public String getOwner() {

        // Consulta o saldo da conta bancária
        return owner;

    }
    
    public void deposit(double amount) {

        // Deposita valor na conta bancária
        double newBalance = balance + amount;

        balance = newBalance;

    }
    
    public void withDraw(double amount) {

        // Deposita valor na conta bancária
        double newBalance = balance - amount;

        balance = newBalance;

    }

   
    
}

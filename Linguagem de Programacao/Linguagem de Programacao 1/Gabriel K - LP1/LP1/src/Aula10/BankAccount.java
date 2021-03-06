/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula10;

import Aula09.*;
import Aula08.*;

/**
 *
 * @author 41528387
 */
public abstract class BankAccount {

    protected int accountNumber;
    protected String password;
    protected String owner;
    protected double balance;
   
    
    public BankAccount(int accountNumber, String password, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.owner = owner;
        this.balance = balance;
        
    }
    

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getOwner() {
        return owner;
    }

    public abstract double getBalance();

    @Override
    public String toString() {
        return "BankAccount{" + "accountNumber=" + accountNumber + ", password=" + password + ", owner=" + owner + ", balance=" + balance + '}';
    }

    public void deposit(double amount) {

        double newBalance = balance + amount;
        balance = newBalance;

    }

    public void withDraw(double amount) {
        
        double newBalance = balance - amount;
        balance = newBalance;

    }

}

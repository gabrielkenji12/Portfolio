/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extras;

import Aula08.*;

/**
 *
 * @author 41528387
 */
public class SavingsAccount extends BankAccount{
    private double interestRate;
    
    public SavingsAccount (int accountNumber, String password, String owner, double balance, double interestRate){
        super(accountNumber, password, owner, balance);
        this.interestRate = interestRate;
    }
    
    @Override
    public double getBalance(){
        return super.getBalance()*(1+interestRate);
    }

    @Override
    public String toString() {
        return "SavingsAccount{ accountNumber=" + accountNumber + ", password=" + password + ", owner=" + owner + ", balance=" + balance +  "interestRate=" + interestRate + '}';
    }
    
    
    
    
}

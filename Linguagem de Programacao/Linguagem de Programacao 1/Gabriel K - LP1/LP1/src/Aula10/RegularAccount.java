/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula10;

import Aula09.*;

/**
 *
 * @author 41528387
 */
public class RegularAccount extends BankAccount {

    private double specialBalance;

    public RegularAccount(int accountNumber, String password, String owner, double balance, double specialBalance) {
        super(accountNumber, password, owner, balance);
        this.specialBalance = specialBalance;
    }

   
    public double getBalance() {
        return balance + specialBalance;
    }

    @Override
    public String toString() {
       return "RegularAccount{" + "accountNumber=" + accountNumber + ", password=" + password + ", owner=" + owner + ", balance=" + balance + ", specialBalance=" + specialBalance +'}';
    }
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula09;

import java.util.Date;

/**
 *
 * @author 41528387
 */
public abstract class LawAccount extends BankAccount{
    protected String aim;
    protected Date start;
    protected Date end;
    protected double admFee;

    public LawAccount(int accountNumber, String password, String owner, double balance,String aim, Date start, Date end, double admFee ) {
        super(accountNumber, password, owner, balance);
        this.aim = aim;
        this.start = start;
        this.end = end;
        this.admFee = admFee;
    }

    public String getAim() {
        return aim;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public double getAdmFee() {
        return admFee;
    }
    
  
    public double getBalance(){
        return balance*(1-admFee/100);
    }

    @Override
    public String toString() {
        return "LawAccount{" + "accountNumber=" + accountNumber + ", password=" + password + ", owner=" + owner + ", balance=" + balance  + "aim=" + aim + ", start=" + start + ", end=" + end + ", admFee=" + admFee + '}';
    }
    
    
    
}

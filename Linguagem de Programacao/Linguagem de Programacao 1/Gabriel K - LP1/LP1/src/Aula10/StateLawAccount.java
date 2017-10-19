/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula10;

import Aula09.*;
import java.util.Date;

/**
 *
 * @author 41528387
 */
public class StateLawAccount extends LawAccount{
    private String State;

    public StateLawAccount(int accountNumber, String password, String owner, double balance, String aim, Date start, Date end, double admFee,String State) {
        super(accountNumber, password, owner, balance, aim, start, end, admFee);
        this.State = State;
    }

    @Override
    public String toString() {
        return "StateLawAccount{" + "accountNumber=" + accountNumber + ", password=" + password + ", owner=" + owner + ", balance=" + balance  + "aim=" + aim + ", start=" + start + ", end=" + end + ", admFee=" + admFee+ "State=" + State + '}';
    }
    
    
    
}

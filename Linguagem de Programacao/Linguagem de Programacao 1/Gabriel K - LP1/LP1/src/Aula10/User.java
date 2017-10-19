/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula10;

/**
 *
 * @author 41528387
 */
public class User {
    
    public static void doOperation (BankAccountOperation bao, byte type, int accountNumber, int bankNumber){
        if(type == 0){
            bao.getBalance(accountNumber, bankNumber);
        }else{
            throw new IllegalArgumentException("Operação Inválida");
        }
    }


    public static void doOperation (BankAccountOperation bao, byte type, int accountNumber, int bankNumber, double value){
        if(type == 1){
            bao.deposit(accountNumber, value, bankNumber);
        }
        if(type == 2){
            bao.withdraw(accountNumber, value, bankNumber);
        }
        else{
            throw new IllegalArgumentException("Operação Inválida");
        }
    }
    
    
    
    
}

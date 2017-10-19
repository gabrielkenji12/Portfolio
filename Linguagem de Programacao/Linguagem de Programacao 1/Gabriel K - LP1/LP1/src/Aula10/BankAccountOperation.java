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
public interface BankAccountOperation {
    
    public double getBalance (int accountNumber, int bankNumber);
    public void deposit (int accountNumber, double value, int bankNumber);
    public void withdraw (int accountNumber, double value, int bankNumber);
}

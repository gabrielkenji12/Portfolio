/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula06;


import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41528387
 */
public class BankAccountTest {
    
   @Test
   public void construtorTest(){
       BankAccount conta = new BankAccount(500.0);
       Assert.assertEquals(500.0, conta.getBalance(), 0.01);
   }
   
   @Test
   public void depositTest(){
       BankAccount conta = new BankAccount(500.0);
       conta.deposit(300.0);
       Assert.assertEquals(800.0, conta.getBalance(), 0.01);
   }
   
   @Test
   public void withDrawTest(){
       double saldoInicial = Math.random()*1_000_000;
       BankAccount conta = new BankAccount(saldoInicial);
       double saque = Math.random()*1_000_000;
       conta.withDraw(saque);
       double saldoEsperado = saldoInicial - saque;
       double saldoObtido = conta.getBalance();
       Assert.assertEquals(saldoEsperado, saldoObtido,0.01);
   }
   
   @Test
   public void construtorTest2(){
       BankAccount conta = new BankAccount(500.0, "Jose");
       Assert.assertEquals("Jose", conta.getOwner());
   }
}

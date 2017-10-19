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
public class BankTestMain {
    
    public static void main(String[] args) {
        Bank b = new Bank();
        b.addAcccount(new BankAccount(100,"123","Gabriel Kenji", 1500.0));
        b.addAcccount(new BankAccount(112,"456","Carreta Furacão", 830.0));
        System.out.println("Salto Total:" + b.getTotalBalance());  
        System.out.println("Busca: " + b.find(100));
        System.out.println("Busca: " + b.find(90));
            int numConta = 112;
            BankAccount conta = b.find(numConta);
            if(conta != null){
                System.out.println("Dono da conta 112: " + conta.getOwner());
            }
            else{
                System.out.println("Não existe essa conta" + numConta);
            }
        
    }
}

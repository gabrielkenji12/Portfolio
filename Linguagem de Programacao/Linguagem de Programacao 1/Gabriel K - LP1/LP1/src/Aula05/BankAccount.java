/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula05;

/**
 *
 * @author BadJapa
 */
public class BankAccount {

    private int accountNumber;  // número da conta

    private static int lastAccountNumber = 1000;  // Último número utilizado de conta

    private double balance ;     // saldo da conta
    
    private String owner;     // Nome do dono da conta
    
    private double initialBalance;     // Saldo Inicial da conta
    
    private String password;  // Senha da conta com 7 caracteres

    public BankAccount(String owner) {

        // Constrói uma conta bancaria com saldo zero
        this.owner = owner;
        accountNumber = lastAccountNumber++;
        balance = 0;

    }

    public BankAccount(String owner, double initialBalance) {

        // Constrói uma conta bancária com um determinado saldo inicial
        this.owner = owner;
        this.initialBalance = initialBalance;
        this.balance += initialBalance;
        accountNumber = lastAccountNumber++;

    }

    public void deposit(double amount) {

        // Deposita valor na conta bancária
        double newBalance = balance + amount;

        balance = newBalance;

    }

    public void withDraw(double amount) {

        // Retira valor da conta bancária
        double newBalance = balance - amount;

        balance = newBalance;

    }

    public double getBalance() {

        // Consulta o saldo da conta bancária
        return balance;

    }

    public int getAccountNumber() {

        // Consulta o número da conta bancária
        return accountNumber;

    }
    
    public String getOwner() {
        
        return owner;
    }
    
    public void setPassword(){
        String [] letras = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String [] numeros = {"0","1","2","3","4","5","6","7","8","9"};
        String password = "";
        for(int i=0; i<3;i++ ){
            int j = (int) (Math.random()*letras.length);
            password += letras[j];
        }
        for(int k=0; k<4; k++){
            int s = (int) (Math.random()*numeros.length);
            password += numeros[s];
        }
        this.password = password;
        
    }
    
    public String getPassword(){
        return password;
    }

    public String toString() {
        return "Conta de " + owner + " - Numero da conta:" + accountNumber + " - Saldo de R$ " + balance;
    }
    
    public void checkName(){
        boolean check = owner.matches("[a-zA-Z]+");
        if (check == false) {
            System.out.println("Nome Inválido");
            System.exit(0);
        }
    }
    
}

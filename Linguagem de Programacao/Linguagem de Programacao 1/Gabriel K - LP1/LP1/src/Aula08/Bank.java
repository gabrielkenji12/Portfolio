/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula08;

import Aula08.BankAccount;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 41528387
 */
public class Bank {

    /**
     *
     * @author 41528387
     */
    private ArrayList<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList();

    }

    public Bank(String filename) {
        accounts = new ArrayList();

        try {
            BufferedReader r = new BufferedReader(new FileReader(filename));

            if (r != null) {
                String linha = r.readLine();
                int q = Integer.parseInt(linha);
                String linhas[] = new String[q];
                for (int i = 0; i < q; i++) {
                    linha = r.readLine();
                    linhas = linha.split("#");
                    if (linhas.length == 4) {
                        int accountNumber = Integer.parseInt(linhas[0]);
                        double balance = Double.parseDouble(linhas[3]);
                        accounts.add(new BankAccount(accountNumber, linhas[1], linhas[2], balance));
                    } else {
                        int accountNumber = Integer.parseInt(linhas[0]);
                        double balance = Double.parseDouble(linhas[3]);
                        double interestRate = Double.parseDouble(linhas[4]);
                        BankAccount a = new SavingsAccount(accountNumber, linhas[1], linhas[2], balance, interestRate);
                        accounts.add(a);
                    }
                }
                r.close();
            }
        } catch (Exception e) {
            System.exit(-1);
        }
    }

    public void dump() throws IOException {
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter("saida2.txt"));

            if (w != null) {
                for (int i = 0; i < accounts.size(); i++) {
                    String numeroConta = "Conta Número: ";
                    String senha = "Senha: ";
                    String prop = "Proprietário: ";
                    String saldo = "Saldo: ";
                    w.write(numeroConta + accounts.get(i).getAccountNumber());
                    w.newLine();
                    w.write(senha + accounts.get(i).getPassword());
                    w.newLine();
                    w.write(prop + accounts.get(i).getOwner());
                    w.newLine();
                    w.write(saldo + accounts.get(i).getBalance());
                    w.newLine();
                    w.newLine();
                }
                w.flush();// força escrita final de dados no arquivo de saída
                w.close();
            }
        } catch (Exception e) {
            System.exit(-1);
        }
    }

    public void addAccount(BankAccount a) {
        accounts.add(a);
    }

    public double getTotalBalance() {
        double soma = 0.0;
        for (int i = 0; i < accounts.size(); i++) {
            soma = soma + accounts.get(i).getBalance();
        }
        return soma;
    }

    public BankAccount find(int accountNumber) {
        int ini = 0;
        int fim = accounts.size() - 1;
        while (ini <= fim) {
            int meio = (ini + fim) / 2;
            if (accounts.get(meio).getAccountNumber() == accountNumber) {
                return accounts.get(meio); //Achou
            }
            if (accountNumber < accounts.get(meio).getAccountNumber()) {
                fim = meio - 1;
            } else {
                ini = meio + 1;
            }
        }
        return null; // Não achou

    }

    public void selectionSort() {
        int j, i, min;
        for (i = 0; i < accounts.size() - 1; i++) {
            min = i;
            for (j = i + 1; j < accounts.size(); j++) {
                if (accounts.get(j).getBalance() < accounts.get(min).getBalance()) {
                    min = j;
                }
            }
            BankAccount aux = (BankAccount) accounts.get(min);
            accounts.set(min, accounts.get(i));
            accounts.set(i, aux);
        }
    }
    
    public ArrayList<BankAccount> accounts(){
        ArrayList <BankAccount> bankAccounts = new ArrayList(); 
        for(BankAccount a: accounts){
            if(!(a instanceof SavingsAccount)){
                bankAccounts.add(a);
            }
        } return bankAccounts;
    }
    
    public ArrayList<SavingsAccount> SavingsAccounts(){
        ArrayList <SavingsAccount> savings = new ArrayList(); 
        for(BankAccount b: accounts){
            if(b instanceof SavingsAccount){
                savings.add((SavingsAccount)b);
            }
        }
        return savings;
    }

}

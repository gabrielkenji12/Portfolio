/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 41528387
 */
public class ATM implements BankAccountOperation, Comparable {

    private List<Bank> banks;
    private Bank b;
    private double fee;

    public ATM(Bank b, double fee) {

        banks = new ArrayList();
        this.b = b;
        this.fee = fee;
    }

    @Override
    public double getBalance(int accountNumber, int bankNumber) {
        Bank c = find(bankNumber);
        if (c == null) {
            throw new IllegalArgumentException("Banco não existe");
        }
        BankAccount a = c.findSort(accountNumber);
        if (a == null) {
            throw new IllegalArgumentException("Conta não existe");
        }
        return a.getBalance();
    }

    @Override
    public void deposit(int accountNumber, double value, int bankNumber) {
        Bank c = find(bankNumber);
        if (c == null) {
            throw new IllegalArgumentException("Banco não existe");
        }
        BankAccount a = c.findSort(accountNumber);
        if (a == null) {
            throw new IllegalArgumentException("Conta não existe");
        }
        a.deposit(value);
    }

    @Override
    public void withdraw(int accountNumber, double value, int bankNumber) {
        Bank c = find(bankNumber);
        if (c == null) {
            throw new IllegalArgumentException("Banco não existe");
        }
        BankAccount a = c.findSort(accountNumber);
        if (a == null) {
            throw new IllegalArgumentException("Conta não existe");
        }
        a.withDraw(value);
    }

    public Bank find(int bankNumber) {
        for (Bank a : banks) {
            if (a.getBankNumber() == bankNumber) {
                return a;
            }
        }
        return null;
    }

    public ATM(String filename) {
        banks = new ArrayList();
        try {
            BufferedReader r = new BufferedReader(new FileReader(filename));

            if (r != null) {
                String linha = r.readLine();
                int q = Integer.parseInt(linha);
                String linhas[] = new String[4];

                for (int i = 0; i < q; i++) {
                    linha = r.readLine();
                    linhas = linha.split("#");
                    int bankNumber = Integer.parseInt(linhas[0]);
                    Bank a = new Bank(bankNumber, linhas[1]);
                    banks.add(a);
                }

            }
        } catch (Exception e) {
            System.exit(-1);
        }
    }

    @Override
    public int compareTo(Object o) {
        if (this.b.getTotalBalance() > ((Bank) o).getTotalBalance()) {
            return 1;
        }
        if (this.b.getTotalBalance() == ((Bank) o).getTotalBalance()) {
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "ATM{" + "banks=" + banks + ", b=" + b + ", fee=" + fee + '}';
    }
    
    

}

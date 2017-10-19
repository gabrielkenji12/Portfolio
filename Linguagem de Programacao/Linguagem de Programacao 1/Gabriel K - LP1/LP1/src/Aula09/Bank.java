/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula09;

import Aula08.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
                String linhas[] = new String[12];
                SimpleDateFormat formatador = new SimpleDateFormat("dd/mm/yyyy");

                for (int i = 0; i < q; i++) {
                    linha = r.readLine();
                    linhas = linha.split("#");
                    if (linhas[0].equals("RA")) {
                        int accountNumber = Integer.parseInt(linhas[1]);
                        double balance = Double.parseDouble(linhas[4]);
                        double specialBalance = Double.parseDouble(linhas[5]);
                        BankAccount a = new RegularAccount(accountNumber, linhas[2], linhas[3], balance, specialBalance);
                        accounts.add(a);
                    }
                    if (linhas[0].equals("SA")) {
                        int accountNumber = Integer.parseInt(linhas[1]);
                        double balance = Double.parseDouble(linhas[4]);
                        double interestRate = Double.parseDouble(linhas[5]);
                        BankAccount a = new SavingsAccount(accountNumber, linhas[2], linhas[3], balance, interestRate);
                        accounts.add(a);
                    }
                    if (linhas[0].equals("CLA")) {
                        int accountNumber = Integer.parseInt(linhas[1]);
                        double balance = Double.parseDouble(linhas[4]);
                        Date start = formatador.parse(linhas[6]);
                        Date end = formatador.parse(linhas[7]);
                        double admFee = Double.parseDouble(linhas[8]);
                        BankAccount a = new CityLawAccount(accountNumber, linhas[2], linhas[3], balance, linhas[5], start, end, admFee, linhas[9]);
                        accounts.add(a);
                    }
                    if (linhas[0].equals("SLA")) {
                        int accountNumber = Integer.parseInt(linhas[1]);
                        double balance = Double.parseDouble(linhas[4]);
                        Date start = formatador.parse(linhas[6]);
                        Date end = formatador.parse(linhas[7]);
                        double admFee = Double.parseDouble(linhas[8]);
                        BankAccount a = new StateLawAccount(accountNumber, linhas[2], linhas[3], balance, linhas[5], start, end, admFee, linhas[9]);
                        accounts.add(a);
                    }
                    if (linhas[0].equals("FLA")) {
                        int accountNumber = Integer.parseInt(linhas[1]);
                        double balance = Double.parseDouble(linhas[4]);
                        Date start = formatador.parse(linhas[6]);
                        Date end = formatador.parse(linhas[7]);
                        double admFee = Double.parseDouble(linhas[8]);
                        BankAccount a = new FederationLawAccount(accountNumber, linhas[2], linhas[3], balance, linhas[5], start, end, admFee, linhas[9]);
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

    public ArrayList<RegularAccount> regularAccounts() {
        ArrayList<RegularAccount> regular = new ArrayList();
        for (BankAccount a : accounts) {
            if (a instanceof RegularAccount) {
                regular.add((RegularAccount) a);
            }

            int j, i, max;
            for (i = regular.size() - 1; i >= 0; i--) {
                max = i;
                for (j = i - 1; j >= 0; j--) {
                    if (regular.get(j).getBalance() < regular.get(max).getBalance()) {
                        max = j;
                    }
                }
                RegularAccount aux = regular.get(max);
                regular.set(max, regular.get(i));
                regular.set(i, aux);
            }

        }
        return regular;
    }

    public ArrayList<SavingsAccount> SavingsAccounts() {
        ArrayList<SavingsAccount> savings = new ArrayList();
        for (BankAccount b : accounts) {
            if (b instanceof SavingsAccount) {
                savings.add((SavingsAccount) b);
            }

            int j, i, max;
            for (i = savings.size() - 1; i >= 0; i--) {
                max = i;
                for (j = i - 1; j >= 0; j--) {
                    if (savings.get(j).getBalance() < savings.get(max).getBalance()) {
                        max = j;
                    }
                }
                SavingsAccount aux = savings.get(max);
                savings.set(max, savings.get(i));
                savings.set(i, aux);
            }
        }
        return savings;
    }

    public ArrayList<LawAccount> lawAccounts() {
        ArrayList<LawAccount> laws = new ArrayList();
        ArrayList<CityLawAccount> cla = new ArrayList();
        ArrayList<StateLawAccount> sla = new ArrayList();
        ArrayList<FederationLawAccount> fla = new ArrayList();
        for (BankAccount c : accounts) {
            if (c instanceof CityLawAccount) {
                cla.add((CityLawAccount) c);
            }
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

        for (BankAccount c : accounts) {
            if (c instanceof StateLawAccount) {
                sla.add((StateLawAccount) c);
            }
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

        for (BankAccount c : accounts) {
            if (c instanceof FederationLawAccount) {
                fla.add((FederationLawAccount) c);
            }
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

        for (CityLawAccount a : cla) {
            laws.add(a);
        }
        for (StateLawAccount a : sla) {
            laws.add(a);
        }
        for (FederationLawAccount a : fla) {
            laws.add(a);
        }

        return laws;

    }

    public String getAccountType(BankAccount b) {
        if (b instanceof RegularAccount) {
            return "RA";
        }
        if (b instanceof SavingsAccount) {
            return "SA";
        }
        if (b instanceof CityLawAccount) {
            return "CLA";
        }
        if (b instanceof StateLawAccount) {
            return "SLA";
        }
        if (b instanceof FederationLawAccount) {
            return "FLA";
        }
        return null;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula03;

import java.util.Scanner;

/**
 *
 * @author BadJapa
 */
public class ContaBancaria {

    public static Scanner entrada;

    public static void sacar(int[][] saldos, int valor, int cliente, int tipoConta) {
        saldos[cliente][tipoConta] -= valor;
    }

    public static void depositar(int[][] saldos, int valor, int cliente, int tipoConta) {
        saldos[cliente][tipoConta] += valor;
    }

    public static void transferir(int[][] saldos, int valor, int clienteOrigem, int tipoContaOrigem, int clienteDestino, int tipoContaDestino) {
        saldos[clienteOrigem][tipoContaOrigem] -= valor;
        saldos[clienteDestino][tipoContaDestino] += valor;
    }

    public static void mostrarSaldos(String[] nomes, int[][] saldos) {
        System.out.println("Saldos de todos os clientes:");
        for (int i = 0; i < nomes.length; i++) {
            String msg = i + ") " + nomes[i] + ": ";
            msg += saldos[i][0] + " (conta corrente) e ";
            msg += saldos[i][1] + " (poupança)";
            System.out.println(msg);
        }
        System.out.println();
    }

    public static void interacaoSacar(int[][] saldos) {
        boolean clienteValido = false;
        int cliente = -1;
        while (!clienteValido) {
            System.out.print("O saque será efetuado na conta de qual cliente? (0 a "
                    + (saldos.length - 1) + "): ");
            cliente = entrada.nextInt();
            if (cliente >= 0 && cliente < saldos.length) {
                clienteValido = true;
            } else {
                System.out.println("Índice de cliente inválido!");
            }
        }
        boolean contaValida = false;
        int tipoConta = -1;
        while (!contaValida) {
            System.out.print("Em qual conta será efetuado o saque? "
                    + "(0 - conta corrente; 1 - poupança): ");
            tipoConta = entrada.nextInt();
            if (tipoConta == 0 || tipoConta == 1) {
                contaValida = true;
            } else {
                System.out.println("Valor inválido!");
            }
        }
        System.out.print("Qual o valor do saque? ");
        int saque = entrada.nextInt();
        sacar(saldos, saque, cliente, tipoConta);
    }

    public static void interacaoDepositar(int[][] saldos) {
        boolean clienteValido = false;
        int cliente = -1;
        while (!clienteValido) {
            System.out.print("O deposito será efetuado na conta de qual cliente? (0 a "
                    + (saldos.length - 1) + "): ");
            cliente = entrada.nextInt();
            if (cliente >= 0 && cliente < saldos.length) {
                clienteValido = true;
            } else {
                System.out.println("Índice de cliente inválido!");
            }
        }
        boolean contaValida = false;
        int tipoConta = -1;
        while (!contaValida) {
            System.out.print("Em qual conta será efetuado o deposito? "
                    + "(0 - conta corrente; 1 - poupança): ");
            tipoConta = entrada.nextInt();
            if (tipoConta == 0 || tipoConta == 1) {
                contaValida = true;
            } else {
                System.out.println("Valor inválido!");
            }
        }
        System.out.print("Qual o valor do deposito? ");
        int deposito = entrada.nextInt();
        depositar(saldos, deposito, cliente, tipoConta);
    }

    public static void interacaoTransferir(int[][] saldos) {
        boolean clienteValido = false;
        int clienteOrigem = -1;
        while (!clienteValido) {
            System.out.print("A Transferência será efetuado na conta de qual cliente? (0 a "
                    + (saldos.length - 1) + "): ");
            clienteOrigem = entrada.nextInt();
            if (clienteOrigem >= 0 && clienteOrigem < saldos.length) {
                clienteValido = true;
            } else {
                System.out.println("Índice de cliente inválido!");
            }
        }
        boolean contaValida = false;
        int tipoContaOrigem = -1;
        while (!contaValida) {
            System.out.print("Em qual conta será efetuado a Transferência? "
                    + "(0 - conta corrente; 1 - poupança): ");
            tipoContaOrigem = entrada.nextInt();
            if (tipoContaOrigem == 0 || tipoContaOrigem == 1) {
                contaValida = true;
            } else {
                System.out.println("Valor inválido!");
            }
        }
        boolean clienteValido2 = false;
        int clienteDestino = -1;
        while (!clienteValido2) {
            System.out.print("A Transferência será depositada na conta de qual cliente? (0 a "
                    + (saldos.length - 1) + "): ");
            clienteDestino = entrada.nextInt();
            if (clienteDestino >= 0 && clienteDestino < saldos.length) {
                clienteValido2 = true;
            } else {
                System.out.println("Índice de cliente inválido!");
            }
        }
        boolean contaValida2 = false;
        int tipoContaDestino = -1;
        while (!contaValida2) {
            System.out.print("Em qual conta será depositada a Transferência? "
                    + "(0 - conta corrente; 1 - poupança): ");
            tipoContaDestino = entrada.nextInt();
            if (tipoContaDestino == 0 || tipoContaDestino == 1) {
                contaValida2 = true;
            } else {
                System.out.println("Valor inválido!");
            }
        }
        
        System.out.print("Qual o valor da Transferência? ");
        int transferencia = entrada.nextInt();
        transferir(saldos, transferencia, clienteOrigem, tipoContaOrigem, clienteDestino, tipoContaDestino);

    }

    public static void main(String[] args) {
        String[] nomes = {"Marcos", "Júlia", "João", "Roberto", "Janaína"};
        int[][] saldos = {{1000, 2500}, {250, 1500}, {2500, 750}, {3000, 50}, {4500, 3200}};
        entrada = new Scanner(System.in);
        boolean sair = false;
        while (!sair) {
            System.out.println("Escolha uma operação:");
            System.out.println("(1) mostrar saldos de todos os clientes");
            System.out.println("(2) sacar");
            System.out.println("(3) depositar");
            System.out.println("(4) transferir");
            System.out.println("(5) sair");
            System.out.print("Opção escolhida: ");
            int escolha = entrada.nextInt();
            System.out.println();
            switch (escolha) {
                case 1:
                    mostrarSaldos(nomes, saldos);
                    break;
                case 2:
                    interacaoSacar(saldos);
                    break;
                case 3:
                    interacaoDepositar(saldos);
                    break;
                case 4:
                    interacaoTransferir(saldos);
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println();
        }
        System.out.println("Fim do programa!");
    }

}

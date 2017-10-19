/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula04;

import java.util.Scanner;

/**
 *
 * @author BadJapa
 */
public class Atividade_09 {

    public static Scanner entrada;

    public static void mostrarSaldo(int[] saldos) {
        System.out.println("Saldo atual: R$" + saldos[0]);
        
    }

    public static void interacaoSacar(int[] saldos) {

        boolean valorValido = false;
       
        while (!valorValido) {
            System.out.print("Digite o valor a ser sacado (em R$): ");
            int saque = entrada.nextInt();
            if (saque <= saldos[0]) {
                valorValido = true;
                saldos[0] -= saque;
                System.out.println("Saque de R$" + saque + " efetuado com sucesso!");
               
            } else {
                System.out.println("Valor de saque inválido! O seu saldo atual é de R$ " + saldos);
            }
        }

    }
    
    public static void interacaoDepositar(int[] saldo){
        
        System.out.println("Digite o valor a ser depositado (em R$): ");
        int deposito = entrada.nextInt();
        saldo[0] += deposito;
        System.out.println("Depósito de R$ " + deposito + " efetuado com sucesso!");
        
    }

    public static void main(String[] args) {
        entrada = new Scanner(System.in);
        int [] saldo = new int [1];
        saldo[0] = 0;
        boolean sair = false;
        while (!sair) {
            System.out.println("Escolha uma operação:");
            System.out.println("(1) mostrar saldo");
            System.out.println("(2) sacar");
            System.out.println("(3) depositar");
            System.out.println("(4) sair");
            System.out.print("Opção escolhida: ");
            int escolha = entrada.nextInt();
            System.out.println();
            switch (escolha) {
                case 1:
                    mostrarSaldo(saldo);
                    break;
                case 2:
                    interacaoSacar(saldo);
                    break;
                case 3:
                    interacaoDepositar(saldo);
                    break;
                case 4:
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

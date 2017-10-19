/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula05;

import java.util.Scanner;

/**
 *
 * @author BadJapa
 */
public class BankAccountTest {


    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        BankAccount conta1 = new BankAccount("Jose", 1000);
        conta1.checkName();
        conta1.setPassword();
        boolean sair = false;
        while (!sair) {
            System.out.println("Escolha uma operação:");
            System.out.println("(1) Sacar R$20");
            System.out.println("(2) Depositar R$ 15");
            System.out.println("(3) Consultar o saldo");
            System.out.println("(4) Obter informações da conta (nome do correntista e número da conta)");
            System.out.println("(5) Consultar a senha gerada");
            System.out.println("(6) Sair");
            System.out.print("Opção escolhida: ");
            int escolha = entrada.nextInt();
            System.out.println();
            switch (escolha) {
                case 1:
                    conta1.withDraw(20);
                    break;
                case 2:
                    conta1.deposit(15);
                    break;
                case 3:
                    System.out.println(conta1.getBalance());
                    break;
                case 4:
                    System.out.println(conta1.toString());
                    break;
                case 5:
                    System.out.println(conta1.getPassword());
                    break;
                case 6:
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

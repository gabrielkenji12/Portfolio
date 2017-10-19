/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 41528387
 */
public class SrKrika {

    public static float[][] leEstabelecimento(String file) throws IOException {
        BufferedReader arq = new BufferedReader(new FileReader(file));
        String linha = arq.readLine();
        String linhas[] = linha.split(" ");

        int lin = Integer.parseInt(linhas[0]);
        int col = Integer.parseInt(linhas[1]);

        float Estabelecimento[][] = new float[lin][col];
        for (int i = 0; i < lin; i++) {
            linha = arq.readLine();
            linhas = linha.split(" ");
            for (int j = 0; j < col; j++) {
                Estabelecimento[i][j] = Integer.parseInt(linhas[j]);
            }
        }
        arq.close();
        return Estabelecimento;
    }

    public static int[] leQuantidades() {
        Scanner entrada = new Scanner(System.in);
        int quantidade[] = new int[3];
        int cont = 1;
        for (int i = 0; i < quantidade.length; i++) {
            System.out.println("Escreva a Quantidade desejada do produto" + cont + ": ");
            quantidade[i] = entrada.nextInt();
            cont++;
        }
        return quantidade;
    }

    public static float[] somatorioEstabelecimentos(float estabelecimentos[][], int quantidades[]) {
        float preco[] = new float[4];
        int soma = 0;
        for (int i = 0; i < preco.length; i++) {
            for (int j = 0; j < 3; j++) {
                soma = (int) (soma + quantidades[j] * estabelecimentos[j][i]);
            }
            preco[i] = soma;
            soma = 0;
        }
        return preco;
    }

    public static void printVector(float v[]) {
        for (int i = 0; i < v.length; i++) {
            System.out.print("Loja" + i + ": R$ " + v[i] + "   ");

        }
        System.out.println();
    }
    
    public static void melhorLoja(float v[]){
        float preco = v[0];
        int loja = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] < v[0]){
                preco = v[i];
                loja = i;
            }
        }
        
        System.out.println("A Loja " + loja + " é a mais barata  : R$ " + preco);
        
    }

    public static void main(String[] args) throws IOException {
        float estabelecimentos[][];
        estabelecimentos = leEstabelecimento("matriz2.txt");
        int quantidade[];
        quantidade = leQuantidades();
        float preco[] = somatorioEstabelecimentos(estabelecimentos, quantidade);
        printVector(preco);
        melhorLoja(preco);
    }

}

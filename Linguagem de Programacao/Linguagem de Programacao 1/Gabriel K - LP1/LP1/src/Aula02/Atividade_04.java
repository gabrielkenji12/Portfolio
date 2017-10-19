/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula02;

import java.util.Scanner;

/**
 *
 * @author BadJapa
 */
public class Atividade_04 {
    
    // Entrada do tamanho do vetor a ser gerado
    public static int entradaTamanhoVetor(){
        int tamanho;
        tamanho = 0;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o tamanho do vetor desejado: ");
        tamanho = entrada.nextInt();// variavel que controla  o tamanho do vetor, de acordo com o numero desejado pelo usuário
        while (tamanho < 2){
            System.out.print("Tamanho inválido, digite novamente: ");
            tamanho = entrada.nextInt();
        }
        return tamanho;
    }
    
    
    // Gera um vetor de Números Aleatorios
    public static int[] generateVector(int tamanho){
        int v [] = new int [tamanho];
        for (int i=0; i<tamanho; i++) { // variavel que controla  o tamanho do vetor, de acordo com o numero desejado pelo usuário
           v[i] = (int) (Math.random()*100);
        }
        return v;
    }
    
    
     //Mostra para o usuário o vetor criado apartir do tamanho pedido
    public static void mostraVetor(int v[], int tamanho) {
        Scanner entrada = new Scanner(System.in);
        for (int i=0; i<tamanho; i++){
            System.out.print(v[i] + " ");
        }
        
    }
    
    //Ordenação do vetor com Bubble Sort
    public static int jogo(int v[], int tamanho){
        int jogador;
        jogador =  0;
        for (int i=0; i< tamanho - 1; i++){ //repete n-1 vezes o processo
            for (int j=0; j< tamanho - 1 - i; j++){
                if(v[j] > v[j+1]){ 
                    int aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                    jogador ++; // Variaável que conta quantas vezes foi realizada a troca
                }
            }
        }
        return jogador;
    }
    
   
    
    public static void resultado(int v[], int tamanho, int jogador){
        Scanner entrada = new Scanner(System.in);
       
        if(jogador%2 == 0){
            System.out.println(" Carlos"); // Carlos será o vencedor, pois para ele ganhar o jogo tem que acabar com um número par de jogadas
        }
        else{
            System.out.println(" Marcelo"); // Marcelo será o vencedor, pois a jogada sempre começa com ele
        }
    }
    
    
   
    public static void main (String[] args){
       int tamanho, jogador;
       tamanho = entradaTamanhoVetor();
       int v[] = generateVector(tamanho);
       mostraVetor(v, tamanho);
       jogador = jogo(v, tamanho);
       resultado(v, tamanho, jogador);
       
     }
}

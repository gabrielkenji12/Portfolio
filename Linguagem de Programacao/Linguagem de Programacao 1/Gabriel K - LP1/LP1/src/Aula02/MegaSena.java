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
public class MegaSena {
    
    
    public static int entradaDados(){
        Scanner entrada = new Scanner(System.in);
        int tamanho;
        System.out.print("Escreva a quantidade de números desejados(entre 6 e 15): ");
        tamanho = entrada.nextInt();
        while ((tamanho<6) || (tamanho>15)){
            System.out.println("Quantidade Inválida, escreva a quantidade de números novamente");
            tamanho = entrada.nextInt();
        }
        return tamanho;
    }
    
    
    
    // Gera um vetor de Números Aleatorios
    public static int[] generateVector(int tamanho){
        int v [] = new int [tamanho];
        for (int i=0; i < tamanho; i++) { // variavel que controla  o tamanho do vetor, de acordo com o numero desejado pelo usuário
            v[i] = (int) (Math.random()*60+1);
            for(int j= i + 1 ;j < tamanho - 1 ;j++){// verifica se nao tem números iguais
                if(v[j]==v[i]){
                    v[j] = (int) (Math.random()*60+1);
                    j = i-1;
                }
            }
        }
        
        return v;
    }
    
    
    //Mostra para o usuário o vetor criado apartir do tamanho pedido
    public static void mostraVetor(int v[], int tamanho) {
        Scanner entrada = new Scanner(System.in);
        for (int i=0; i<tamanho; i++){
            System.out.print(v[i] + " ");
        }
        System.out.println(" ");
    }
    
    
    
    public static void main (String[] args){
       int tamanho;
       tamanho = entradaDados();
       int v[] = generateVector(tamanho);
       mostraVetor(v, tamanho);
      
     }
    
}

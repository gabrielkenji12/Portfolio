/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula01;

import java.util.Scanner;

/**
 *
 * @author 41528387
 */
public class Revisao {
    public static int[] generateVector(int n){
        int v[] = new int [n];
        for (int i=0; i<v.length; i++) {
            v[i] = (int) (Math.random()*50);
        }
        return v;
        
        
    }
    public static void printVector(int v[]){
        for (int i=0; i<v.length; i++){
            System.out.print(v[i] + " ");
            
        }
        System.out.println();
        
    }
    public static void printReverseVector(int v[]){
        int n=v.length-1;
        for (int i=n; i>=0; i--){
            System.out.print(v[i] + " ");
            
        }
        System.out.println();
        
    }
    public static boolean busca (int v[], int x){
        for(int i=0; i<v.length; i++){
            if(v[i]==x){
                return true; // Encontrou
            }
        }    
         return false; // Nao Encontrou
    }
   
    public static void main (String[] args){
        int qtd = 10;
        int A[] = generateVector(qtd);
        System.out.println("Exibindo o vetor");
        printVector(A);
        System.out.println("Exibindo o vetor invertido");
        printReverseVector(A);
        
        //int n = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero que deseja buscar"));
        System.out.println("Digite um número");
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();
        
        //boolean res = busca (A, n);
        if(busca (A, n)){
          System.out.println( n + " esta no vetor");  
        }
        else {
            System.out.println(n + " nao esta no vetor");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula02;

import static Aula01.Revisao.generateVector;
import static Aula01.Revisao.printVector;

/**
 *
 * @author 41528387
 */
public class VectorOperations {
    
    public static int linearSearch (int v[], int e){
        for (int i = 0; i < v.length; i++){
            if (v[i] == e){
                return i; // Achou na posição i
            }
        }
        return -1; // Não achou
    }

    
    public static void bubbleSort (int v[]){
        int n = v.length;
        for (int i=0; i< n - 1; i++){ //repete n-1 vezes o processo
            for (int j=0; j< n - 1 - i; j++){ // (-i)pois não precisa comparar com o último denovo
                if(v[j] > v[j+1]){ 
                    int aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
    }
    
    
    public static int linearSearchLast(int v[], int e){
        int pos = -1;
        for (int i = 0; i < v.length; i++){
            if (v[i] == e){
                pos = i; // Achou na posição i
             
            }
        }
        return pos; // Não achou
    } 
    
    public static int binarySearch (int v[], int e){
        int ini = 0;
        int fim = v.length-1;
        while (ini <= fim){
            int meio = (ini+fim)/2;
            if (v[meio] == e){
                return meio; //Achou
            }
            if (e < v[meio]){
                fim = meio - 1;
            }
            else {
                ini = meio +1;
            }
        }
        return -1; // Não achou
    }
    
    
     public static int binarySearchLast (int v[], int e){
        int ini = 0;
        int fim = v.length-1;
        int pos = -1;
        while (ini <= fim){
            int meio = (ini+fim)/2;
            while(v[meio] == e){
                
                pos = meio;
                meio++;
                return pos;
            }
            if (e < v[meio]){
                fim = meio - 1;
            }
            else {
                ini = meio +1;
            }
                
        }
        return pos;
    }
    
    public static void main (String[] args){
        int A[] = generateVector(10);
        System.out.println("Busca utlizando a função linearSearch: ");
        printVector(A);
        
        int res = linearSearch(A,2);
        if (res != -1){
            System.out.println("O 2 está na posição = " + res);
        }
        else{
            System.out.println("O 2 NÃO está no vetor");
        }
        
      
       
        System.out.println("Busca utlizando a função linearSearchLast: ");
        int B[] = {7,2,8,45,21,2,65,3,54,2,98,25}; // 12 posições
        printVector(B);
        int res2 = linearSearchLast(B,2);
        
        if (res2 != -1){
            System.out.println("O 2 está na posição = " + res2);
        }
        else{
            System.out.println("O 2 NÃO está no vetor");
        }
      
        System.out.println("Busca utlizando a função binarySearchLast: ");
        bubbleSort(B);
        printVector(B); 
        int res3 = binarySearchLast(B,2);
        
        if (res3 != -1){
            System.out.println("O 2 está na posição = " + res3);
        }
        else{
            System.out.println("O 2 NÃO está no vetor");
        }
    
    }   
        
    

}

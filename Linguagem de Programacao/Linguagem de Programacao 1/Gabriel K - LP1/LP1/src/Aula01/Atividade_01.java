/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula01;

import static Aula01.Revisao.busca;
import static Aula01.Revisao.generateVector;
import static Aula01.Revisao.printVector;

/**
 *
 * @author 41528387
 */
public class Atividade_01 {
    public static int [] intersection(int v[], int w[]){
        int inter[];
        int n1 = v.length;
        int n2 = w.length;
        inter = new int [n1+n2];
        int k=0; //percote o vetor int
        
        for (int i=0; i<n1; i++){
            boolean res = busca (w, v[i]);
            if (res==true){
                inter[k]=v[i];
                k++;
            }
            
        }
        return inter;
    }
    
    public static int [] union(int v[], int w[]){
        int uni[];
        int n1 = v.length;
        int n2 = w.length;
        uni = new int [n1+n2];
        int k=0; //percote o vetor int
        
        for (int i=0; i<n1; i++){
            uni[k]=v[i];
            k++;
        }    
        for (int i=0; i<n2; i++){
            boolean res = busca (w,uni[i]);
            if (res==false){
                uni[k]=v[i];
                k++;
            }
        }
        
        return uni;
    }
    
    public static void main (String[] args){
        int A1[] = generateVector(10);
        printVector(A1);
        int A2[] = generateVector(10);
        printVector(A2);
        
        int inter[] = intersection(A1,A2);
        printVector(inter);
        
        int union[] = union(A1,A2);
        printVector(union);
    }
}

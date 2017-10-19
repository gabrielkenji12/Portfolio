/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula04;

/**
 *
 * @author 41528387
 */
public class TestaPonto4 {
    
    public static void main(String[] args) {
        Ponto p1 =  new Ponto (3,1);
        Ponto p2 =  new Ponto (7,4);
        
        System.out.println(p1.distancia(p2)); //saida esperada 5.0
    }
    
}

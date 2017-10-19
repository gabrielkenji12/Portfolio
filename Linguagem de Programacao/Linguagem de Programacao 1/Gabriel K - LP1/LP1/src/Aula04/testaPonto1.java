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
public class testaPonto1 {
    public static void main(String[] args) {
        Ponto p1 = new Ponto();
        System.out.println(p1.toString()); // sem toString, mostra apenas o endereço de memoria
        
        Ponto p2 = new Ponto(3,5);
        System.out.println(p2); // nao precisa fazer a chamada do toString, pois ele ja esta no metodo
        
    }
    
}

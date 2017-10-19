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
public class TestaPonto3 {
    
    public static void main(String[] args) {
        Ponto p1 =  new Ponto (2,3);
        //Nao pode dar um system out no transladar, pq ele nao tem retorno
        p1.transladar(4,-1);
        System.out.println(p1); // saida esperada (6,2)
    }
}

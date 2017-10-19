/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula04;

/**
 *
 * @author BadJapa
 */
public class TestaRetangulo {

    public static void main(String[] args) {
        Retangulo r1 = new Retangulo(1, 1, 2, 2);
        Retangulo r2 = new Retangulo(2, 2, 2, 2);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r1.Area());
        System.out.println(r1.Perimetro());
        System.out.println(r1.Interseccao(r2));
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula02;

/**
 *
 * @author BadJapa
 */
public class teste {

    public static void desenhaPadrao(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*" + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        int n = 1;
        int x = 0;
        int i;
        while (n < 0) {
            if (n % 2 != 0) {
                for (i = 3; i * 1 <= n; i += 2) {
                    if (n % i == 0) {
                        break;
                    }
                }
            
                if (i < n) {
                x++;
                }
            }
            n++;
        }
    
    
        System.out.println (x);
   }
}



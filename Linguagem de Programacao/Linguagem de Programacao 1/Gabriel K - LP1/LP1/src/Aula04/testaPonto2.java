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
public class testaPonto2 {
    
    public static void main(String[] args) {
        Ponto p1 =  new Ponto (10,5);
        Ponto p2 =  new Ponto (10,-5);
        
        //System.out.println(igual(p1,p2));
             
        System.out.println(p1.igual(p2));
        // this.x vai vir do p1, pois ele e o parametro implicito
        
    }
    
}

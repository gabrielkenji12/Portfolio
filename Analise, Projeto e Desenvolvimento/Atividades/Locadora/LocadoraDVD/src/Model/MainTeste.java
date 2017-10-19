/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 41528387
 */
public class MainTeste {
    
    public static void main(String[] args) {
        System.out.println("-- Teste --");
        System.out.println("");
        Cliente c1 = new Cliente("Gabriel");
        
        DVD d1 = new Lançamento("Esquadrão Suicida");
        DVD d2 = new Normal("Harry Potter");
        DVD d3 = new Infantil("Meu Malvado Favorito");
        
        Aluguel a1 = new Aluguel(d3, 5);
        Aluguel a2 = new Aluguel(d1, 5);
        Aluguel a3 = new Aluguel(d2, 5);
        
        c1.adicionaAluguel(a2);
        c1.adicionaAluguel(a1);
        c1.adicionaAluguel(a3);
        System.out.println(c1.extrato());
        
    }
}

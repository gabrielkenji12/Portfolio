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
public class Lançamento extends DVD {

    public Lançamento(String título) {
        super(título);
    }

    
    public double calculaPreço(int diasAlugada) {
        double valorCorrente = 0;
        valorCorrente += diasAlugada * 3;
        return valorCorrente;
    }
    
     public int calculaPontosDeAlugadorFrequente(int diasAlugada) {
        // adiciona bonus para aluguel de um lançamen   to por pelo menos 2
        // dias
        if (diasAlugada > 1) {
            return 2;
        }
        return 1;
    }
}

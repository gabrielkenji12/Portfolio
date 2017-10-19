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
public class Infantil extends DVD {

    public Infantil(String título) {
        super(título);
    }

    
    public double calculaPreço(int diasAlugada) {
        double valorCorrente = 0.0;
        valorCorrente += 1.5;
        if (diasAlugada > 3) {
            valorCorrente += (diasAlugada - 3) * 1.5;
        }
        return valorCorrente;
    }

    
    public int calculaPontosDeAlugadorFrequente(int DiasAlugada) {
        return 1;
    }
}

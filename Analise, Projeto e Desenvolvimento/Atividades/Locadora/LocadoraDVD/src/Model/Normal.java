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
public class Normal extends DVD {

    public Normal(String título) {
        super(título);
    }

    public double calculaPreço(int diasAlugada) {
        double valorCorrente = 0;
        valorCorrente += 2;
        if (diasAlugada > 2) {
            valorCorrente += (diasAlugada - 2) * 1.5;
        }
        return valorCorrente;
    }

    public int calculaPontosDeAlugadorFrequente(int DiasAlugada) {

        return 1;
    }
}

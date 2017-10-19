/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ana
 */
public abstract class DVD {
    
    private String título;

    public DVD(String título) {
        this.título = título;
    }

    public String getTítulo() {
        return título;
    }


    public abstract double calculaPreço(int diasAlugada);

    public abstract int calculaPontosDeAlugadorFrequente(int diasAlugada);

}
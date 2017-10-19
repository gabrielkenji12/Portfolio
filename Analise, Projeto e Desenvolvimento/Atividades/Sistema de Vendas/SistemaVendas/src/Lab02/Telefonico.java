/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab02;

/**
 *
 * @author 41528387
 */
public class Telefonico extends Endereco{
    
    private int DDD;
    private String nro;
    private int tipo;

    public Telefonico(int DDD, String nro, int tipo) {
        this.DDD = DDD;
        this.nro = nro;
        this.tipo = tipo;
    }

    public Telefonico() {
    }

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Telefonico{" + "DDD=" + DDD + ", nro=" + nro + ", tipo=" + tipo + '}';
    }
    
    
}

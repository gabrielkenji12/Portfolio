/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extras;

/**
 *
 * @author 41528387
 */
public class Estudante extends Pessoa implements Motivacao{
    
    private double mediaGeral;
    private String tia;

    public Estudante() {
    }
    

    public Estudante(int anoNascimento, String nome, double mediaGeral, String tia) {
        super(anoNascimento, nome);
        this.mediaGeral = mediaGeral;
        this.tia = tia;
    }

    public double getMediaGeral() {
        return mediaGeral;
    }

    public String getTia() {
        return tia;
    }
    
    public void incentiva(double n){
        this.mediaGeral = this.mediaGeral + n;
    }

    public void setMediaGeral(double mediaGeral) {
        this.mediaGeral = mediaGeral;
    }

    public void setTia(String tia) {
        this.tia = tia;
    }

    @Override
    public String toString() {
        return "Estudante{"+ super.toString()  + ", mediaGeral=" + mediaGeral + ", tia=" + tia + '}';
    }
    
    
    
    
    
    
}

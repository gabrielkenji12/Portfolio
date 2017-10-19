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
public class Professor extends Pessoa implements Motivacao{
    private int anoContratacao;
    private String drt;
    private double reputacao;

    public Professor() {
        this.drt = "11111111";
        this.reputacao = 100.0;
    }

    public Professor(int anoNascimento, String nome, int anoContratacao, String drt, double reputacao) {
        super(anoNascimento, nome);
        this.anoContratacao = anoContratacao;
        this.drt = drt;
        this.reputacao = reputacao;
    }

    public int getAnoContratacao() {
        return anoContratacao;
    }

    public String getDrt() {
        return drt;
    }

    public double getReputacao() {
        return reputacao;
    }
    
    public void incentiva(double n){
        this.reputacao = this.reputacao + n;
    }

    public void setAnoContratacao(int anoContratacao) {
        this.anoContratacao = anoContratacao;
    }

    public void setDrt(String drt) {
        this.drt = drt;
    }

    public void setReputacao(double reputacao) {
        this.reputacao = reputacao;
    }

    @Override
    public String toString() {
        return "Professor{" + super.toString() + ", anoContratacao=" + anoContratacao + ", drt=" + drt + ", reputacao=" + reputacao + '}';
    }
    
    
    
    
}



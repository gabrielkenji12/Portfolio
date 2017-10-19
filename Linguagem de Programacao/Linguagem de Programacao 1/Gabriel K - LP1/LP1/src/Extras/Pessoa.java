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
public class Pessoa {
    
    private int anoNascimento;
    private String nome;
    
    public Pessoa (){
        this.anoNascimento = 1990;
        this.nome = "não identificado";
    }

    public Pessoa(int anoNascimento, String nome) {
        this.anoNascimento = anoNascimento;
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "anoNascimento=" + anoNascimento + ", nome=" + nome;
    }
    
    
    
    
    
}

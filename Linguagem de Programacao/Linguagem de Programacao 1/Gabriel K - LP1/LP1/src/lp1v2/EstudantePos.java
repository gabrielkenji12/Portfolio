/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp1v2;

/**
 *
 * @author BadJapa
 */
public class EstudantePos extends Estudante {

    private String tema;
    private String orientador;

    public EstudantePos(long id, String nome, String email, String tema, String orientador) {
        super(id, nome, email);
        this.tema = tema;
        this.orientador = orientador;
    }

    public String getTema() {
        return tema;
    }

    public String getOrientador() {
        return orientador;
    }

    @Override
    public int getTotalCreditos() {
        int soma = 0;
        for (Matricula a : matriculas) {
            if (a.getEstudante().id == this.id) {
                soma = soma + a.getDisciplina().getCreditos();
            }
        }
        return soma;
    }

    @Override
    public String toString() {
        return "EstudantePos{" + super.toString() + ", tema=" + tema + ", orientador=" + orientador + '}';
    }
    
    

}

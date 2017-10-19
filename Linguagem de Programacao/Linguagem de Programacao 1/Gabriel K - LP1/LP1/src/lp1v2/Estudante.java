/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp1v2;

import lp1v1.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BadJapa
 */
public abstract class Estudante {

    protected long id;
    protected String nome;
    protected String email;
    protected List<Matricula> matriculas;

    public Estudante(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matriculas = new ArrayList<Matricula>();
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }
    
    public void addMatricula(Matricula matricula){
        matriculas.add(matricula);
    }
    
    public List <Disciplina> getDisciplinasMatriculadas(){
        for(Matricula a: matriculas){
            if(a.getEstudante().id == this.id){
                return (List<Disciplina>) a.getDisciplina();
            }
        }
        return null;
    }
    
    public abstract int getTotalCreditos();

    @Override
    public String toString() {
        return "id=" + id + ", nome=" + nome + ", email=" + email ;
    }

   

}

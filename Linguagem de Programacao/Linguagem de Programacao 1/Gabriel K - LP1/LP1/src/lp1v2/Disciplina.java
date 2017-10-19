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
public class Disciplina {
    
    private String codigo;
    private int creditos;
    private List<Matricula> matriculas;
    
    public Disciplina(String codigo, int creditos){
        this.codigo = codigo;
        this.creditos = creditos;
        this.matriculas = new ArrayList<Matricula>();
    }

  
    public String getCodigo() {
        return codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }
    
    public void addMatricula(Matricula matricula){
        matriculas.add(matricula);
    }
    
    public List<Estudante> getEstudantesMatriculados(){
        for(Matricula a: matriculas){
            if(a.getDisciplina().codigo == this.codigo){
               return (List<Estudante>) a.getDisciplina();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "codigo=" + codigo + " ,credito=" + creditos + '}';
    }
    
}

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
public class EstudanteGrad extends Estudante{
    
    private int horasAtividade;

    public EstudanteGrad(long id, String nome, String email, int horasAtividade) {
        super(id, nome, email);
        this.horasAtividade = horasAtividade;
    }

    public int getHorasAtividade() {
        return horasAtividade;
    }
    
   
    @Override
    public int getTotalCreditos() {
        int soma = 0;
        for (Matricula a: matriculas){
            if(a.getEstudante().id == this.id){
                soma = soma + a.getDisciplina().getCreditos();
            }
        }
        
        return horasAtividade + soma;
    }

    @Override
    public String toString() {
        return "EstudanteGrad{" + super.toString() + ", horasAtividade=" + horasAtividade + '}';
    }
    
    
    
}

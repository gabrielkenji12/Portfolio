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
public class Extra03TestMain {
    
    public static void main(String[] args) {
        Professor p1 = new Professor(25,"Paulo",2000,"14789541",90.0);
        Professor p2 = new Professor(35,"Daniel",1990,"11551235",95.0);
        Estudante a1 = new Estudante(1995,"Gabriel",9.0,"14989541");
        Estudante a2 = new Estudante(1997,"Bruno",8.0,"19289141");
        Professor p3 = new Professor();
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        
        p1.setAnoContratacao(1999);
        p2.setDrt("11223344");
        a1.setMediaGeral(10.0);
        a2.setNome("Augusto");
        
        System.out.println();
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        
        p1.incentiva(10.0);
        p3.incentiva(5.0);
        a1.incentiva(1.0);
        a2.incentiva(5.0);
        
        System.out.println();
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println();
        System.out.println("Professor 1 drt: " + p1.getDrt());
        System.out.println("Professor 2 nome: " + p2.getNome());
        System.out.println("Professor 3 ano de nascimento: " + p3.getAnoNascimento());
        System.out.println("Aluno 1 tia: " + a1.getTia());
        System.out.println("Aluno 2 Nome: " + a2.getNome());
    }
}

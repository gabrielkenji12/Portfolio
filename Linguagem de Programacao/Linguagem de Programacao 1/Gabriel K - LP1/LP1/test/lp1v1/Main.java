/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp1v1;

/**
 *
 * @author 41528387
 */
public class Main {
    public static void main(String[] args) {
        Universidade u = new Universidade("teste");
                u.carregarDadosArquivo("disciplinas.txt", "estudantes.txt", "matriculas.txt");
                
//                System.out.println(u.getMatriculas());
    }
}

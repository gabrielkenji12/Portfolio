/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp1v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author BadJapa
 */
public class GestaoAcademicaApp2 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        boolean sair = false;
        while (!sair) {
            System.out.println("Escolha uma operação:");
            System.out.println("(1) Listar todos os estudantes");
            System.out.println("(2) Listar os Códigos de todas as disciplinas");
            System.out.println("(3) Listar as informações dos estudantes matriculados na disciplina desejada");
            System.out.println("(4) Listar as informações das disciplinas que o estudante desejado está matriculado");
            System.out.println("(5) Sair");
            System.out.print("Opção escolhida: ");
            int escolha = entrada.nextInt();
            System.out.println();

            Universidade u = new Universidade("Mackenzie");
            u.carregarDadosArquivo("disciplinas-cacccbdeeebcbacecbcc.txt", "estudantes-cacccbdeeebcbacecbcc.txt", "matriculas-cacccbdeeebcbacecbcc.txt");
            List<Estudante> est = u.getEstudantes();
            List<Disciplina> disc = u.getDisciplinas();

            switch (escolha) {
                case 1:
                    for (Estudante estudante : est) {

                        System.out.println(estudante.toString() + " Créditos: " + estudante.getTotalCreditos());
                    }
                    break;
                case 2:
                    for (Disciplina n : disc) {
                        System.out.println("Código: " + n.getCodigo());
                    }
                    break;
                case 3:
                    System.out.println("Digite o codigo da disciplina desejada: ");
                    String dis = entrada.next();
                    List<Estudante> est2 = new ArrayList();
                    for (Estudante e : est) {
                        for (Matricula m : e.getMatriculas()) {
                            if (m.getDisciplina().getCodigo().equals(dis)) {
                                est2.add(e);
                            }
                        }
                    }
                    for (Estudante e : est2) {
                        System.out.println(e.toString());
                    }
                    break;
                case 4:
                    System.out.println("Digite o codigo do estudante desejado: ");
                    long id = entrada.nextLong();
                    List<Disciplina> dis2 = new ArrayList();
                    Estudante estudante = null;
                    for (Estudante e : est) {

                        if (e.getId() == id) {
                            estudante = e;
                        }
                    }
                    for (Matricula m : estudante.getMatriculas()) {
                        dis2.add(m.getDisciplina());

                    }
                    System.out.println(dis2.toString());
                    if (estudante != null) {
                        System.out.println("Créditos do Estudante " + id + ": " + estudante.getTotalCreditos());
                    }
                    break;

                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println();
        }

        System.out.println(
                "Fim do programa!");
    }
}

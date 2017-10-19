/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp1v1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author BadJapa
 */
public class Universidade {

    private String nome;
    private List<Estudante> estudantes;
    private List<Disciplina> disciplinas;

    public Universidade(String nome) {
        this.nome = nome;
        disciplinas = new ArrayList<Disciplina>();
        estudantes = new ArrayList<Estudante>();

    }

    public void carregarDadosArquivo(String arquivoDisciplinas, String arquivoEstudantes, String arquivoMatriculas) {
        try {
            BufferedReader d = new BufferedReader(new FileReader(arquivoDisciplinas));
            BufferedReader e = new BufferedReader(new FileReader(arquivoEstudantes));
            BufferedReader m = new BufferedReader(new FileReader(arquivoMatriculas));

            if (d != null) {
                String line;
                String[] linhaDisciplina;
                while ((line = d.readLine()) != null) {
                    linhaDisciplina = line.split(":");
                    int credito = Integer.parseInt(linhaDisciplina[1]);
                    String codigo = linhaDisciplina[0];

                    disciplinas.add(new Disciplina(codigo, credito));
                }

            }

            if (e != null) {
                String line;
                String[] linhaEstudante;
                while ((line = e.readLine()) != null) {
                    linhaEstudante = line.split(":");
                    long id = Long.parseLong(linhaEstudante[0]);
                    String nome = linhaEstudante[1];
                    String email = linhaEstudante[2];
                    estudantes.add(new Estudante(id, nome, email));
                }
            }

            if (m != null) {
                String line;
                String[] linhaMatricula;
                while ((line = m.readLine()) != null) {
                    linhaMatricula = line.split(":");
                    long id = Long.parseLong(linhaMatricula[0]);
                    String codigo = linhaMatricula[1];

//                    for (Estudante a : estudantes) {
//                        if (a.getId() == id) {
//                            Estudante estudanteRef = a;
//                            for (Disciplina b : disciplinas) {
//                                if (b.getCodigo() == codigo) {
//                                    Disciplina disciplinaRef = b;
//                                    a.addMatricula(new Matricula(estudanteRef, disciplinaRef));
//                                }
//                            }
//                        }
//
//                    }
                    Estudante e1 = null;
                    for (Estudante a : estudantes) {
                        if (a.getId() == id) {
                            e1 = a;
                        }
                    }

                    Disciplina d1 = null;
                    for (Disciplina dis : disciplinas) {
                        if (dis.getCodigo().equals(codigo)) {
                            d1 = dis;
                        }
                    }
                    
                    Matricula mat = new Matricula(e1, d1);
                    
                    e1.addMatricula(mat);
                    d1.addMatricula(mat);
                }
            }
        } catch (Exception e) {

        }
    }

    public String getNome() {
        return nome;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

}

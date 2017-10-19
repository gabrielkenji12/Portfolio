/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author 41528387
 */
public class ExemploVetorArquivo {

    public static void main(String[] args) {
        try {
            BufferedReader r = new BufferedReader(new FileReader("entrada.txt"));
            BufferedWriter w = new BufferedWriter(new FileWriter("saida.txt"));
            if (r != null && w != null) {
                String linha = r.readLine();
                w.write(linha);
                w.newLine();
                int q = Integer.parseInt(linha); // quebra a linha e transforma em inteiro
                for (int i = 0; i < q; i++) {
                    linha = r.readLine();
                    w.write(linha.toUpperCase());
                    w.newLine();
                }
                r.close();
                w.flush();// força escrita final de dados no arquivo de saída
                w.close();
            }

        } catch (Exception e) {
            System.exit(-1);
        }
    }

}

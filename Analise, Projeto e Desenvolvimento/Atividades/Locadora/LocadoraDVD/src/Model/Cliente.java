/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ana
 */
import java.util.ArrayList;
import java.util.Collection;

public class Cliente {

    private String nome;
    private Collection<Aluguel> DVDsAlugados = new ArrayList<Aluguel>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionaAluguel(Aluguel aluguel) {
        DVDsAlugados.add(aluguel);
    }

    public String extrato() {
        final String fimDeLinha = System.getProperty("line.separator");
        String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
        for (Aluguel d : DVDsAlugados) {
            double valorCorrente = 0.0;
            Aluguel cada = d;
            // mostra valores para este aluguel
            resultado += "\t" + cada.getDVD().getTítulo() + "\t"
                    + cada.calculaPreço() + fimDeLinha;
            cada.calculaPreço();
        } // while
        // adiciona rodapé
        resultado += "Valor total devido: " + lerPrecoTotal() + fimDeLinha;
        resultado += "Voce acumulou " + lerTotalPontosLocadorFrequente()
                + " pontos de alugador frequente";
        return resultado;
    }

    private int lerTotalPontosLocadorFrequente() {
        int resultado = 0;
        for (Aluguel d : DVDsAlugados) {
            Aluguel cada = d;
            resultado += cada.calculaPontosDeAlugadorFrequente();
        }
        return resultado;
    }

    private double lerPrecoTotal() {
        double resultado = 0;
        for (Aluguel d : DVDsAlugados) {
            Aluguel cada = d;
            resultado += cada.calculaPreço();
        }
        return resultado;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula03;

import static Aula03.BatalhaNavalV1.CHAR_AGUA;
import static Aula03.BatalhaNavalV1.CHAR_PORTAAVIOES;
import static Aula03.BatalhaNavalV1.COLUNAS_GRID;
import static Aula03.BatalhaNavalV1.LINHAS_GRID;
import static Aula03.BatalhaNavalV1.imprimir;
import static Aula03.BatalhaNavalV1.inicializarGrid;
import static Aula03.BatalhaNavalV1.posicionarPortaAvioes;
import static Aula03.BatalhaNavalV2.CHAR_CRUZADOR;
import static Aula03.BatalhaNavalV2.CHAR_ENCOURACADO;
import static Aula03.BatalhaNavalV2.CHAR_SUBMARINO;
import static Aula03.BatalhaNavalV2.posicionarCruzador;
import static Aula03.BatalhaNavalV2.posicionarEncouracado;
import static Aula03.BatalhaNavalV2.posicionarSubmarino;
import static Aula03.BatalhaNavalV3.CHAR_TIROAGUA;
import static Aula03.BatalhaNavalV3.CHAR_TIROEMBARCACAO;
import static Aula03.BatalhaNavalV3.atirar;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Ana Cristina
 */
public class BatalhaNavalV4 {
    public static final int TOTAL_JOGADAS = 20;

    public static void main(String[] args) {
        char[][] campoBatalha;
        campoBatalha = inicializarGrid();

        int linha;
        int coluna;
        boolean vertical;

        // posiciona as embarcações
        do {
                linha = (int) (Math.random() * LINHAS_GRID);
                coluna = (int) (Math.random() * COLUNAS_GRID);
                int v = (int) (Math.random() * 2);
                if (v==0) {
                        vertical = false;
                }
                else {
                        vertical = true;
                }
        } while(!posicionarPortaAvioes(campoBatalha, linha, coluna, vertical));

        do {
                linha = (int) (Math.random() * LINHAS_GRID);
                coluna = (int) (Math.random() * COLUNAS_GRID);
                int v = (int) (Math.random() * 2);
                if (v==0) {
                        vertical = false;
                }
                else {
                        vertical = true;
                }
        } while(!posicionarEncouracado(campoBatalha, linha, coluna, vertical));

        do {
                linha = (int) (Math.random() * LINHAS_GRID);
                coluna = (int) (Math.random() * COLUNAS_GRID);
                int v = (int) (Math.random() * 2);
                if (v==0) {
                        vertical = false;
                }
                else {
                        vertical = true;
                }
        } while(!posicionarCruzador(campoBatalha, linha, coluna, vertical));

        do {
                linha = (int) (Math.random() * LINHAS_GRID);
                coluna = (int) (Math.random() * COLUNAS_GRID);
                int v = (int) (Math.random() * 2);
                if (v==0) {
                        vertical = false;
                }
                else {
                        vertical = true;
                }
        } while(!posicionarSubmarino(campoBatalha, linha, coluna, vertical));

        // permite que o usuário efetue os tiros
        Scanner entrada = new Scanner(System.in);
        int jogada = 1;
        while(jogada<=TOTAL_JOGADAS) {
                out.println("JOGADA " + jogada);
                boolean valorValido = false;
                int linhaTiro=-1;
                while (!valorValido) {
                        out.print("Entre a linha (0 a " + (LINHAS_GRID-1) + "): ");
                        linhaTiro = entrada.nextInt();
                        if (linhaTiro>=0 && linhaTiro<LINHAS_GRID) {
                                valorValido = true;
                        }
                        else {
                                out.println("Valor inválido!\n");
                        }
                }
                int colunaTiro=-1;
                valorValido = false;
                while (!valorValido) {
                        out.print("Entre a coluna (0 a " + (COLUNAS_GRID-1) + "): ");
                        colunaTiro = entrada.nextInt();
                        if (colunaTiro>=0 && colunaTiro<COLUNAS_GRID) {
                                valorValido = true;
                        }
                        else {
                                out.println("Valor inválido!\n");
                        }
                }
                char conteudo = atirar(campoBatalha, linhaTiro, colunaTiro);
                switch(conteudo) {
                case CHAR_TIROAGUA:
                case CHAR_TIROEMBARCACAO:
                        out.println("Você já havia atirado nesta coordenada! "
                                                      + "Tente novamente!");
                        break;
                case CHAR_AGUA:
                        out.println("ÁGUA!");
                        jogada++;
                        break;
                case CHAR_PORTAAVIOES:
                        out.println("Acertou um porta-aviões!");
                        jogada++;
                        break;
                case CHAR_ENCOURACADO:
                        out.println("Acertou um encouraçado!");
                        jogada++;
                        break;
                case CHAR_CRUZADOR:
                        out.println("Acertou um cruzador!");
                        jogada++;
                        break;
                case CHAR_SUBMARINO:
                        out.println("Acertou um submarino!");
                        jogada++;
                        break;
                }
                out.println();
        }

        entrada.close();

        // apresenta o grid após todos o término dos tiros
        imprimir(campoBatalha);
}	

}

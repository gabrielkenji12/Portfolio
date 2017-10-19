/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula03;

import static Aula03.BatalhaNavalV1.CHAR_AGUA;
import static Aula03.BatalhaNavalV1.COLUNAS_GRID;
import static Aula03.BatalhaNavalV1.LINHAS_GRID;
import static Aula03.BatalhaNavalV1.imprimir;
import static Aula03.BatalhaNavalV1.inicializarGrid;
import static Aula03.BatalhaNavalV1.posicionarPortaAvioes;
import static Aula03.BatalhaNavalV2.posicionarCruzador;
import static Aula03.BatalhaNavalV2.posicionarEncouracado;
import static Aula03.BatalhaNavalV2.posicionarSubmarino;

/**
 *
 * @author Ana Cristina
 */
public class BatalhaNavalV3 {
	public static final char CHAR_TIROAGUA = 'x';
	public static final char CHAR_TIROEMBARCACAO = 'X';
	
	public static char atirar(char[][] grid, int linha, int coluna) {
		char conteudo = grid[linha][coluna];
		if (conteudo != CHAR_TIROAGUA && conteudo != CHAR_TIROEMBARCACAO) {
			if (conteudo == CHAR_AGUA) {
				grid[linha][coluna] = CHAR_TIROAGUA;
			}
			else {
				grid[linha][coluna] = CHAR_TIROEMBARCACAO;
			}
		}
		
		return conteudo;
	}
	
	public static void main(String[] args) {
            char[][] campoBatalha;
            campoBatalha = inicializarGrid();

            int linha;
            int coluna;
            boolean vertical;

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

            imprimir(campoBatalha);
	}
	
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula03;

import static Aula03.BatalhaNavalV1.imprimir;
import static Aula03.BatalhaNavalV1.inicializarGrid;
import static java.lang.System.out;

/**
 *
 * @author Ana Cristina
 */
public class BatalhaNavalV2 {

	public static final int LINHAS_GRID = 10;
	public static final int COLUNAS_GRID = 10;
	public static final char CHAR_AGUA = '.';
	public static final char CHAR_PORTAAVIOES = 'P';
	public static final char CHAR_ENCOURACADO = 'E';
	public static final char CHAR_CRUZADOR = 'C';
	public static final char CHAR_SUBMARINO = 'S';
	public static final int TAM_PORTAAVIOES = 5;
	public static final int TAM_ENCOURACADO = 4;
	public static final int TAM_CRUZADOR = 3;
	public static final int TAM_SUBMARINO = 2;
	
	public static boolean posicionarPortaAvioes(char[][] grid, int linha, 
                                               int coluna, boolean vertical) {
		return posicionarEmbarcacao(grid, linha, coluna, vertical, 
                                            TAM_PORTAAVIOES, CHAR_PORTAAVIOES);
	}
	
	public static boolean posicionarEncouracado(char[][] grid, int linha, 
                                                int coluna, boolean vertical) {
		return posicionarEmbarcacao(grid, linha, coluna, vertical, 
                                             TAM_ENCOURACADO, CHAR_ENCOURACADO);
	}
	
	public static boolean posicionarCruzador(char[][] grid, int linha, 
                                                 int coluna, boolean vertical) {
		return posicionarEmbarcacao(grid, linha, coluna, vertical, 
                                                   TAM_CRUZADOR, CHAR_CRUZADOR);
	}
	
	public static boolean posicionarSubmarino(char[][] grid, int linha, 
                                                int coluna, boolean vertical) {
		return posicionarEmbarcacao(grid, linha, coluna, vertical, 
                                                 TAM_SUBMARINO, CHAR_SUBMARINO);
	}
	
	public static boolean posicionarEmbarcacao(char[][] grid, int linha,
         int coluna, boolean vertical, int tamEmbarcacao, char charEmbarcacao) {
		if (linha < 0 || coluna < 0) {
			return false;
		}
		if (vertical) {
			int ultimaLinhaOcupada = linha + tamEmbarcacao - 1;
			if (ultimaLinhaOcupada > LINHAS_GRID-1) {
				return false;
			}
			for (int i=0; i<tamEmbarcacao; i++) {
				if (grid[linha+i][coluna] != CHAR_AGUA) {
					return false;
				}
			}
			for (int i=0; i<tamEmbarcacao; i++) {
				grid[linha+i][coluna] = charEmbarcacao;
			}
		}
		else {
			int ultimaColunaOcupada = coluna + tamEmbarcacao - 1;
			if (ultimaColunaOcupada > COLUNAS_GRID-1) {
				return false;
			}
			for (int j=0; j<tamEmbarcacao; j++) {
				if (grid[linha][coluna+j] != CHAR_AGUA) {
					return false;
				}
			}
			for (int j=0; j<tamEmbarcacao; j++) {
				grid[linha][coluna+j] = charEmbarcacao;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		char[][] campoBatalha;
		campoBatalha = inicializarGrid();
		out.println(posicionarPortaAvioes(campoBatalha, 5, 5, false));
		out.println(posicionarPortaAvioes(campoBatalha, 6, 6, false));
		out.println(posicionarPortaAvioes(campoBatalha, 4, 6, true));
		out.println(posicionarEncouracado(campoBatalha, 2, 2, false));
		out.println(posicionarEncouracado(campoBatalha, 2, 8, false));
		out.println(posicionarEncouracado(campoBatalha, 0, 3, true));
		imprimir(campoBatalha);		
	}
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula03;

import static java.lang.System.out;

/**
 *
 * @author Ana Cristina
 */
public class BatalhaNavalV1 {

	public static final int LINHAS_GRID = 10;
	public static final int COLUNAS_GRID = 10;
	public static final char CHAR_AGUA = '.';
	public static final char CHAR_PORTAAVIOES = 'P';
	public static final int TAM_PORTAAVIOES = 5;
	
	public static char[][] inicializarGrid() {
		char[][] grid = new char[LINHAS_GRID][COLUNAS_GRID];
		for (int lin=0; lin<LINHAS_GRID; lin++) {
			for (int col=0; col<COLUNAS_GRID; col++) {
				grid[lin][col] = CHAR_AGUA;
			}
		}
		return grid;
	}
	
	public static boolean posicionarPortaAvioes(char[][] grid, int linha, 
                                                int coluna, boolean vertical) {
		if (linha < 0 || coluna < 0) {
			return false;
		}
		if (vertical) {
			int ultimaLinhaOcupada = linha + TAM_PORTAAVIOES - 1;
			if (ultimaLinhaOcupada > LINHAS_GRID-1) {
				return false;
			}
			for (int i=0; i<TAM_PORTAAVIOES; i++) {
				if (grid[linha+i][coluna] != CHAR_AGUA) {
					return false;
				}
			}
			for (int i=0; i<TAM_PORTAAVIOES; i++) {
				grid[linha+i][coluna] = CHAR_PORTAAVIOES;
			}
		}
		else {
			int ultimaColunaOcupada = coluna + TAM_PORTAAVIOES - 1;
			if (ultimaColunaOcupada > COLUNAS_GRID-1) {
				return false;
			}
			for (int j=0; j<TAM_PORTAAVIOES; j++) {
				if (grid[linha][coluna+j] != CHAR_AGUA) {
					return false;
				}
			}
			for (int j=0; j<TAM_PORTAAVIOES; j++) {
				grid[linha][coluna+j] = CHAR_PORTAAVIOES;
			}
		}
		return true;
	}
	
	public static void imprimir(char[][] grid) {
		out.print("GRID DA BATALHA:\n\n");
		
		out.print("    ");
		for (int i=0; i<COLUNAS_GRID; i++) {
			out.print(i+" ");
                        out.print(" ");
		}
		out.print("\n");
		
		for (int lin=0; lin<LINHAS_GRID; lin++) {
			out.print(lin+ "  ");
			out.print(" ");
			for (int col=0; col<COLUNAS_GRID; col++) {
				out.print(grid[lin][col] + "  ");
			}
			out.print("\n");
		}
		out.print("\n");
	}
	
	public static void main(String[] args) {
		char[][] campoBatalha;
		campoBatalha = inicializarGrid();
		out.println(posicionarPortaAvioes(campoBatalha, 5, 5, false));
		out.println(posicionarPortaAvioes(campoBatalha, 6, 6, false));
		out.println(posicionarPortaAvioes(campoBatalha, 4, 6, true));
		imprimir(campoBatalha);		
	}
	
}

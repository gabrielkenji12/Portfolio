/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula03;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author BadJapa
 */
public class JogoDaVelha {

    public static final int LINHAS_GRID = 3;
    public static final int COLUNAS_GRID = 3;
    public static final char CHAR_GRID = '.';

    public static char[][] inicializarGrid() {
        char[][] grid = new char[LINHAS_GRID][COLUNAS_GRID];
        for (int lin = 0; lin < LINHAS_GRID; lin++) {
            for (int col = 0; col < COLUNAS_GRID; col++) {
                grid[lin][col] = CHAR_GRID;
            }
        }
        return grid;
    }

    public static void imprimir(char[][] grid) {
        out.print("TABULEIRO:\n\n");

        out.print("    ");
        for (int i = 0; i < COLUNAS_GRID; i++) {
            out.print(i + " ");
            out.print(" ");
        }
        out.print("\n");

        for (int lin = 0; lin < LINHAS_GRID; lin++) {
            out.print(lin + "  ");
            out.print(" ");
            for (int col = 0; col < COLUNAS_GRID; col++) {
                out.print(grid[lin][col] + "  ");
            }
            out.print("\n");
        }
        out.print("\n");
    }

    public static boolean step(char[][] grid, int linha, int coluna, char jogador) {
        if (linha < 0 || coluna < 0) {
            return false;
        }
        if (jogador == 'X') {

            if (linha > LINHAS_GRID || coluna > COLUNAS_GRID) {
                return false;
            }

            if (grid[linha][coluna] != CHAR_GRID) {
                return false;
            }

            grid[linha][coluna] = 'X';
        } else {

            if (linha > LINHAS_GRID || coluna > COLUNAS_GRID) {
                return false;
            }

            if (grid[linha][coluna] != CHAR_GRID) {
                return false;
            }

            grid[linha][coluna] = 'O';
        }
        return true;
    }

    public static int status(char[][] tabuleiro) {
        int cont = 0;
        
        //VERIFICA LINHAS
        for (int linha = 0; linha < 3; linha++) {

            if ((tabuleiro[linha][0] == 'X') && (tabuleiro[linha][1] == 'X') && (tabuleiro[linha][2] == 'X')) {
                return 2;
            }
            if ((tabuleiro[linha][0] == 'O') && (tabuleiro[linha][1] == 'O') && (tabuleiro[linha][2] == 'O')) {
                return 1;
            }
        }
        
        //VERIFICA COLUNAS
        for (int coluna = 0; coluna < 3; coluna++) {

            if ((tabuleiro[0][coluna] == 'X') && (tabuleiro[1][coluna] == 'X') && (tabuleiro[2][coluna]) == 'X') {
                return 2;
            }
            if ((tabuleiro[0][coluna] == 'O') && (tabuleiro[1][coluna] == 'O') && (tabuleiro[2][coluna]) == 'O') {
                return 1;
            }
        }
        
        //VERIFICA DIAGONAIS
            
        if ((tabuleiro[0][0] == 'X') && (tabuleiro[1][1] == 'X') && (tabuleiro[2][2] == 'X')) {
            return 2;
        }
        if ((tabuleiro[0][0] == 'O')  && (tabuleiro[1][1] == 'O') && (tabuleiro[2][2] == 'O')) {
            return 1;
        }
        if ((tabuleiro[0][2] == 'X') && (tabuleiro[1][1] == 'X') && (tabuleiro[2][0] == 'X')) {
            return 2;
        }
        if ((tabuleiro[0][2] == 'O') &&  (tabuleiro[1][1] == 'O') && (tabuleiro[2][0] == 'O')) {
            return 1;
        }

        // VERIFICA EMPATE
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (tabuleiro[linha][coluna] != '.') {
                    cont++;
                }
            }    
        }
        if (cont == 9){
            return 0;
        }
        else{
            return -1;
        }   
    }
    
    
    public static void jogo(char [][] tabuleiro){
        Scanner entrada = new Scanner(System.in);
        int resultado = 0; int resultado2 = 0;
        do{
        out.println("Jogador 1 (X) faça a sua jogada:");
        out.println("Digite a linha que deseja realizar a jogada: ");
        int linha = entrada.nextInt();
        out.println("Digite a coluna que deseja realizar a jogada: ");
        int coluna = entrada.nextInt();
        step(tabuleiro, linha, coluna, 'X');
        imprimir(tabuleiro);
        resultado = status(tabuleiro);
            if(resultado == 2){
                out.println("O Jogador 1 (X) VENCEU");
                break;
            }
            if(resultado == 0) {
                out.println("Ocorreu um empate");
                break;
            }
        
        out.println("Jogador 2 (O) faça a sua jogada:");
        out.println("Digite a linha que deseja realizar a jogada: ");
        int linha2 = entrada.nextInt();
        out.println("Digite a coluna que deseja realizar a jogada: ");
        int coluna2 = entrada.nextInt();
        step(tabuleiro, linha2, coluna2, 'O');
        imprimir(tabuleiro);
        resultado2 = status(tabuleiro);
            if(resultado2 == 1){
                out.println("O Jogador 2 (O) VENCEU");
                break;
            }
            if(resultado2 == 0) {
                out.println("Ocorreu um empate");
                break;
            }
        
        }while((resultado == -1) || (resultado2 == -1));
    }

    public static void main(String[] args) {
        char[][] tabuleiro;
        tabuleiro = inicializarGrid();
        imprimir(tabuleiro);
        jogo(tabuleiro);
    }

}

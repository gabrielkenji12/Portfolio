/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 1132587
 */
public class MatrixOperations {
    public static void  main( String args[] ) throws IOException{
    int Mat[][];
  
    //Mat = generateMatrix(4,5);
    Mat = readMatrixFile("matriz.txt");
    printMatrix(Mat);

  }
  /*
  Construa uma função que receba a quantidade de linhas(lin) e de colunas(col) e devolva uma matriz de 
  dimensão lin x col contendo números inteiros aleatórios entre 0 e 100. Teste sua função.
  */
  public static int [ ][ ] generateMatrix(int lin,int col){
  
    int M[][]=new int[lin][col];
  
    for(int i=0;i<lin;i++)
      for(int j=0;j<col;j++)
           M[i][j]=(int) (Math.random()*100); // gera numeros aleatorios entre 0 e 100
    
    return M;
  }
  /*
  Construa um procedimento que receba uma matriz de números inteiros e exiba o seu conteúdo na 
  formatação gráfica de uma matriz. Teste seu procedimento. 
  */
 
  public static void printMatrix(int M[ ][ ]){
    
    for( int i=0; i < M.length; i++ ){
      for(int j=0;j<M[0].length;j++){
        System.out.print(M[i][j] + " " );
      }
      System.out.println();
    }
  }
  /*
    Construa uma função que receba o nome de um arquivo de entrada (String file) e lê e aloca uma
    a matriz que armazenada no arquivo de entrada 
  */
  
 
  public static int [ ][ ] readMatrixFile(String file) throws IOException {
      //Abre o arquivo para leitura
      BufferedReader arq =new BufferedReader( new FileReader(file)); // leitura
         
      //le a linha
      String linha = arq.readLine();
      String linhas[] = linha.split(" ");
      
      int lin = Integer.parseInt(linhas[0]);
      int col = Integer.parseInt(linhas[1]);
      
      //Criando a matriz a partir das linhas e colunas lidas do arquivo
      int M[][] = new int[lin][col];
      
      for (int i=0; i<lin; i++){
          linha = arq.readLine();
          linhas = linha.split(" ");
          for (int j=0; j<col;j++){
              M[i][j]=Integer.parseInt(linhas[j]);
         }
      }
      arq.close();
      return M;

  }
 
}

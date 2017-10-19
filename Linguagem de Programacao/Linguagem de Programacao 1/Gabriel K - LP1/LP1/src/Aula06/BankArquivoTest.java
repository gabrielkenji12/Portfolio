/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author BadJapa
 */
public class BankArquivoTest {
    

    
    public static void main(String[] args) throws FileNotFoundException{ 
       
        
        Bank b = new Bank("entrada.txt");
        System.out.println("Busca: " + b.getTotalBalance());
    }
}

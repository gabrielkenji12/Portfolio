/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab02;

import java.util.Scanner;

/**
 *
 * @author 41528387
 */
public class MainTeste {
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("--------- Bem Vindo ---------");
        System.out.println("-----------------------------");
        System.out.println("Digite o nome do hotel que deseja cadastrar: ");
        String nome = entrada.nextLine();
        System.out.println("Digite o cnpj ho hotel: ");
        String cnpj = entrada.nextLine();
        
        //Criação de um endereco para teste
        
        Endereco end01 = new Geografico("Nenhum", "101", "03010-030", "São Paulo", "São Paulo", "Brasil");
        Endereco end02 = new Geografico("Nenhum", "1055", "02072-036", "Rio de Janeiro", "Rio de Janeiro", "Brasil");
        Endereco end03 = new Geografico("Nenhum", "1022", "08054-020", "São Paulo", "São Paulo", "Brasil");
        Endereco end04 = new Telefonico(011,"1234-1234",55);
        Endereco end05 = new Telefonico(011,"1222-1333",55);
        Endereco end06 = new Virtual("www.hotel.com", "hotel@gmail.com");
        Endereco end07 = new Virtual("www.hotel2.com", "hotel2@gmail.com");
        
        //Criação do hotel para teste com as informações fornecidas pelo usuario
        Hotel hotel1 = new Hotel(nome, cnpj);
        
        
        //Criação de alguns tipos de quartos para teste
        TipoQuarto tipo01 = new TipoQuarto(enumTipo.SUITE,500, "Quarto Suite" , "fotoSuite.jpg");
        TipoQuarto tipo02 = new TipoQuarto(enumTipo.SUITE_PRESIDENCIAL,950, "Quarto Suite Presidencial" , "fotoSuitePresidencial.jpg");
        TipoQuarto tipo03 = new TipoQuarto(enumTipo.SIMPLES,250, "Quarto Simples" , "fotoSimples.jpg");
        
        
        //Criação de alguns quartos para teste
        Quarto quarto1 = new Quarto(tipo01,100, 1);
        Quarto quarto2 = new Quarto(tipo02,101, 1);
        Quarto quarto3 = new Quarto(tipo03,102, 1);
        Quarto quarto4 = new Quarto(tipo01,200, 2);
        Quarto quarto5 = new Quarto(tipo02,201, 2);
        Quarto quarto6 = new Quarto(tipo03,202, 2);
        
        //Adicionando os endereços de teste para o hotel1 criado
        
        hotel1.addEndereco(end01);
        hotel1.addEndereco(end05);
        hotel1.addEndereco(end07);
        
        
        //Adicionando os quartos de teste para o hotel1 criado
        
        hotel1.addQuarto(quarto1);
        hotel1.addQuarto(quarto2);
        hotel1.addQuarto(quarto3);
        hotel1.addQuarto(quarto4);
        hotel1.addQuarto(quarto5);
        hotel1.addQuarto(quarto6);
        
        
        
        //Saida de Dados Teste
        System.out.println(hotel1);
        System.out.println("");
        System.out.println(hotel1.getNome());
        System.out.println(hotel1.getCnpj());
        System.out.println("");
        hotel1.mostraQuartos();
        hotel1.mostraEndereco();
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Race;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author 31618571
 */
public class Race implements Serializable{
    private String typeRace;

    public Race() {
        this.typeRace = TypeRace.H.getType();
    }
    
    public Race(String type){
        this.typeRace = type;
    }

    public String getTypeRace() {
        return typeRace;
    }
    
    
    public String chooseRace(){
        Scanner scn = new Scanner(System.in);
        TypeRace s = null;
        int controler;
        do{
            try{
                System.out.println("\tEscolha sua raça:\n"+
                        "\t1-Human - Sem Bônus adicionais(Recomendado para jogadores experientes)\n"+
                        "\t2-Demon - Comece o jogo com Poder +1\n"+
                        "\t3-Elf - Começe o jogo com Nivel +1\n"+
                        "\t4-Dwarf - Começe o jogo com 500 gold");
                System.out.print("\tOpção escolhida: ");
                controler = Integer.parseInt(scn.nextLine());
            }catch(NumberFormatException ex){
                System.out.println("Digite um número de 1 a quatro!!");
                controler = 0;
            }
        }while(controler<1 || controler>4);
        
        switch(controler){
            case 1:
                typeRace = TypeRace.H.getType();
                break;
            case 2:
                typeRace = TypeRace.D.getType();
                break;
            case 3:
                typeRace = TypeRace.E.getType();
                break;
            case 4:
                typeRace = TypeRace.Dw.getType();
                break;
        }
        
        return typeRace;
    }

    @Override
    public String toString() {
        return typeRace;
    }
    
    
    
    
    
}

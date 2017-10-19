/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Job;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author 31618571
 */
public class Job implements Serializable{
    private String typeJob;

    public Job() {
        typeJob = "";
    }
    
    public Job(String type){
        typeJob = type;
    }
    
    public String chooseJob(){
        Scanner scn = new Scanner(System.in);
        TypeJob s = null;
        int controler;
        do{
            try{
                System.out.println("\tEscolha sua profissão:\n"+
                        "\t1-Warrior - Especialista em Combate Corpo a Corpo\n"+
                        "\t2-Wizard - Especialista em lançar Poderosas Magias\n"+
                        "\t3-Archer - Especialista no Combate a Distancia\n"+
                        "\t4-Rogue - Especialista na arte da furtividade");
                System.out.print("\tOpção escolhida: ");
                controler = Integer.parseInt(scn.nextLine());
            }catch(NumberFormatException ex){
                System.out.println("Digite um número de 1 a quatro!!");
                controler = 0;
            }
        }while(controler<1 || controler>4);
        
        switch(controler){
            case 1:
                typeJob = TypeJob.W.getJob();
                break;
            case 2:
                typeJob = TypeJob.Wz.getJob();
                break;
            case 3:
                typeJob = TypeJob.A.getJob();
                break;
            case 4:
                typeJob = TypeJob.R.getJob();
                break;
        }
        return typeJob;
    }

    @Override
    public String toString() {
        return typeJob;
    }
    
    
}
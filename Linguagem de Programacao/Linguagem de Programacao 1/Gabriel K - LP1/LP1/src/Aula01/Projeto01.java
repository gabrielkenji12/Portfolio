/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula01;

import java.util.Scanner;

/**
 *
 * @author Gabriel Kenji Fernandes  -  TIA:4152838-7
 */
public class Projeto01 {
    
    //Entrada de dados para o usuário digitar o tamanho do vetor (no máximo 100)
    public static int entradaTamanhoVetor(){
        int tamanho;
        tamanho = 0;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o tamanho do vetor desejado (no Máximo 100 números): ");
        tamanho = entrada.nextInt();// variavel que controla  o tamanho do vetor, de acordo com o numero desejado pelo usuário
        while (tamanho > 100){
            System.out.print("Tamanho inválido, digite novamente: ");
            tamanho = entrada.nextInt();
        }
        return tamanho;
    }
    
    // Gera um vetor de Números Aleatorios
    public static int[] generateVector(int tamanho){
        int v[] = new int [100];
           for (int i=0; i<tamanho; i++) { // variavel que controla  o tamanho do vetor, de acordo com o numero desejado pelo usuário
            v[i] = (int) (Math.random()*100);
        }
        return v;
    }
    
    
    // OPÇÀO 1 - DO MENU (adiciona um elemento no final da coleção)
    public static void adicionarFinal (int v[], int tamanho){
       Scanner entrada = new Scanner(System.in);
       int num;
       System.out.print("Digite o número que deseja adicionar ao final do vetor: ");
       num = entrada.nextInt();
            // Se o tamanho do vetor é menor do que 100 ele adiciona o número desejado pelo usuário na próxima poisção disponível 
            for ( int i=0; i<tamanho + 1 ; i++){
                if (i==tamanho){
                v[i] = num;
                }
                if (i>100){
                    System.out.print("Impossível realizar a operação pois o vetor ja está cheio");
                    break;
                }
               
                System.out.print(v[i] + " ");
            }
    }
    
    
    // OPÇÀO 2 - DO MENU (adiciona um dado elemento em uma dada posição
    public static void adicionarPosicao (int v[], int tamanho){
        Scanner entrada = new Scanner(System.in);
        int num, posicao;
        posicao = 0;
        System.out.print("Digite o número que deseja adicionar: ");
        num = entrada.nextInt();
        System.out.print("Digite a posição que deseja adicionar o número: ");
        posicao = entrada.nextInt();
        //Repete até que a posição desejada seja válida(tem que estar ocupada) ou (menor do que 100)
        while ((posicao >= tamanho) || (posicao > 100)){
            System.out.print("Posição Inválida, digite o número novamente: ");
            posicao = entrada.nextInt();
        }
        for(int i=tamanho + 1 ; i >= 0; i--){
           if((i > posicao) && (i < tamanho +1 ) ){
                   v[i] = v[i-1];
               }
            if(i == posicao){
               v[i] = v[i+1];
               v[i] = num;
            }
        }    
        for(int i =0; i < tamanho + 1; i++){
            System.out.print(v[i] + " ");
        }
        
    }
    
    // OPÇÀO 3 - DO MENU (Remove o elemento de uma dada posição)
    public static void removerPosicao (int v[], int tamanho) {        
        Scanner entrada = new Scanner(System.in);
        int posicao;
        posicao=0;
        System.out.print("Digite a posição que deseja remover o número: ");
        posicao = entrada.nextInt();
        //Repete até que a posição desejada seja válida (menor do que 100) ou (menor do que o tamanho do vetor)
        while ((posicao > 100) || (posicao > tamanho)){   
            System.out.print("Posição inválida ou não está ocupada, digite novamente: ");
            posicao = entrada.nextInt();
        }
        
        for(int i=0; i<tamanho - 1 ; i++){
            if((i == posicao) || (i > posicao)){
               v[i] = v[i+1];
            }
            System.out.print(v[i] + " ");
        }
    }
    
    
    // OPÇÀO 4 - DO MENU (Remove todas as ocorrências de um elemento na coleção)
    public static void removerTodas (int v[], int tamanho) {       
        Scanner entrada = new Scanner(System.in);
        int num;
        System.out.print("Digite o número que deseja remover todas as suas ocorrências do vetor: ");
        num = entrada.nextInt();
        
        for(int i=0; i<tamanho; i++){
            if(v[i] == num){ // sempre que um numero do vetor v[], for igual ao numero digitado pelo usuário ele vai ser removido
                for(int k=i; k<tamanho; k++){
                    v[i] = v[k];
                }
            }
            System.out.print(v[i] + " ");
        }
    }    
    
    
    // OPÇÀO 5 - DO MENU (Verificar se dado um elemento está contido na coleção)
    public static int verificarElemento (int v[], int tamanho) {       
        int num, busca; 
        busca=0;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escreva o número, para verificar se o elemento está no vetor: ");
        num = entrada.nextInt();
        for(int i=0; i<tamanho; i++){
            if(v[i] == num){ // verifica se o número digitado está no vetor
                busca = v[i]; // se estiver no vetor, ele retornará a posiçào
            }
            else{
                busca = -1; // se não estiver, ele retornará o valor -1
            }
        }
        System.out.println(busca);
        
        for (int i=0; i<tamanho; i++){
            System.out.print(v[i] + " ");
        }
        return busca;
    }


    // OPÇÀO 6 - DO MENU (Verifica se dado um elemento existem dois números na coleção que somados é igual ao elemento informado)
    public static int verificarSoma (int v[], int tamanho) {       
        int num, busca;
        busca=0;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escreva o número, para verificar se a soma de dois elementos do vetor são iguais a ele: ");
        num = entrada.nextInt();
        for(int i=0; i<tamanho; i++){
            for(int j=i+1; j<tamanho-1; j++){
                if(num == v[i] + v[j]){ // verifica se no vetor a soma de quaisquer dois elementos é igual ao numero digitado 
                    busca = 1; // se existir a soma, retorna o valor 1
                }
                else{
                    busca = 0; // se não existir a soma retorna o valor 0
                }
                
            }   
        }
        System.out.println(busca);
        
        for (int i=0; i<tamanho; i++){
            System.out.print(v[i] + " ");
        }
        return busca;
    }
    
    // Entrada de dados do Menu
    public static int menuEntrada() {
       Scanner entrada = new Scanner(System.in);
       int opcao;
       opcao = 0;
       // menu com as opçòes disponiveis
       System.out.println("Escolha uma das seguintes opções: 1-Adicionar um elemento no final da coleção 2-Adicionar um dado elemento em uma dada posição 3-Remover o elemento de uma dada posição 4-Remover todas as ocorrências de um elemento na coleção 5-Verificar se dado um elemento está contido na coleção 6-Verificar se dado um elemento existem dois números na coleção que somados é igual ao elemento informado");
       opcao = entrada.nextInt();
       while((opcao<1) || (opcao>6)){ // realiza a consistência do menu para somente aceitar uma das opções validas
           System.out.println("Opção Inválida, porfavor digite novamente");
           opcao = entrada.nextInt();
       }
       return opcao;
    }
    
    //Mostra para o usuário o vetor criado apartir do tamanho pedido
    public static void mostraVetor(int v[], int tamanho) {
        Scanner entrada = new Scanner(System.in);
        for (int i=0; i<tamanho; i++){
            System.out.print(v[i] + " ");
        }
        System.out.println(" ");
    }
    
    
     public static void main (String[] args){
       int opcao, resultado, tamanho;
       opcao = 0;
       tamanho = entradaTamanhoVetor();
       int v[] = generateVector(tamanho);
       mostraVetor(v, tamanho);
       opcao = menuEntrada(); 
      
       
       switch (opcao){
           case 1:
               adicionarFinal(v, tamanho);
               break;
           case 2:
               adicionarPosicao (v, tamanho);
               break;
           case 3:
               removerPosicao (v, tamanho);
               break;
           case 4:  
                removerTodas (v, tamanho);
                break;
           case 5:
               resultado = verificarElemento (v,tamanho);
               break;
           case 6:
               resultado = verificarSoma (v, tamanho);
               break;
               
       }
    }
}     
     
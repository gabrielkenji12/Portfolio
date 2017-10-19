/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Main;

import Projeto_lp2_Muchkins.Character.Player;
import Projeto_lp2_Muchkins.Match.Match;
import Projeto_lp2_Muchkins.Match.Round;
import Projeto_lp2_Muchkins.Monster.MonsterFactorySingleton;
import Projeto_lp2_Muchkins.Treasure.TreasureFactorySingleton;
import Projeto_lp2_Muchkins.Util.IOUtil;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31618571
 */
public class Game implements Serializable {

    Scanner entrada = new Scanner(System.in);
    ArrayList<Match> matches;
    MonsterFactorySingleton mfs = MonsterFactorySingleton.getInstance();
    TreasureFactorySingleton tfs = TreasureFactorySingleton.getInstance();
    Match m;
    File saves;

    public Game() {
        saves = new File("saves.txt");
        title();
        int mainControl = 0;
        do {
            try {
                this.matches = new ArrayList<>();
                //this.matches = IOUtil.carregaPartidas(saves);
                principalMenu();
                System.out.print("Opção escolhida: ");
                mainControl = Integer.parseInt(entrada.nextLine());
                switch (mainControl) {
                    case 1:
                        guideMenu();
                        break;
                    case 2:
                        newGame();
                        gameMenu();
                        break;
                    case 3:
                        System.out.println("");
                        loadGame();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção Inválida");
                        break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Digite um número válido");
            } 
        } while (mainControl != 4);
    }

    public void title() {
        System.out.println("\t\t-----------------------------------------------");
        System.out.println("\t\t--------------- M U N C H K I N ---------------");
        System.out.println("\t\t-----------------------------------------------");
        System.out.println("\t\t                                   Java Version");
    }

    public void principalMenu() {
        System.out.println("\n\n------ MENU ------");
        System.out.println("1 - Guia do Jogo");
        System.out.println("2 - Novo Jogo");
        System.out.println("3 - Carregar Jogo");
        System.out.println("4 - Sair");
    }

    public void guideMenu() {

        int guideControl = 0;
        do {
            try {
                System.out.println("\n\n------ GUIA DO JOGO ------");
                System.out.println("1 - Regras do Jogo");
                System.out.println("2 - Lista de Monstros");
                System.out.println("3 - Lista de Tesouros");
                System.out.println("4 - Sair");
                System.out.print("Opção escolhida: ");
                guideControl = Integer.parseInt(entrada.nextLine());
                switch (guideControl) {
                    case 1:
                        rules();
                        break;
                    case 2:
                        System.out.println("");
                        mfs.showMonsters();
                        break;
                    case 3:
                        System.out.println("");
                        tfs.showTreasures();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Opção Inválida");
                        break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Digite um número válido");
            }
        } while (guideControl != 4);
    }

    public void rules() {
        System.out.println("\nRegras do jogo:\n"
                + "\t- O jogo acaba quando você atingir o nível máximo(de acordo com a dificuldade).\n"
                + "\t- O jogo é composto de várias rodadas e em cada rodada, o jogador terá que enfrentar algum perigo, entrando em uma calabouço.\n"
                + "\t- Para ganhar uma batalha, o poder dele(Nivel + Equipamento(s)) tem que ser maior do que a força do Monstro.\n"
                + "\t- Todos jogadores possuem sua quantidade de ouro. O jogador adiquire ouro ao derrotar Monstros(Dão uma quantidade aleatória de ouro) ou trocando suas cartas de Equipamento(Cada uma possui uma quantidade de ouro para troca).\n"
                + "\t- O jogador ganha Nível vencendo uma batalha ou trocando suas cartas. Da segunda maneira, respectivamente, o jogador precisa juntar 1000 de Ouro.\n"
                + "\t- Cartas de Equipamento sao restritas, sendo de 4 tipos:Cabeça,Pés,Mão unica ou Mão dupla\n"
                + "\t- A cada Equipamento equipado, o jogador ganha um bonus específico de cada carta de Equipamento. Um Equipamento só pode ser equipado se no lugar a ser equipado, não se encontra nenhum outro existente.\n");

    }

    public void newGame() {
        System.out.println("");
        System.out.println("------ NOVO JOGO ------");
        System.out.println("Agora você está prestes a começar sua aventura...");
        int difficulty = 0;
        boolean verify;
        String name;
        do {
            System.out.println("Em qual dificildade deseja jogar:\n"
                    + "\t1- Easy (Acaba o jogo quando atingir o nivel 7 e começa com 5 cartas)\n"
                    + "\t2- Medium (Acaba no nivel 8 e começa com 4 cartas)\n"
                    + "\t3- Hard (Acaba o jogo no nível 10 e começa com 3 cartas");
            System.out.print("\tOpção escolhida: ");
            try {
                difficulty = Integer.parseInt(entrada.nextLine());
                System.out.println("");
            } catch (NumberFormatException ex) {
                System.out.println("");
                System.out.println("Digite um número !!");
            }
            if (difficulty < 1 || difficulty > 3) {
                System.out.println("Por favor, digite 1,2 ou 3");
                System.out.println("");
            }
        } while (difficulty < 1 || difficulty > 3);

        String d = "";
        if (difficulty == 1) {
            d = "Easy";
        }
        if (difficulty == 2) {
            d = "Medium";
        }
        if (difficulty == 3) {
            d = "Hard";
        }
        System.out.println("Olá jogador! Seja bem vindo a Mundo de Munchkin, aqui você irá se aventurar e tentar sobreviver aos perigos e mistérios!");
        do {
            System.out.println("Para começar, escreva seu nome:");
            name = entrada.nextLine();
            verify = verifyName(name);
            if (verify == false) {
                System.out.println("Nome já está em uso");
            }
        } while (verify == false);
        Player p = new Player(name);
        System.out.println("Digite a sua senha agora: ");
        String password = entrada.nextLine();

        m = new Match(p, difficulty, password);

        System.out.println("\nBem vindo " + name + ", agora vamos continuar criando seu perfil...");
        p.chooseRace();
        System.out.println("----------\n");
        p.chooseJob();
        System.out.println("\n----------\n");
        p.setRaceBonus();
        System.out.println("\nRecebendo seus primeiros Tesouros....");
        m.getPlayer().startingTreasures(difficulty);
        System.out.println("Parabéns " + p.getName() + ", você contruiu seu perfil com sucesso:\n"
                + "\t- Seu nome é: " + p.getName() + "\n"
                + "\t- Seu nível é: " + p.getLevel() + "\n"
                + "\t- Seu Poder é: " + p.getTotalPower() + "\n"
                + "\t- Seu total de ouro é:" + p.getTotalGold() + "\n"
                + "\t- Dificuldade escolhida: " + d);
        System.out.println("");
        matches.add(m);
        m.getPlayer().showInventory();
        saveGame();
    }

    public void gameMenu() {
        int gameControl = 0;
        do {
            try {
                System.out.println("\n\n------ MENU DO JOGO ------");
                System.out.println("Bem Vindo " + m.getPlayer().getName());
                System.out.println("1 - Começar Nova Rodada (Seu jogo será salvo ao final de cada rodada)");
                System.out.println("2 - Informações do personagem");
                System.out.println("3 - Ver Inventário");
                System.out.println("4 - Retornar ao menu principal");
                System.out.print("Opção escolhida: ");
                gameControl = Integer.parseInt(entrada.nextLine());
                switch (gameControl) {
                    case 1:
                        System.out.println("");
                        gameControl = newRound();
                        saveGame();
                        break;
                    case 2:
                        System.out.println("");
                        System.out.println(m.getPlayer());
                        break;
                    case 3:
                        System.out.println("");
                        m.getPlayer().showInventory();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Opção Inválida");
                        break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Digite um número válido");
            }
        } while (gameControl != 4);
    }

    public int newRound() {
        Round n = new Round();
        boolean endGame = n.startRound(m.getRoundNumber(), m.getPlayer(), m.getDifficulty());
        m.addRound(n);
        IOUtil.salvaPartidas(saves, matches);
        if(endGame == true){
            return 4;
        }
        return 0;
        
    }

    public boolean verifyName(String name) {
        try {
            for (Match match : matches) {
                if (match.getPlayer().getName().equalsIgnoreCase(name)) {
                    return false;
                }
            }
            return true;
        } catch (NullPointerException ex) {
            return true;
        }
    }

    public void loadGame() {
        try {
            int cont = 0;
            matches = IOUtil.carregaPartidas(saves);
            if (matches.size() == 0) {
                System.out.println("Não há jogos salvos");
            } else {
                for (Match m : matches) {
                    System.out.println(cont + " - " + m);
                    cont++;
                }

                System.out.print("Escolha o Jogo que deseja carregar: ");
                int loadedGame = Integer.parseInt(entrada.nextLine());
                System.out.print("Digite a sua senha : ");
                String password = entrada.nextLine();
                m = matches.get(loadedGame);
                boolean result = m.loguin(password);
                if (result == true) {
                    System.out.println("Jogo Carregado com sucesso");
                    m.setDate();
                    gameMenu();
                } else {
                    System.out.println("Senha Inválida");
                    this.m = null;
                }
            }
        } catch (NumberFormatException | IndexOutOfBoundsException ex) {
            System.out.println("Digite um número válido!");
        } catch (NullPointerException ex) {
            System.out.println("Não há jogos salvos no momento!");
        }
    }

    public void saveGame() {
        this.matches = IOUtil.carregaPartidas(saves);
        int del = 0;
        for (int i = 0; i < matches.size(); i++) {
            if (matches.get(i).getPlayer().getName().equalsIgnoreCase(m.getPlayer().getName())) {
                matches.set(i, m);
                del++;
                System.out.println("Jogo Salvo com sucesso!");
            }
        }
        if (del == 0) {
            matches.add(m);
        }
        IOUtil.salvaPartidas(saves, matches);
    }
}

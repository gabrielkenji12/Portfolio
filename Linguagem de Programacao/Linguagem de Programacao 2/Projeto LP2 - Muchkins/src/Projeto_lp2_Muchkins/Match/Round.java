/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Match;

import Projeto_lp2_Muchkins.Character.Player;
import Projeto_lp2_Muchkins.Dungeon.Dungeon;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author 41528387
 */
public class Round implements Serializable {

    private int roundNumber;
    private Dungeon dungeon;
    private Dice dice;

    public Round() {
        this.dice = Dice.getInstance();
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public boolean startRound(int roundNumber, Player p, int difficulty) {
        Scanner entrada = new Scanner(System.in);
        Dungeon d = new Dungeon();
        this.dungeon = d;
        dungeon.createDungeon(p.getTotalPower());
        this.roundNumber = roundNumber;
        boolean sair = false;
        boolean end = false;

        do {
            System.out.println("");
            System.out.println(p);
            System.out.println("");
            chooseAction(this.roundNumber);
            System.out.print("Opção escolhida: ");
            int escolha = Integer.parseInt(entrada.nextLine());
            System.out.println("");
            switch (escolha) {
                case 1:
                    p.sellEquipment();
                    break;
                case 2:
                    p.levelUp();
                    end = endGame(difficulty, p);
                    break;
                case 3:
                    System.out.println(p);
                    System.out.println("");
                    p.equipEquipment();
                    break;
                case 4:
                    p.useItem();
                    end = endGame(difficulty, p);
                    break;
                case 5:
                    end = battle(difficulty, p);
                    sair = true;
                    break;
            }
        } while (sair != true);
        return end;

    }

    public void chooseAction(int roundNumber) {
        System.out.println("\nRound " + roundNumber + ", escolha a sua ação :");
        System.out.println("1 - Vender algum Equipamente");
        System.out.println("2 - Subir Nivel");
        System.out.println("3 - Equipar Equipamento");
        System.out.println("4 - Usar Item");
        System.out.println("5 - Entrar no Calabouço");
    }

    public boolean battle(int difficulty, Player p) {
        System.out.println("Entrando no calabouço " + dungeon.getName());
        if (dungeon.getMonster() == null) {
            System.out.println("Sorte grande!! O Monstro do calabouço está de Férias");
            System.out.println("Tesouro obtido: ");
            System.out.println(dungeon.getTreasure().toString());
            p.addTresure(dungeon.getTreasure());
            p.addLevel(1);
        } else {
            System.out.println(dungeon.getMonster());

            int playerPower = p.getTotalPower();
            int monsterPower = dungeon.getMonster().getPower();
            if (playerPower >= monsterPower) {
                System.out.println("------- Resultados da Batalha -------");
                System.out.println("Parabéns você derrotou o monstro!");
                System.out.println("Tesouro obtido: ");
                System.out.println(dungeon.getTreasure().toString());
                p.addTresure(dungeon.getTreasure());
                p.addLevel(1);
                p.addGold(dungeon.getMonster().getGoldDrop());
            } else {
                System.out.println("------- Resultados da Batalha -------");
                System.out.println("Você foi derrotado pelo monstro! Porém ainda há uma chance de escapar...");
                System.out.println("O Dado será rolado, se você tirar 6 ainda podera escapar");
                System.out.println("ROLANDO.......");
                int diceResult = rollDice();
                if (diceResult == 6) {
                    System.out.println("Parabens você tirou um 6, e agora podera escapar do calabouço");
                } else {
                    String badThing = dungeon.getMonster().getBadThingText();
                    System.out.println("Infelizmente você tirou um " + diceResult + ", e não conseguiu escapar...");
                    System.out.println("Devido ao seu fracasso você foi amaldiçoado pelo monstro " + dungeon.getMonster().getName());
                    System.out.println("Você perderá " + badThing);
                    if (badThing.equalsIgnoreCase("Perde 300 golds")) {
                        p.setGold(300);
                        System.out.println("Seu Gold agora é : " + p.getTotalGold());
                    } else if (badThing.equalsIgnoreCase("Perde 500 golds")) {
                        p.setGold(500);
                        System.out.println("Seu Gold agora é : " + p.getTotalGold());
                    } else if (badThing.equalsIgnoreCase("Perde 1000 golds")) {
                        p.setGold(1000);
                        System.out.println("Seu Gold agora é : " + p.getTotalGold());
                    } else if (badThing.equalsIgnoreCase("Perde 1 Nivel")) {
                        p.setLevel(1);
                        System.out.println("Seu Nivel agora é : " + p.getLevel());
                    } else if (badThing.equalsIgnoreCase("Perde 2 Niveis")) {
                        p.setLevel(2);
                        System.out.println("Seu Nivel agora é : " + p.getLevel());
                    } else if (badThing.equalsIgnoreCase("Perde 3 Niveis")) {
                        p.setLevel(3);
                        System.out.println("Seu Nivel agora é : " + p.getLevel());
                    } else if (badThing.equalsIgnoreCase("Perde seu Chapeu")) {
                        p.setEquipHead();
                        System.out.println("Você perdeu seu equipamento");
                    } else if (badThing.equalsIgnoreCase("Perde sua Bota")) {
                        p.setEquipFoot();
                        System.out.println("Você perdeu seu equipamento");
                    }

                }
            }
        }
            boolean end = endGame(difficulty, p);
            return end;
    }

    public int rollDice() {
        int diceSelectedFace = dice.rodarDado();
        return diceSelectedFace;
    }

    public boolean endGame(int difficult, Player p) {
        int playerLevel = p.getLevel();
        if (difficult == 1) {
            if (playerLevel == 7) {
                System.out.println("\n\n\t ------ PARABENS ------ ");
                System.out.println("\tParabens você completou o jogo no modo Easy!");
                System.out.println("\tVocê ainda poderá continuar jogando \n");
                return true;
            }
        }
        if (difficult == 2) {
            if (playerLevel == 8) {
                System.out.println("\n\n\t ------ PARABENS ------ ");
                System.out.println("\tParabens você completou o jogo no modo Medium!");
                System.out.println("\tVocê ainda poderá continuar jogando \n");
                return true;
            }
        }
        if (difficult == 3) {
            if (playerLevel == 10) {
                System.out.println("\n\n\t ------ PARABENS ------ ");
                System.out.println("\tParabens você completou o jogo no modo Hard!");
                System.out.println("\tVocê ainda poderá continuar jogando \n");
                return true;
            }
        }

        return false;
    }

}

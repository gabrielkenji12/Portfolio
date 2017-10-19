/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Character;

import Projeto_lp2_Muchkins.Job.Job;
import Projeto_lp2_Muchkins.Race.Race;
import Projeto_lp2_Muchkins.Treasure.Equipment;
import Projeto_lp2_Muchkins.Treasure.Item;
import Projeto_lp2_Muchkins.Treasure.Treasure;
import Projeto_lp2_Muchkins.Treasure.TreasureFactorySingleton;
import Projeto_lp2_Muchkins.Treasure.TypeEquip;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 31618571
 */
public class Player implements Serializable {

    private int level;
    private String name;
    private int totalPower;
    private int totalGold;
    private Race race;
    private Job job;
    private Equipment EquipLeftHand;
    private Equipment EquipRightHand;
    private Equipment EquipHead;
    private Equipment EquipFoot;
    private List<Treasure> inventory;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.totalPower = 0;
        this.totalGold = 0;
        this.EquipLeftHand = null;
        this.EquipRightHand = null;
        this.EquipHead = null;
        this.EquipFoot = null;
        this.inventory = new ArrayList<>();
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public int getTotalGold() {
        return totalGold;
    }

    public Race getRace() {
        return race;
    }

    public Job getJob() {
        return job;
    }

    public int getTotalPower() {
        return totalPower;
    }

    public void chooseRace() {
        String r;
        Race race = new Race();
        r = race.chooseRace();
        Race r1 = new Race(r);
        this.race = r1;
    }

    public void chooseJob() {
        String j;
        Job job = new Job();
        j = job.chooseJob();
        Job j1 = new Job(j);
        this.job = j1;
    }

    public void startingTreasures(int difficult) {
        Treasure t = null;
        int maxTreasures = 0;
        if (difficult == 1) {
            maxTreasures = 5;
        } else if (difficult == 2) {
            maxTreasures = 4;
        } else if (difficult == 3) {
            maxTreasures = 3;
        }
        for (int i = 0; i < maxTreasures; i++) {
            TreasureFactorySingleton tfs = TreasureFactorySingleton.getInstance();
            t = tfs.ramdonStartingTreasure();
            inventory.add(t);
        }
    }

    public void showInventory() {
        System.out.println("\t--- Seu Inventário ---");
        int cont = 0;
        for (Treasure t : inventory) {
            System.out.println("\tCarta " + cont);
            System.out.println("\tNome: " + t.getName());
            if (t instanceof Equipment) {
                System.out.println("\tOuro: " + ((Equipment) t).getGold());
                System.out.println("\tBônus de poder: " + ((Equipment) t).getPowerBonus());
                System.out.println("\tEquipamento de: " + ((Equipment) t).getTypeEquip());
            } else {
                if (t instanceof Item) {
                    System.out.println("\tEfeito: " + ((Item) t).getEffect());
                }
            }
            System.out.println("\t------");
            cont++;
        }
        System.out.println("-----------------");
    }

    public void levelUp() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Seu Gold : " + this.totalGold);
        System.out.println("Para subir 1 nivel é necessario gastar 1000 golds. Deseja continuar: ");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.print("Sua escolha: ");
        try {
            int escolha = Integer.parseInt(entrada.nextLine());
            if (escolha == 1) {
                if (this.totalGold >= 1000) {
                    this.level += 1;
                    this.totalGold -= 1000;
                    System.out.println("Subiu +1 Nivel ,  seu Nivel agora é: " + this.level);
                } else {
                    System.out.println("Gold Insuficiente");
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("Digite um número!");
        }
    }

    public void calculateTotalPower() {
        this.totalPower = 0;
        int powerEquip = 0;
        int twohand = 0;
        if (EquipLeftHand != null) {
            if (EquipLeftHand.getTypeEquip().equals(TypeEquip.TWOHAND)) {
                twohand = EquipLeftHand.getPowerBonus();
            }
            powerEquip += EquipLeftHand.getPowerBonus();
        }
        if (EquipRightHand != null) {
            powerEquip += EquipRightHand.getPowerBonus();
        }
        if (EquipHead != null) {
            powerEquip += EquipHead.getPowerBonus();
        }
        if (EquipFoot != null) {
            powerEquip += EquipFoot.getPowerBonus();
        }
        this.totalPower += (powerEquip - twohand);
    }

    public void sellEquipment() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escolha o equipamento que deseja vender: ");
        int cont = 0;
        for (Treasure t : inventory) {
            if (t instanceof Equipment) {
                System.out.println(cont + " - " + t);
                cont++;
            }
            if (t instanceof Item) {
                cont++;
            }
        }
        try {
            int escolha = Integer.parseInt(entrada.nextLine());
            for (int i = 0; i < inventory.size(); i++) {
                if (i == escolha && inventory.get(i) instanceof Equipment) {
                    Equipment e = (Equipment) inventory.get(i);
                    int gold = e.getGold();
                    inventory.remove(i);
                    this.totalGold += gold;
                    System.out.println("Equipamento vendido, Seu gold: " + this.totalGold);
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("Digite um número!");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Equipamento Inválido!");
        } catch (ClassCastException ex) {
            System.out.println("Item Inválido");
        }
    }

    public void equipEquipment() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escolha o Equipamento que deseja equipar em seu personagem: ");
        int cont = 0;
        for (Treasure t : inventory) {
            if (t instanceof Equipment) {
                System.out.println(cont + " - " + t);
                cont++;
            }
            if (t instanceof Item) {
                cont++;
            }
        }
        try {
            System.out.print("Opção escolhida: ");
            int escolha = Integer.parseInt(entrada.nextLine());
            for (int i = 0; i < inventory.size(); i++) {
                if (i == escolha && inventory.get(i) instanceof Equipment) {
                    Equipment e = (Equipment) inventory.get(i);

                    if (e.getTypeEquip().equals(TypeEquip.ONEHAND)) {
                        System.out.println("Escolha em qual mão será equipada a arma: \n(Se houver alguma arma equipada anteriormente, ela sera substituida pela nova))");
                        System.out.println("1 - Mão Direita");
                        System.out.println("2 - Mão Esquerda");
                        System.out.print("Opção Escolhida: ");
                        int escolha2 = Integer.parseInt(entrada.nextLine());
                        if (escolha2 == 1) {
                            if ((this.EquipRightHand != null) && (EquipRightHand.getTypeEquip().equals(TypeEquip.TWOHAND))) {
                                this.EquipLeftHand = null;
                            }
                            this.EquipRightHand = e;

                        }
                        if (escolha2 == 2) {
                            if ((this.EquipLeftHand != null) && (EquipLeftHand.getTypeEquip().equals(TypeEquip.TWOHAND))) {
                                this.EquipRightHand = null;
                            }
                            this.EquipLeftHand = e;
                        }
                    }
                    if (e.getTypeEquip().equals(TypeEquip.TWOHAND)) {
                        this.EquipRightHand = e;
                        this.EquipLeftHand = e;
                    }
                    if (e.getTypeEquip().equals(TypeEquip.HEAD)) {
                        this.EquipHead = e;
                    }
                    if (e.getTypeEquip().equals(TypeEquip.FOOT)) {
                        this.EquipFoot = e;
                    }
                    System.out.println(e.getName() + " equipado com sucesso!");
                    inventory.remove(i);
                    calculateTotalPower();
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("Digite um número!");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Equipamento Inválido!");
        } catch (ClassCastException ex) {
            System.out.println("Item Inválido");
        }
    }

    public void useItem() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escolha o item que deseja utilizar");
        int cont = 0;
        int resultVerify = verifyInventory();
        if (resultVerify == 0) {
            System.out.println("");
            System.out.println("Você não possui nenhum item no momento");
        } else {
            for (Treasure t : inventory) {
                if (t instanceof Item) {
                    System.out.println(cont + " - " + t);
                    cont++;
                }
                if (t instanceof Equipment) {
                    cont++;
                }
            }
            try {
                System.out.print("Opção escolhida: ");
                int escolha = Integer.parseInt(entrada.nextLine());
                for (int i = 0; i < inventory.size(); i++) {
                    if (i == escolha && inventory.get(i) instanceof Item) {
                        Item item = (Item) inventory.get(i);
                        this.level += 1;
                        inventory.remove(i);
                        System.out.println("Item utilizado com sucesso");
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("Digite um número!");
            } catch (ClassCastException ex) {
                System.out.println("Item Inválido");
            }
        }
    }

    public int verifyInventory() {
        int result = 0;
        for (Treasure t : inventory) {
            if (t instanceof Item) {
                result += 1;
            }
        }
        return result;
    }

    public void addTresure(Treasure t) {
        this.inventory.add(t);
    }

    public void setGold(int amount) {
        this.totalGold -= amount;
    }

    public void addGold(int amount) {
        this.totalGold += amount;
    }

    public void setLevel(int amount) {
        this.level -= amount;
    }

    public void addLevel(int amount) {
        this.level += amount;
    }

    public void setEquipHead() {
        this.EquipHead = null;
    }

    public void setEquipFoot() {
        this.EquipFoot = null;
    }

    public void setRaceBonus() {
        if (this.race.getTypeRace().equalsIgnoreCase("Demon")) {
            this.totalPower += 1;
        }
        if (this.race.getTypeRace().equalsIgnoreCase("Elf")) {
            this.level += 1;
        }
        if (this.race.getTypeRace().equalsIgnoreCase("Dwarf")) {
            this.totalGold += 500;
        }
    }

    @Override
    public String toString() {
        return "Nome = " + name + "\nNivel = " + level + "\nPoder Total = " + totalPower + "\nGold = " + totalGold + "\nRaça = " + race.toString() + "\nProfissão = " + job.toString()
                + "\n---- Equipamentos ---- \nMão Direita = " + EquipRightHand + "\nMão Esquerda = " + EquipLeftHand + "\nCabeça = " + EquipHead + "\nBota = " + EquipFoot;
    }

}

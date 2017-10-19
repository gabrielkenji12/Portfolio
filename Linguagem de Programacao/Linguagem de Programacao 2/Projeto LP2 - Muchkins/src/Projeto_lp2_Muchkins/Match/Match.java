/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_lp2_Muchkins.Match;

import Projeto_lp2_Muchkins.Character.Player;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 41528387
 */
public class Match implements Serializable {

    private Date date;
    private Player player;
    private int difficulty;
    private List<Round> rounds;
    private int roundNumber;
    private String password;

    public Match(Player player, int difficulty, String password) {
        this.player = player;
        this.date = new Date();
        this.difficulty = difficulty;
        this.rounds = new ArrayList<>();
        this.roundNumber = 1;
        this.password = password;
    }

    public Match() {
    }

    public void addRound(Round d) {
        this.rounds.add(d);
        this.roundNumber++;
    }

    public Date getDate() {
        return date;
    }

    public Player getPlayer() {
        return player;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public String getPassword() {
        return password;
    }

    
    public void setDate() {
        this.date = new Date();
    }
    
    
    

    public boolean loguin(String password) {
        if (this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Jogador = " + player.getName() + "\n    Ultimo acesso = " + date + "\n    dificuldade = " + difficulty + ", Rodadas = " + roundNumber;
    }

}

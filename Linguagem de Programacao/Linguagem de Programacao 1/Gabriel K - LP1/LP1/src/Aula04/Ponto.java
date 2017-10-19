/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula04;

/**
 *
 * @author 41528387
 */
public class Ponto {

    int x;
    int y;

    // Construtores nao sao metodos, por isso n tem retorno. Ele iniciliza o objeto
    public Ponto() {// Construtor
        x = 0;
        y = 0;
    }

    // Construtor. valores sao passados pelo Ponto p1 = new Ponto(4,2);
    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override // signfica sobescrever a implementação NESSA classe 
    public String toString() {
        return "(" + x + "," + y + ')';
    }
    /*
    //Exemplo estatico
    public static boolean igual(Ponto p1, Ponto p2) {
        return p1.x == p2.x && p1.y == p2.y;
        }
    */
     public boolean igual(Ponto p) { // so passa um parametro explicito, pq o outro vai na chamada do metodo
        return this.x == p.x && this.y == p.y;
        }
    
     public void transladar (int dx, int dy){
         this.x = this.x + dx;
         this.y = this.y + dy;
     }
     
     public double distancia(Ponto p){
         double c1 = this.x - p.x;
         double c2 = this.y - p.y;
         double d = Math.sqrt(c1*c1 + c2*c2);
         return d;
     }
     
    }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula04;

/**
 *
 * @author BadJapa
 */
public class Retangulo {

    int x;
    int y;
    double largura;
    double altura;

    public Retangulo() {
        this.x = 0;
        this.y = 0;
        this.largura = 1;
        this.altura = 1;
    }

    public Retangulo(int x, int y, double largura, double altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }
    
    public String toString() {
        return "x = " + x + " y = " + y + " largura = " + largura + " altura = " + altura; 
    }
    
    public double Area() {
        return (this.largura * this.altura);
    }

    public double Perimetro() {
        return ((2 * this.largura) + (2 * this.altura));
    }

    public boolean Interseccao(Retangulo r) {
        double xmax1 = this.x + this.largura;
        double xmax2 = r.x + r.largura;
        double xmax = Math.max(xmax1,xmax2);
        double xmin = Math.min(this.x, r.x);
        double ymax1 = this.y + this.altura;
        double ymax2 = r.y + r.altura;
        double ymax = Math.max(ymax1,ymax2);
        double ymin = Math.min(this.y, r.y);
        if ((xmax > xmin) && (ymax > ymin)) {
            return true;
        }
        return false;
        }

    public int getX() {
        return x;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab02;

/**
 *
 * @author 41528387
 */
public class Quarto {
    
    
    private TipoQuarto tipoquarto;
    private int nro;
    private int andar;

    public Quarto() {
    }
    
    

    public Quarto(int nro, int andar) {
        
        this.nro = nro;
        this.andar = andar;
    }

    public Quarto(TipoQuarto tipoquarto, int nro, int andar) {
        this.tipoquarto = tipoquarto;
        this.nro = nro;
        this.andar = andar;
    }
    
    

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public TipoQuarto getTipoquarto() {
        return tipoquarto;
    }

    public void setTipoquarto(TipoQuarto tipoquarto) {
        this.tipoquarto = tipoquarto;
    }
    
    
    @Override
    public String toString() {
        return "Quarto{" + "nro=" + nro + ", andar=" + andar + '}';
    }
    
    
    
}

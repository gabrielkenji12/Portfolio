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
public class TipoQuarto {
    
    public enumTipo tipo;
    private double preco;
    private String desc;
    private String foto;

    public TipoQuarto(enumTipo tipo, double preco, String desc, String foto) {
        this.tipo = tipo;
        this.preco = preco;
        this.desc = desc;
        this.foto = foto;
    }

   

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFoto() {
        return foto;
    }
   

    public void setFoto(String foto) {
        this.foto = foto;
    }

    
    
    
    
            
    
}

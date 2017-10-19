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
public class Geografico extends Endereco{
    
    private String logradouro;
    private String complemento;
    private String CEP;
    private String cidade;
    private String estado;
    private String pais;

    public Geografico(String logradouro, String complemento, String CEP, String cidade, String estado, String pais) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.CEP = CEP;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Geografico{" + "logradouro=" + logradouro + ", complemento=" + complemento + ", CEP=" + CEP + ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais + '}';
    }
    
    
    
    
}

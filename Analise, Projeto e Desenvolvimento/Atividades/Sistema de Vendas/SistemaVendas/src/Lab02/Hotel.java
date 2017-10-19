/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab02;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 41528387
 */
public class Hotel {
    
    private List<Quarto> quartos;
    private List<Endereco> enderecos;
    private String nome;
    private String cnpj;

    public Hotel(String nome, String cnpj) {
        enderecos = new ArrayList();
        quartos = new ArrayList();
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Quarto> getQuarto() {
        return quartos;
    }

    public void setQuarto(List<Quarto> quarto) {
        this.quartos = quarto;
    }

    public List<Endereco> getEndereco() {
        return enderecos;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.enderecos = endereco;
    }

    public void addQuarto(Quarto quarto) {
        quartos.add(quarto);
    }
    
    public void addEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }
    
    public void mostraQuartos(){
        for (Quarto q : quartos) {
            System.out.println("\n");
            System.out.println("Numero: " + q.getNro());
            System.out.println("Andar: " + q.getAndar());
            System.out.println("");
        }
    }
    
    public void mostraEndereco(){
        for (Endereco e : enderecos) {
            if(e instanceof Geografico){
                System.out.println("\n");
                System.out.println("Logradouro: " + ((Geografico) e).getLogradouro());
                System.out.println("Complemento: " + ((Geografico) e).getComplemento());
                System.out.println("CEP: "+ ((Geografico) e).getCEP());
                System.out.println("Cidade"+ ((Geografico) e).getCidade());
                System.out.println("Estado: " + ((Geografico) e).getEstado());
                System.out.println("Pais: "+ ((Geografico) e).getPais());
                System.out.println("");
            }
            if(e instanceof Telefonico){
                System.out.println("\n");
                System.out.println("DDD:" + ((Telefonico) e).getDDD());
                System.out.println("Numero:" + ((Telefonico) e).getNro());
                System.out.println("Tipo:" + ((Telefonico) e).getTipo());
                System.out.println("");
            }
            if(e instanceof Virtual){
                System.out.println("\n");
                System.out.println("Site: " + ((Virtual) e).getEmail());
                System.out.println("Email: " + ((Virtual) e).getEmail());
                System.out.println("");
            }
        }
    }
    
    @Override
    public String toString() {
        return "Hotel{" + "quartos=" + quartos + ", enderecos=" + enderecos + ", nome=" + nome + ", cnpj=" + cnpj + '}';
    }
    
    
    

   
    
    
    
    
}

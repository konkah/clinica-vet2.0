package model;

import java.util.ArrayList;
import java.util.List;
import view.AnimalTableModel;

/**
 *
 * @author Plinio Vilela
 */
public class Animal {
    private int id;
    private String nome,especie,tratamento;

    public void setEspecie(String especie){
        this.especie=especie;
    }
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setListaDeTratamentos(String listaDeTratamentos) {
        this.tratamento = listaDeTratamentos;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    private int anoNasc;
    private String sexo;
    private List<Tratamento> listaDeTratamentos;
    private Cliente cliente;

    public Animal(int id, String nome, int anoNasc, String sexo, Cliente cliente,String especie,String tratamento) {
        this.id = id;
        this.nome = nome;
        this.anoNasc = anoNasc;
        this.sexo = sexo;
        this.cliente = cliente;
        this.especie=especie;
        this.tratamento=tratamento;
       
    }
    
 
    
    public String getTratamentos(){
       

          return tratamento;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNasc() {
        return anoNasc;
    }

    public String getSexo() {
        return sexo;
    }
    
    public String getEspecie(){
        return especie;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public String toString() {
        return nome;
    }
}

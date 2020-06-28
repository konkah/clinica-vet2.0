package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Plinio Vilela
 */
public class Veterinario {
    private String nome,endereco,telefone,especialidade,crvm;
     ArrayList<String> especies = new ArrayList();
  
    
private int id;

    public Veterinario(int id, String nome, String endereco, String telefone, String especialidade, String crvm) {
    	this.id=id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.especialidade=especialidade;
        this.crvm=crvm;
    }

    public String getNome() {
    
        return nome;
    }
    
      public void setNome(String nome) {
        this.nome = nome;
    }
      
      
      
    
    public String getCrvm(){
        return crvm;
    }
    
    public void setCrvm(String crmv){
        this.crvm=crvm;
    }
    
    
      
     public void setEspecialidade(String especialidade)
     {
         this.especialidade=especialidade;
     }
     
     public String getEspecialidade(){
         return especialidade;
     }
     
     
     
     
      public ArrayList<String> getEspecies(){
          especies.add("Cão");
          especies.add("Gato");
          especies.add("Gato e Cão");
        return especies;
    }
      
      
      
     
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
      public String getEndereco() {
        return endereco;
    }
    

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
       public String getTelefone() {
        return telefone;
    }
    
       
       
       
public int getId() {
	return id;
}
  

 

   
    
}

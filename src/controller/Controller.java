package controller;

import java.util.List;

import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;
import model.ConsultaDAO;
import model.VeterinarioDAO;

public class Controller {
    
    public static void addCliente(String nome, String endereco,  String telefone, String cep){
        ClienteDAO.getInstance().addCliente(nome, endereco, telefone, cep);
    }
    
      public static void addAnimal(String nome, int anoNasc, String sexo, Cliente cliente,String especie){
        AnimalDAO.getInstance().addAnimal(nome, anoNasc, sexo, cliente,especie);
    }

      public static void addVeterinario(String nome, String cep, String telefone, String crvm,String especialidade){
     VeterinarioDAO.getInstance().addVeterinario(nome, cep, telefone, crvm, especialidade);
      }
      
     public static void addConsulta(String dataConsulta, String historico,Cliente IdCliente,Animal IdAnimal, String veterinario, String listaExames  ) {
         ConsultaDAO.getInstance().addConsulta(dataConsulta, historico, IdCliente, IdAnimal, veterinario, listaExames);
     }
    
    
    public List getAllClientes(){
        return ClienteDAO.getInstance().getAllClientes();
    }
    public List getAllVeterinarios(){
        return VeterinarioDAO.getInstance().getAllVeterinarios();
        
    }
   public List getAllAnimais(){
       return AnimalDAO.getInstance().getAllAnimais();
   } 
   public List getAllConsultas(){
       return ConsultaDAO.getInstance().getAllConsultas();
   }
   
    public static void getClienteById(int id){
         ClienteDAO.getInstance().getClienteById(id);
    }
    
    
     public static void getVeterinarioById(int id){
       VeterinarioDAO.getInstance().getVeterinarioById(id);
    }
     
     public static void getAnimailById(int id){
       AnimalDAO.getInstance().getAllAnimais();
    }
     public static void getConsultaById(int id){
ConsultaDAO.getInstance().getConsultaById(id);
    }
    
    
    public static void deleteCliente(Cliente cliente){
        ClienteDAO.getInstance().deleteCliente(cliente);
    }

	public static Animal getAnimalById(int idAnimal) {
		return AnimalDAO.getInstance().getAnimalById(idAnimal);
	}
}

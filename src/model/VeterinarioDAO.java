package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import model.DAO;
/**
 *
 * @author Plinio Vilela
 */
public class VeterinarioDAO extends DAO {
    private static VeterinarioDAO instance;
    private List<Veterinario> veterinarios;
    private int id;
    
    private VeterinarioDAO(){
        veterinarios = new ArrayList();
        id = 0;
    }
    
    // Singleton
    public static VeterinarioDAO getInstance(){
       if (instance == null) {
            instance = new VeterinarioDAO();
        }
        return instance;
    }
    private Veterinario buildObject(ResultSet rs) {
        Veterinario veterinario = null;
        try {
            // int id, String nome, String endereco, String telefone, String cep
            veterinario = new Veterinario(rs.getInt("id"), rs.getString("nome"), rs.getString("crvm"),rs.getString("telefone"),rs.getString("especialidade"),rs.getString(("crvm")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinario;
    }
    
// Partial CRUD    
     public String getCrmVetByTelefone(String telefone) {  
        String crm = null;
        Connection conn = null;
        Statement st=null;
        
        try{
            conn=DAO.getConnection();
            st=conn.createStatement();
          
            ResultSet rs=getResultSet("SELECT crvm from veterinario where telefone="+telefone);  
                crm = rs.getString(1);
               
           
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        return crm;
    }
     
    // Create
    public int addVeterinario(String nome, String cep, String telefone, String crvm,String especialidade){
        	Connection conn = null;
    
        		PreparedStatement st = null;
        		try {        			
        			conn = DAO.getConnection();
                         int newId = lastId("veterinario", "id") + 1;
                          st=conn.prepareStatement("INSERT INTO veterinario (id,nome,cep,telefone,crvm,especialidade) VALUES (?,?,?,?,?,?)");
        			 st.setInt(1, newId);
        			 st.setString(2, nome);
        			 st.setString(3, cep);
        			 st.setString(4, telefone);
                                 st.setString(5, crvm);
                                 st.setString(6, especialidade);
                             
        	            executeUpdate(st);
                            return newId;
                        }catch(Exception e){
                           e.printStackTrace();
                        }
        return -1;
    }

    // RetrieveAll
    public List getAllVeterinarios() {  
        Connection conn = null;
        Statement st=null;
        List<Veterinario> veterinarios = new ArrayList();
        
        try{
            conn=DAO.getConnection();
            st=conn.createStatement();
            ResultSet rs=getResultSet("Select * from veterinario");
            while(rs.next()){
                veterinarios.add(buildObject(rs));
            }
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        return veterinarios;
    }
    
     
      
      
  
      
      
 //RetrieveByID
 
    
    public void update(Veterinario veterinario) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE veterinario SET nome=?,  crvm=?, telefone=? WHERE id=?");
            stmt.setString(1, veterinario.getNome());
            stmt.setString(2, veterinario.getEndereco());
            stmt.setString(4, veterinario.getTelefone());
            stmt.setInt(5, veterinario.getId());
         // sfdghpksdfa
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    // Retrieve by ID
    public Veterinario getVeterinarioById(int id){
        Veterinario veterinario = null;
        ResultSet rs = getResultSet("SELECT * FROM veterinario WHERE id =" + id);
            
        try {
            if (rs.next()) {
                veterinario = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinario;
    }
    
    
    public Veterinario getVeterinarioByCrvm(String id){
        Veterinario veterinario = null;
        PreparedStatement stmt;
             
        
        
        ResultSet rs = getResultSet("SELECT * FROM veterinario WHERE crvm =" + id);
            
        try {
            if (rs.next()) {
                veterinario = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinario;
    }
        
       public Veterinario getVeterinarioByName(String nome){
        for(Veterinario veterinario : veterinarios){
            if(veterinario.getNome()==nome){
                return veterinario;
            }
        }
        return null;
    }
    // Updade


 
    // Delete   
    public void deleteVeterinarioById(Integer idVeterinario) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM veterinario WHERE id = ?");
            stmt.setInt(1, idVeterinario);
            System.out.println(stmt.toString());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteVeterinario(Veterinario veterinario){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("DELETE FROM `clinicaveterinaria`.`veterinario` WHERE id=?");
            stmt.setInt(5, veterinario.getId());
          
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Veterinario> getVeterinariosByEspecialidade(String especie) {
        List<Veterinario> veterinarios = new ArrayList<Veterinario>();
        PreparedStatement stmt;
             
        ResultSet rs = getResultSet("SELECT * FROM veterinario WHERE especialidade like '%" + especie + "%'");
            
        try {
            while (rs.next()) {
                veterinarios.add(buildObject(rs));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinarios;
    }

    

  
    
}

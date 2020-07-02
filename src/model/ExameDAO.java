
package model;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Observable;
import java.util.logging.Logger;




public class ExameDAO extends DAO{
 private static ExameDAO instance;

 private int id;

 private ExameDAO(){
     DAO.getConnection();
 }
 
 //Singleton
 public static ExameDAO getInstance(){
 if (instance == null) {
 instance = new ExameDAO();
 }
 return instance;
 }
 
 
// Partial CRUD
 //Create
 public Integer addExame(String descricao, Consulta consulta) {
try{
    Connection conn =null;
    PreparedStatement st=null;
    conn=DAO.getConnection();
    int newId=lastId("exame","id")+1;
    
    st=conn.prepareStatement("INSERT INTO exame (id, descricao, consulta_id) VALUES (?,?,?)");
    st.setInt(1, newId);
    st.setString(2,descricao);
    st.setInt(3,consulta.getId());   
    executeUpdate(st);
    
    return newId;
    
}catch(SQLException e){
    Logger.getLogger(e.getMessage());
    
}
 return -1;
 
 }

  private Exame buildObject(ResultSet rs) {
        Exame exame = null;
        try {
            // int id, String nome, String endereco, String telefone, String cep
            Consulta consulta = ConsultaDAO.getInstance().getConsultaById(rs.getInt("consulta_id"));
            exame = new Exame(
                    rs.getInt("id"), 
                    rs.getString("descricao"), 
                    consulta
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exame;
    }

 //RetrieveAll
 public List<Exame> getAllExames() {
     Connection conn = null;
     Statement st=null; 
     
    List<Exame> exames = new ArrayList<>();
    try{
        conn=DAO.getConnection();
        st=conn.createStatement();
        ResultSet rs=getResultSet("Select * from exame");
        while(rs.next()){
            exames.add(buildObject(rs));
        }
        rs.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
return exames;
 }
 
 public List<Exame> getExamesByConsulta(int consulta_id) {
     Connection conn = null;
     Statement st=null; 
     
    List<Exame> exames = new ArrayList<>();
    try{
        conn=DAO.getConnection();
        st=conn.createStatement();
        ResultSet rs=getResultSet("Select * from exame where consulta_id="+consulta_id);
        while(rs.next()){
            exames.add(buildObject(rs));
        }
        rs.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
return exames;
 }
 
 //RetrieveByID
 public Exame getExameById(int id){
     Exame exame = null;
     ResultSet rs=getResultSet("select * from exame where id ="+id);
     try{
         if(rs.next()){
             exame=buildObject(rs);  
         }
         rs.close();
     }catch(SQLException e){
         e.printStackTrace();
     } 
     return exame;
 }
 //Update
 public void update(Exame exame) {
     try {
         PreparedStatement stmt;
         stmt = DAO.getConnection().prepareStatement("UPDATE exame SET descricao=? WHERE id=?");
         
         stmt.setString(1, exame.getDescricao());
         stmt.setInt(2, exame.getId());
       
         executeUpdate(stmt);
         stmt.close();
     } catch (SQLException ex) {
         ex.printStackTrace();
     }
 }
 
 //Delete
 public void deleteExameById(Integer idExame) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM exame WHERE id = ?");
            stmt.setInt(1, idExame);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}


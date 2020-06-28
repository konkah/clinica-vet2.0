
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




public class ConsultaDAO extends DAO{
 private static ConsultaDAO instance;

 private int id;

 private ConsultaDAO(){
     DAO.getConnection();
 }
 
 //Singleton
 public static ConsultaDAO getInstance(){
 if (instance == null) {
 instance = new ConsultaDAO();
 }
 return instance;
 }
 
 
// Partial CRUD
 //Create
 public Integer addConsulta(String dataConsulta, String historico,Cliente IdCliente,Animal IdAnimal, String veterinario, String listaExames  ) {
try{
    Connection conn =null;
    PreparedStatement st=null;
    conn=DAO.getConnection();
    int newId=lastId("consulta","id")+1;
    
    st=conn.prepareStatement("INSERT INTO consulta (id, dataConsulta,historico,IdCliente,IdAnimal, crvm, listaExames) VALUES (?,?,?,?,?,?,?)");
    st.setInt(1, newId);
    st.setString(2,dataConsulta);
    st.setString(3,historico);
    st.setInt(4, IdCliente.getId());
    st.setInt(5, IdAnimal.getId());
    
    
    st.setString(6,veterinario);
    st.setString(7, listaExames);
    
    executeUpdate(st);
    
    return newId;
    
}catch(SQLException e){
    Logger.getLogger(historico);
    
}
 return -1;
 
 }

  private Consulta buildObject(ResultSet rs) {
        Consulta consulta = null;
        try {
            // int id, String nome, String endereco, String telefone, String cep
            Cliente IdCliente = ClienteDAO.getInstance().getClienteById(rs.getInt("IdCliente"));
            Animal IdAnimal = AnimalDAO.getInstance().getAnimalById(rs.getInt("IdAnimal"));
            Veterinario veterinario = VeterinarioDAO.getInstance().getVeterinarioByCrvm(rs.getString("crvm"));
            consulta = new Consulta(
                    rs.getInt("id"), 
                    rs.getString("dataConsulta"), 
                    rs.getString("historico"), 
                    IdCliente, 
                    IdAnimal,
                    veterinario,
                    rs.getString("listaExames"),
                    Consulta.Realizada.get(rs.getInt("realiza"))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consulta;
    }

 //RetrieveAll
 public List<Consulta> getAllConsultas() {
     Connection conn = null;
     Statement st=null; 
     
    List<Consulta> consultas = new ArrayList<>();
    try{
        conn=DAO.getConnection();
        st=conn.createStatement();
        ResultSet rs=getResultSet("Select * from consulta where realiza>=1");
        while(rs.next()){
            consultas.add(buildObject(rs));
        }
        rs.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
return consultas;
 }
 
 
 public Consulta getNomeByCrvm(){
     Consulta consulta = null;
     ResultSet rs=getResultSet("select nome from veterinario where crmv ="+consulta.getCRVM());
     try{
         if(rs.next()){
             consulta=buildObject(rs);  
         }
         rs.close();
     }catch(SQLException e){
         e.printStackTrace();
     } 
     return consulta;
 }
 
 //RetrieveByID
 public Consulta getConsultaById(int id){
     Consulta consulta = null;
     ResultSet rs=getResultSet("select * from consulta where id ="+id);
     try{
         if(rs.next()){
             consulta=buildObject(rs);  
         }
         rs.close();
     }catch(SQLException e){
         e.printStackTrace();
     } 
     return consulta;
 }
 //Update
 public void update(Consulta consulta) {
     try {
         PreparedStatement stmt;
         stmt = DAO.getConnection().prepareStatement("UPDATE consulta SET dataConsulta=?, historico=?, IdCliente=?, IdAnimal=?, crvm=?, listaExames=?, realiza=? WHERE id=?");
         
         stmt.setString(1, consulta.getData());
         stmt.setString(2, consulta.getHistorico());
         stmt.setInt(3, consulta.getIdCliente().getId());
         stmt.setInt(4, consulta.getIdAnimal().getId());
         stmt.setInt(5, Integer.parseInt(consulta.getCRVM()));
         stmt.setString(6, consulta.getListaDeExames());
         stmt.setInt(7, consulta.getRealizada().getCodigo());
         stmt.setInt(8, consulta.getId());
       
         executeUpdate(stmt);
         stmt.close();
     } catch (SQLException ex) {
         ex.printStackTrace();
     }
 }
 // arquivo
 
 public void ImprimirValores(String mesagem) throws IOException{
     File arquivo = new File( "C:\\Users\\User PC\\Documents\\pagamento.txt" );
     boolean existe = arquivo.exists();
     if(existe){
       arquivo.createNewFile();
      }
     FileWriter fw = new FileWriter( arquivo );
     BufferedWriter bw = new BufferedWriter( fw );

        bw.write(mesagem);
        bw.close();
fw.close();

        

 }
 
 
 
 //Delete
 public void deleteConsultaById(Integer idConsulta) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM consulta WHERE id = ?");
            stmt.setInt(1, idConsulta);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void finalizar(Consulta consulta) {
        consulta.setRealizada(Consulta.Realizada.Finalizada);
        update(consulta);
    }
}


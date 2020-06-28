package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import model.DAO;


public class ClienteDAO extends DAO {

    private static ClienteDAO instance;

    private ClienteDAO() {
        DAO.getConnection();
    }

    // Singleton
    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

// Partial CRUD    
    // Create
    public int addCliente(String nome, String endereco,  String telefone, String cep) {
        		Connection conn = null;
    
        		PreparedStatement st = null;
        		try {        			
        			conn = DAO.getConnection();
     
        			 int newId = lastId("cliente", "id") + 1;

        			 st=conn.prepareStatement("INSERT INTO cliente (id,nome,endereco,cep,telefone) VALUES (?,?,?,?,?)");
        			 st.setInt(1, newId);
        			 st.setString(2, nome);
        			 st.setString(3, endereco);
        			 st.setString(4, cep);
  
        			 st.setString(5, telefone);
        	            executeUpdate(st);
                            return newId;
        		}
        	            
        	            catch(SQLException e) {
        			 Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        			
        		}
        		return  -1;
        	}
        	
        	
          

    private Cliente buildObject(ResultSet rs) {
        Cliente cliente = null;
        try {
            // int id, String nome, String endereco, String telefone, String cep
            cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("cep"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }


    // RetrieveAll
    public List getAllClientes() {
    	Connection conn = null;
		Statement st = null;
                  List<Cliente> clientes = new ArrayList();	
        try {
        	conn = DAO.getConnection();
        	st = conn.createStatement();
        	  ResultSet rs = getResultSet("SELECT * FROM cliente");
            while (rs.next()) {
    			 clientes.add(buildObject(rs));	
            }
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
          return clientes;
    }

    // RetrieveById
    // Os grupos devem implementar as modificacoes para permitir que um cliente seja
    // encontrado a partir de um id (inteiro).
    // Sugestao, ao inves de usar um List, usar um Map.
    public Cliente getClienteById(int id) {
        Cliente cliente = null;
        ResultSet rs = getResultSet("SELECT * FROM cliente WHERE id = " + id);
        try {
            if (rs.next()) {
                cliente = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

     public Cliente getNomeClinete(int id) {
        Cliente cliente = null;
        ResultSet rs = getResultSet("SELECT nome FROM cliente WHERE id = " + id);
        try {
            if (rs.next()) {
                cliente = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
    
    // RetrieveByName
    // Updade
    public void update(Cliente cliente) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE cliente SET nome=?, endereco=?, cep=?, telefone=? WHERE id=?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getCep());
            stmt.setString(4, cliente.getTelefone());
            stmt.setInt(5, cliente.getId());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        // Delete   
    public void deleteCliente(Cliente cliente) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM cliente WHERE id= ?");
            stmt.setInt(1, cliente.getId());
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteClienteById(Integer idCliente) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM cliente WHERE id = ?");
            stmt.setInt(1, idCliente);
            System.out.println(stmt.toString());
            executeUpdate(stmt);
            System.out.println("passei aqui");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

   

}

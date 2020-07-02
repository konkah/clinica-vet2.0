package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Animal;
import model.Cliente;
import model.ClienteDAO;
import model.DAO;

/**
 *
 * @author Plinio Vilela
 */
public class AnimalDAO extends DAO {

    private static AnimalDAO instance;

    private AnimalDAO() {
        DAO.getConnection();
    }

    // Singleton
    public static AnimalDAO getInstance() {
        if (instance == null) {
            instance = new AnimalDAO();
        }
        return instance;
    }

// Partial CRUD    
    // Create
    public Integer addAnimal(String nome, int anoNasc, String sexo, Cliente cliente,String especie) {
        try {
            PreparedStatement stmt;
            int newId = lastId("animal", "id") + 1;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO animal (id,nome,anoNasc,sexo,cliente_id,especie) VALUES (?,?,?,?,?,?)");
            stmt.setInt(1, newId);
            stmt.setString(2, nome);
            stmt.setInt(3, anoNasc);
            stmt.setString(4, sexo);
            stmt.setInt(5, cliente.getId());
            stmt.setString(6, especie);
            
            executeUpdate(stmt);
            
            return newId;
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }

    private Animal buildObject(ResultSet rs) {
        Animal animal = null;
        try {
            // int id, String nome, String endereco, String telefone, String cep
            Cliente cliente = ClienteDAO.getInstance().getClienteById(rs.getInt("cliente_id"));
            animal = new Animal(rs.getInt("id"), rs.getString("nome"), rs.getInt("anoNasc"), rs.getString("sexo"), cliente, rs.getString("especie"),rs.getString("tratamento"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    // RetrieveAll
    public List<Animal> getAllAnimais() {
        List<Animal> animais = new ArrayList<Animal>();
        ResultSet rs = getResultSet("SELECT * FROM animal");
        try {
            while (rs.next()) {
                animais.add(buildObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animais;
    }
    
    
     public Animal getAnimalById(int id) {
        Animal animal = null;
        ResultSet rs = getResultSet("SELECT * FROM animal WHERE id = " + id);
        try {
            if (rs.next()) {
                animal = buildObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    
    // RetrieveById
    // Os grupos devem implementar as modificacoes para permitir que um animal seja
    // encontrado a partir de um id (inteiro).
    // Sugestao, ao inves de usar um List, usar um Map.
    public List<Animal> getAnimalByCliente(Cliente cliente) {
        List<Animal> animais = new ArrayList<Animal>();
        int id = cliente.getId();
        
        ResultSet rs = getResultSet("SELECT * FROM animal WHERE cliente_id = " + id);
        try {
            while (rs.next()) {
                animais.add(buildObject(rs));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animais;
    }

    // RetrieveByName
    // Updade
    public void update(Animal animal) {
        try {
            PreparedStatement stmt;
           
            stmt = DAO.getConnection().prepareStatement("UPDATE animal SET nome=?, anoNasc=?, sexo=?, cliente_id=?, especie=?, tratamento=? WHERE id=?");
            stmt.setString(1, animal.getNome());
            stmt.setInt(2, animal.getAnoNasc());
            stmt.setString(3, animal.getSexo());
            stmt.setInt(4, animal.getCliente().getId());
            stmt.setString(5,animal.getEspecie());
            stmt.setString(6,animal.getTratamentos());
            
        
             stmt.setInt(7, animal.getId());
             
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        // Delete   
    public void deleteAnimalById(Integer idAnimal) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM animal WHERE id = ?");
            stmt.setInt(1, idAnimal);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}

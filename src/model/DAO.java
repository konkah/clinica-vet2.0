package model;

//Implementacao do DAO para JavaDB

import java.sql.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public abstract class DAO {

    public static final String DBURL = "jdbc:mysql://localhost:3306/VetDB";
    static String path = "/home/karlos/Documents/Unicamp/2020 - 1º Semestre/POO I/ProjetoPOOA - V14 Nikolas/ProjetoPOOAv15 Karlos/imagens/";
    
    public static String getImage(String name) {
        return path + name + ".PNG";
    }
        
    private static Connection con;
	private static Connection conn =null;
    // metodo para criar a conexao com JavaDB
    public static Connection getConnection() {
        if (con == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                con = DriverManager.getConnection(url, props);
            }
            catch (Exception e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
        return con;
    }

    protected ResultSet getResultSet(String query) {
        Statement s;
        ResultSet rs = null;
        try {
            s = (Statement) con.createStatement();
            s.executeQuery(query);
            rs = s.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }

    protected int lastId(String tableName, String primaryKey) {
        Statement s;
        ResultSet rs = null;
        int lastId=-1;
        try {
            s = (Statement)con.createStatement();
            s.executeQuery("SELECT MAX(" + primaryKey + ") AS id FROM " + tableName);
            
            rs = s.getResultSet();
            if (rs.next()) {
                lastId = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastId;
    }
    
    
    private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")){
                  
		Properties props = new Properties();
		props.load(fs);
		return props;
		}
		catch (IOException e) {
			 e.printStackTrace();
		}
		return null;
	}


    public static void terminar() {
        try {
            (DAO.getConnection()).close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
package entidade.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lhries
 */
public class ConnectionFactory {
    private final static String DRIVER = "org.postgresql.Driver";
    private final static String URL = "jdbc:postgresql://localhost:5432/farmacia";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "1234";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return conexao;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

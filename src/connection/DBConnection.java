package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* Classe che effettua la connessione al nostro server MySql e ritorna una variabile di tipo Conneciton
* 
*/
public class DBConnection {
    
    private static DBConnection instance;
    
    private DBConnection(){
    }
    
    /**
     * Assicura che la classe sia singleton.
     * Se la classe non è ancora stata istanziata, il metodo crea l'istanza e la restituisce.
     * Se invece l'istanza è gia stata creata, la restituisce semplicemente.
     * 
     */
    public static synchronized DBConnection getInstance(){
    
        if(instance == null){ 
            instance = new DBConnection(); }
        return instance;
    }
    
    /**
     * Effettua effetivamente la connessione usando il driver jdbc mysql al nostro database
     * @throws Exception 
     */
    public Connection connect() throws Exception{
        
        Connection connessione = null;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException cnfe){
            
            System.out.println("Connection Failed"+ cnfe);
        }
        
        try {
            connessione = (Connection) DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7114898","sql7114898","RC4ZIQMDHd");
            System.out.println("Database Connected");
        } catch (SQLException ex) {
            System.out.println("Impossible to connect to the DB");
            throw new Exception();
        }
            
        return connessione;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import main.Controller;

/**
 *
 * @author Te4o
 */
public class Insert {
    
    public static Controller controller = Controller.getInstance();
    
    public static void nuovoCliente(String nome, String cognome, int eta, String sesso) throws SQLException{

        String query = "INSERT INTO CLIENTI VALUES (?, ?, ?, ?);";

        PreparedStatement statement = controller.connection.prepareStatement(query);
        statement.clearParameters();
        statement.setString(1, cognome);
        statement.setString(2, nome);
        statement.setString(3, sesso);
        statement.setInt(4, eta);

        statement.execute();
        
    }
    
}

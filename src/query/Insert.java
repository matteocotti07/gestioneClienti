/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import cliente.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import main.Controller;
import visita.Visita;

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
    
    public static void nuovaVisita(Visita visita) throws SQLException{

        String query = "INSERT INTO VISITE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement statement = controller.connection.prepareStatement(query);
        statement.clearParameters();
        statement.setInt(1, visita.getnVisita());
        statement.setString(2, visita.getDataVisita());
        statement.setString(3, visita.getCliente().getNome());
        statement.setString(4, visita.getCliente().getCognome());
        statement.setString(5, visita.getCliente().getSesso());
        statement.setInt(6, visita.getCliente().getEta());
        statement.setInt(7, visita.getAltezza());
        statement.setFloat(8, visita.getPeso());
        statement.setInt(9, visita.getBraccio());
        statement.setInt(10, visita.getTorace());
        statement.setInt(11, visita.getOmbelico());
        statement.setInt(12, visita.getCoscia());
        statement.setInt(13, visita.getPlica1());
        statement.setInt(14, visita.getPlica2());
        statement.setInt(15, visita.getPlica3());        
        statement.setFloat(16, visita.getGrasso());

        statement.execute();
        
    }
    
    public static void updateEtaCliente(Cliente cliente, int eta) throws SQLException{

        String query = "UPDATE CLIENTI SET ETA = ? WHERE NOME = ? AND COGNOME = ?";

        PreparedStatement statement = controller.connection.prepareStatement(query);
        statement.clearParameters();
        statement.setInt(1, eta);
        statement.setString(2, cliente.getNome());
        statement.setString(3, cliente.getCognome());

        statement.execute();
        
    }
    
}

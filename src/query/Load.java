/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import utils.Ordina;
import cliente.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.Controller;
import visita.Visita;

/**
 *
 * @author Te4o
 */
public class Load {
    
    public static Controller controller = Controller.getInstance();
    
    public static void clienti() throws SQLException{

        String query = "SELECT * FROM CLIENTI";

        PreparedStatement statement = controller.connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        
        controller.clienti.clear();
                    
        while(result.next()){
            
            String cognome = result.getString("COGNOME");
            String nome = result.getString("NOME");
            String sesso = result.getString("SESSO");
            int eta = result.getInt("ETA");
            
            Cliente cliente = new Cliente(nome, cognome, sesso, eta);
            controller.clienti.add(cliente);
        }  
        Ordina.clientiAlfabetico();
    }
    
    public static void visite() throws SQLException{

        String query = "SELECT * FROM VISITE";

        PreparedStatement statement = controller.connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        
        controller.visite.clear();
                    
        while(result.next()){
            
            int nVisita = result.getInt("NUMERO_VISITA");
            String dataVisita = result.getString("DATA_VISITA");
            String cognome = result.getString("COGNOME");
            String nome = result.getString("NOME");
            String sesso = result.getString("SESSO");
            int eta = result.getInt("ETA");
            int altezza = result.getInt("ALTEZZA");
            int peso = result.getInt("PESO");
            int braccio = result.getInt("BRACCIO");
            int torace = result.getInt("TORACE");
            int ombelico = result.getInt("OMBELICO");
            int coscia = result.getInt("COSCIA");
            int plica1 = result.getInt("PLICA1");
            int plica2 = result.getInt("PLICA2");
            int plica3 = result.getInt("PLICA3");
            int grasso = result.getInt("GRASSO");
            
            Cliente cliente = new Cliente(nome, cognome, sesso, eta);
            Visita visita = new Visita(cliente, altezza, peso, braccio, torace, ombelico, coscia, plica1, plica2, plica3, grasso, nVisita, dataVisita);
            controller.visite.add(visita);
        }  
    }
    
    public static Cliente clienteByCognomeNome(String cognome, String nome) throws SQLException{
        Cliente cliente = null;
        
        String query = "SELECT * FROM CLIENTI WHERE COGNOME = ? AND NOME = ?";

        PreparedStatement statement = controller.connection.prepareStatement(query);
        statement.setString(1, cognome);
        statement.setString(2, nome);
        ResultSet result = statement.executeQuery();
        
        if(result.next()){
            
            String cognome1 = result.getString("COGNOME");
            String nome1 = result.getString("NOME");
            String sesso = result.getString("SESSO");
            int eta = result.getInt("ETA");
            
            cliente = new Cliente(nome1, cognome1, sesso, eta);
        }  
        return cliente;
    }
    
}

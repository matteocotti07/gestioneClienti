/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import connection.DBConnection;
import java.sql.Connection;

/**
 *
 * @author te4o
 */
public class Controller {
    
    private static Controller instance;  
    public Connection connection;
    public boolean erroreConnessione = false;
    
    private Controller(){
        try {
            DBConnection DBconnection = DBConnection.getInstance();
            connection = DBconnection.connect();
        } catch (Exception ex) {
            erroreConnessione = true;
        }
    }
    
    /**
     * Assicura che la classe sia singleton.
     * Se la classe non è ancora stata istanziata, il metodo crea l'istanza e la restituisce.
     * Se invece l'istanza è gia stata creata, la restituisce semplicemente.
     * 
     */
    public static synchronized Controller getInstance(){
    
        if(instance == null){ 
            instance = new Controller(); }
        return instance;
    }
  
}
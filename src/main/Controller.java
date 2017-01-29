/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import cliente.Cliente;
import connection.DBConnection;
import java.sql.Connection;
import java.util.ArrayList;
import visita.Visita;

/**
 *
 * @author te4o
 */
public class Controller {
    
    private static Controller instance;  
    public Connection connection;
    public boolean erroreConnessione = false;
    
    public ArrayList<Cliente> clienti = new ArrayList<>();
    public ArrayList<Visita> visite = new ArrayList<>();
    
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
  
    public Visita visitaPrecendete(Cliente cliente){
        Visita visitaPrecedente = new Visita(cliente, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "");
        ArrayList<Visita> visitePrecedenti = new ArrayList<>();
        
        for (Visita visita : visite) {
            if (visita.getCliente().getCognome().equalsIgnoreCase(cliente.getCognome()) &&
                    visita.getCliente().getNome().equalsIgnoreCase(cliente.getNome())) {
                visitePrecedenti.add(visita);
            }
        }
        for (int i = 0; i < visitePrecedenti.size(); i++) {
            if (visitePrecedenti.get(i).getnVisita() > visitaPrecedente.getnVisita()) {
                visitaPrecedente = visitePrecedenti.get(i);
            }
        }
        return visitaPrecedente;
    }
}
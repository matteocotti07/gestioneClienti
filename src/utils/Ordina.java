/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import cliente.Cliente;
import java.util.Collections;
import main.Controller;

/**
 *
 * @author Te4o
 */
public class Ordina {
    
    public static Controller controller = Controller.getInstance();
    
    public static void clientiAlfabetico(){
        Collections.sort(controller.clienti, (Cliente c1, Cliente c2) -> c1.getCognome().toLowerCase().compareTo(c2.getCognome().toLowerCase()));
    }
    
}

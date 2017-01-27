package main;

import grafica.Grafica;
import javax.swing.JOptionPane;

public class Start {
	
    public static void main(String[] args) {

        Controller controller = Controller.getInstance();
        Grafica grafica = new Grafica();

        if(controller.erroreConnessione){
           JOptionPane.showMessageDialog(null, "Verificare la propria connessione internet e riavviare l'applicazione", "Errore di rete", JOptionPane.ERROR_MESSAGE);
           grafica.chiudi();
        }

    }
        
}

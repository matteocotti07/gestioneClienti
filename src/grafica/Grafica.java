/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafica;

import frame.MainFrame;
import java.awt.CardLayout;
import java.awt.Point;
import javax.swing.JPanel;
import panel.HomePanel;

/**
 *
 * @author te4o
 */
public class Grafica {
    
    //dichiarazione oggetti
    public static CardLayout card;
    public static JPanel container;
    public static MainFrame mainFrame;
    
    public Grafica(){
        
        //inizializzazione oggetti
        mainFrame  = new MainFrame("Gestione Clienti");
        card = new CardLayout();
        container = new JPanel();
        HomePanel home = new HomePanel();
        
        container.setLayout(card);
        container.add(home,"home");
        card.show(container, "home");
        
        mainFrame.add(container);
        mainFrame.setVisible(true);
        
    }
    
    public void chiudi(){
    
        mainFrame.setVisible(false);
        mainFrame.dispose();
    }
    
}
package panel;

import cliente.Cliente;
import grafica.Grafica;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.Controller;
import query.Load;

public class HomePanel extends JPanel{
    
    public static Controller controller = Controller.getInstance();
    
    private void loadData (){
    
        try {
            controller.clienti.clear(); controller.visite.clear();
            Load.clienti(); Load.visite();
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento dei dati dal database");
        }

    }
    
    public HomePanel (){
        loadData();
        
	setLayout(new GridLayout(2, 1, 0, 0));
        
        JPanel titlePanel = new JPanel();
        JPanel mainPanel = new JPanel(new GridLayout(1, 3, 100, 0));
        JPanel nuovoPanel = new JPanel(new GridLayout(3, 1, 0, 0));
        JPanel visualizzaPanel = new JPanel(new GridLayout(4, 1, 0, 0));
        JPanel azioniPanel = new JPanel(new GridLayout(2, 1, 0, 0));
        
        JButton nuovoClienteButton = new JButton("CLIENTE");
        JButton nuovaVisitaButton = new JButton("VISITA");
        JButton visualizzaAttualiButton = new JButton("ATTUALI");
        JButton visualizzaStoricoButton = new JButton("STORICO");
        JButton visualizzaTotaleButton = new JButton("TOTALE");
        JButton progressiButton = new JButton("PROGRESSI");
        
        nuovoClienteButton.addActionListener((ActionEvent e) -> {
            NuovoClientePanel ncp = new NuovoClientePanel();
            Grafica.container.add(ncp, "nuovoCliente");
            Grafica.card.show(Grafica.container, "nuovoCliente");
        });
        
        nuovaVisitaButton.addActionListener((ActionEvent e) -> {
            loadData();
            
            String[] clienti = new String[controller.clienti.size()];
            for (int i = 0; i < controller.clienti.size(); i++) {
                clienti[i] = controller.clienti.get(i).getCognome().toUpperCase()+" "+controller.clienti.get(i).getNome();
            }
            String clienteSel = (String) JOptionPane.showInputDialog(null,"Seleziona un cliente","Nuova visita",JOptionPane.QUESTION_MESSAGE,null,clienti,clienti[0]);
            try {
                String[] nomeCognome = clienteSel.split(" ");
                Cliente cliente = Load.clienteByCognomeNome(nomeCognome[0].substring(0, 1) + nomeCognome[0].substring(1).toLowerCase(), nomeCognome[1]);
                NuovaVisitaPanel nvp = new NuovaVisitaPanel(cliente);
                Grafica.container.add(nvp, "nuovaVisita");
                Grafica.card.show(Grafica.container, "nuovaVisita");
            } catch (SQLException ex) {
                System.out.println("Errore durante il caricamento dei dati dal database");
            }           
        });
        
        JLabel titleLabel = new JLabel("GESTIONE CLIENTI"); titleLabel.setFont(new Font("Century Gothic", Font.BOLD, 50)); 
        JLabel nuovoLabel = new JLabel("NUOVO"); nuovoLabel.setFont(new Font("Century Gothic", Font.BOLD, 30)); nuovoLabel.setHorizontalAlignment(JLabel.CENTER); nuovoLabel.setVerticalAlignment(JLabel.TOP);
        JLabel visualizzaLabel = new JLabel("VISUALIZZA"); visualizzaLabel.setFont(new Font("Century Gothic", Font.BOLD, 30)); visualizzaLabel.setHorizontalAlignment(JLabel.CENTER); visualizzaLabel.setVerticalAlignment(JLabel.TOP);
        JLabel azioniLabel = new JLabel("AZIONI"); azioniLabel.setFont(new Font("Century Gothic", Font.BOLD, 30)); azioniLabel.setHorizontalAlignment(JLabel.CENTER); azioniLabel.setVerticalAlignment(JLabel.TOP);
        
        titlePanel.add(titleLabel);
        
        nuovoPanel.add(nuovoLabel);
        nuovoPanel.add(nuovoClienteButton);
        nuovoPanel.add(nuovaVisitaButton);
        
        visualizzaPanel.add(visualizzaLabel);
        visualizzaPanel.add(visualizzaAttualiButton);
        visualizzaPanel.add(visualizzaStoricoButton);
        visualizzaPanel.add(visualizzaTotaleButton);
        
        azioniPanel.add(azioniLabel);
        azioniPanel.add(progressiButton);
        
        mainPanel.add(nuovoPanel);
        mainPanel.add(visualizzaPanel);
        mainPanel.add(azioniPanel);
        
        add(titlePanel);
        add(mainPanel);
              
        javax.swing.border.Border padding = BorderFactory.createEmptyBorder(250, 200, 250, 200);
        setBorder(padding);
    }

}

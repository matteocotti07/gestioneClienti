package panel;

import grafica.Grafica;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel{
    
    public HomePanel (){
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
            NuovaVisitaPanel nvp = new NuovaVisitaPanel();
            Grafica.container.add(nvp, "nuovaVisita");
            Grafica.card.show(Grafica.container, "nuovaVisita");
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

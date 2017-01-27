/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import grafica.Grafica;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import query.Insert;

/**
 *
 * @author te4o
 */
public class NuovaVisitaPanel extends JPanel{
    
    private String[] sessi = {"M", "S"};
    private String[] giorni = new String[31];
    private String[] mesi = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    private String[] anni = new String[119];
    
    public  NuovaVisitaPanel (){
        riempiGiorni(); riempiAnni();
        
        setLayout(new GridLayout(3, 1, 0, 0));
        
        JPanel titlePanel = new JPanel();
        JPanel mainPanel = new JPanel();
        JPanel dataPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        JPanel submitPanel = new JPanel();
        
        JLabel titleLabel = new JLabel("NUOVO CLIENTE"); titleLabel.setFont(new Font("Century Gothic", Font.BOLD, 50)); 
        
        JTextField nome = new JTextField(); nome.setPreferredSize(new Dimension(150, 25));
        JTextField cognome = new JTextField(); cognome.setPreferredSize(new Dimension(150, 25));
        JComboBox sesso = new JComboBox(sessi);
        JComboBox giorno = new JComboBox(giorni);
        JComboBox mese = new JComboBox(mesi);
        JComboBox anno = new JComboBox(anni);
        
        setComboTitle(giorno, "giorno"); setComboTitle(anno, "anno");
        
        JButton annulla = new JButton("ANNULLA");
        JButton salva = new JButton("SALVA");
        
        annulla.addActionListener((ActionEvent e) -> {
            Grafica.card.show(Grafica.container, "home");
        });
        
        salva.addActionListener((ActionEvent e) -> {
            try {
                Insert.nuovoCliente(cognome.getText(), nome.getText(), calcolaEta(giorno.getSelectedItem().toString(),
                        mese.getSelectedItem().toString(), anno.getSelectedItem().toString()), sesso.getSelectedItem().toString());
                } catch (SQLException ex) {
                    System.out.println("Errore dutante il salvataggio di un nuovo cliente");
                } catch (ParseException ex) {
                    System.out.println("Errore dutante il calcolo dell'eta' del cliente");
            }
        });
        
        
        titlePanel.add(titleLabel);
        
        dataPanel.add(giorno);
        dataPanel.add(mese);
        dataPanel.add(anno);
        
        mainPanel.add(nome);
        mainPanel.add(cognome);
        mainPanel.add(sesso);
        mainPanel.add(dataPanel);
        
        submitPanel.add(annulla);
        submitPanel.add(salva);
        
        add(titlePanel);
        add(mainPanel);
        add(submitPanel);
              
        javax.swing.border.Border padding = BorderFactory.createEmptyBorder(220, 200, 220, 200);
        setBorder(padding);
    }
    
    private void riempiGiorni (){
        String numeroGiorno = "";

        for (int i = 0; i < 31; i++) {
            numeroGiorno = (i<10 ? "0"+(i+1) : ""+(i+1));
            giorni[i] = numeroGiorno;
        }          
    }
    
    private void riempiAnni(){
        
        for (int i = 2018; i >= 1900; i--) {
            anni[2018-i] = ""+i;
        }  
    }
    
    private void setComboTitle(JComboBox combo, String title){
    
        combo.setEditable(true);
        combo.setSelectedItem(title);
        combo.setEditable(false);
    }
    
    private int calcolaEta(String giorno, String mese, String anno) throws ParseException{
        int eta = 0;
        
        LocalDate dataNascita = LocalDate.of(Integer.parseInt(anno) , Integer.parseInt(mese), Integer.parseInt(giorno));
        LocalDate dataAttuale = LocalDate.now();
        eta = (int) (long) ChronoUnit.YEARS.between(dataNascita, dataAttuale);
        
        return eta;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import cliente.Cliente;
import grafica.Grafica;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import main.Controller;
import query.Insert;
import utils.CalcoloDati;
import visita.Visita;

/**
 *
 * @author te4o
 */
public class NuovaVisitaPanel extends JPanel{
    
    public static Controller controller = Controller.getInstance();
    
    public  NuovaVisitaPanel (Cliente cliente){
        Visita visitaPrecedente = controller.visitaPrecendete(cliente);
        
        setLayout(new GridLayout(3, 1, 0, 0));
        
        JPanel titlePanel = new JPanel();
        JPanel mainPanel = new JPanel();
        JPanel submitPanel = new JPanel();
        
        JLabel titleLabel = new JLabel("NUOVA VISITA: "+cliente.getCognome().toUpperCase()+" "+cliente.getNome()); titleLabel.setFont(new Font("Century Gothic", Font.BOLD, 50)); 
        
        JTextField nome = new JTextField(); nome.setPreferredSize(new Dimension(150, 45)); nome.setText(cliente.getNome()); nome.setEditable(false);
        JTextField cognome = new JTextField(); cognome.setPreferredSize(new Dimension(150, 45)); cognome.setText(cliente.getCognome()); cognome.setEditable(false);
        JTextField sesso = new JTextField(); sesso.setPreferredSize(new Dimension(150, 45)); sesso.setText(cliente.getSesso()); sesso.setEditable(false);
        JTextField eta = new JTextField(); eta.setPreferredSize(new Dimension(150, 45)); eta.setText(cliente.getEta()+"");
        JTextField altezza = new JTextField(); altezza.setPreferredSize(new Dimension(150, 45)); altezza.setText(visitaPrecedente.getAltezza()+""); controlloZero(altezza);
        JTextField peso = new JTextField(); peso.setPreferredSize(new Dimension(150, 45)); peso.setText(visitaPrecedente.getPeso()+""); controlloZero(peso);
        JTextField braccio = new JTextField(); braccio.setPreferredSize(new Dimension(150, 45)); braccio.setText(visitaPrecedente.getBraccio()+""); controlloZero(braccio);
        JTextField torace = new JTextField(); torace.setPreferredSize(new Dimension(150, 45)); torace.setText(visitaPrecedente.getTorace()+""); controlloZero(torace);
        JTextField ombelico = new JTextField(); ombelico.setPreferredSize(new Dimension(150, 45)); ombelico.setText(visitaPrecedente.getOmbelico()+""); controlloZero(ombelico);
        JTextField coscia = new JTextField(); coscia.setPreferredSize(new Dimension(150, 45)); coscia.setText(visitaPrecedente.getCoscia()+""); controlloZero(coscia);
        JTextField plica1 = new JTextField(); plica1.setPreferredSize(new Dimension(150, 45)); plica1.setText(visitaPrecedente.getPlica1()+""); controlloZero(plica1);
        JTextField plica2 = new JTextField(); plica2.setPreferredSize(new Dimension(150, 45)); plica2.setText(visitaPrecedente.getPlica2()+""); controlloZero(plica2);
        JTextField plica3 = new JTextField(); plica3.setPreferredSize(new Dimension(150, 45)); plica3.setText(visitaPrecedente.getPlica3()+""); controlloZero(plica3);
        
        nome.setBorder(BorderFactory.createTitledBorder("Nome"));
        cognome.setBorder(BorderFactory.createTitledBorder("Cognome"));
        sesso.setBorder(BorderFactory.createTitledBorder("Sesso"));
        eta.setBorder(BorderFactory.createTitledBorder("Età"));
        altezza.setBorder(BorderFactory.createTitledBorder("Altezza (cm)"));
        peso.setBorder(BorderFactory.createTitledBorder("Peso (Kg)"));
        braccio.setBorder(BorderFactory.createTitledBorder("Braccio (cm)"));
        torace.setBorder(BorderFactory.createTitledBorder("Torace (cm)"));
        ombelico.setBorder(BorderFactory.createTitledBorder("Ombelico (cm)"));
        coscia.setBorder(BorderFactory.createTitledBorder("Coscia (cm)"));
        if (cliente.getSesso().equalsIgnoreCase("M")) {
            plica1.setBorder(BorderFactory.createTitledBorder("Plica pettorale (mm)"));
        plica2.setBorder(BorderFactory.createTitledBorder("Plica addome (mm)"));
        plica3.setBorder(BorderFactory.createTitledBorder("Plica coscia (m)"));
        }
        else{
            plica1.setBorder(BorderFactory.createTitledBorder("Plica tricipite (mm)"));
            plica2.setBorder(BorderFactory.createTitledBorder("Plica sovraeliaca (mm)"));
            plica3.setBorder(BorderFactory.createTitledBorder("Plica coscia (m)"));
        }
        
        JButton annulla = new JButton("ANNULLA");
        JButton salva = new JButton("SALVA");
        
        annulla.addActionListener((ActionEvent e) -> {
            Grafica.card.show(Grafica.container, "home");
        });
        
        salva.addActionListener((ActionEvent e) -> {
            try {
                Date date = new Date();
                String data = new SimpleDateFormat("dd/MM/yyyy").format(date);
                float grasso = CalcoloDati.percentualeMassaGrassa(Integer.parseInt(plica1.getText()), Integer.parseInt(plica2.getText()),
                        Integer.parseInt(plica3.getText()), Integer.parseInt(eta.getText()), cliente.getSesso());
                
                Visita nuovaVisita = new Visita(cliente, Integer.parseInt(altezza.getText()), Float.parseFloat(peso.getText()), Integer.parseInt(braccio.getText()), 
                        Integer.parseInt(torace.getText()), Integer.parseInt(ombelico.getText()), Integer.parseInt(coscia.getText()), 
                                Integer.parseInt(plica1.getText()), Integer.parseInt(plica2.getText()), Integer.parseInt(plica3.getText()), 
                                    grasso, visitaPrecedente.getnVisita()+1, data);
                
                Insert.nuovaVisita(nuovaVisita);
                if (cliente.getEta() != Integer.parseInt(eta.getText())) {
                    Insert.updateEtaCliente(cliente, Integer.parseInt(eta.getText()));
                }
                JOptionPane.showMessageDialog(null, "Nuova visita inserita correttamente\n\n"
                        + "Massa grassa: "+String.format("%.02f", nuovaVisita.getGrassoKg())+" kg ["+String.format("%.02f", nuovaVisita.getGrasso())+"%]\n"
                        + "Massa magra: "+String.format("%.02f", nuovaVisita.getMagra())+" kg\n"
                        + "BMI: "+String.format("%.02f", nuovaVisita.getBMI())+"\n"
                        + "Metabolismo: "+String.format("%.02f", nuovaVisita.getMetabolismo())+" Kcal\n\n", "Operazione avvenuta con  successo", JOptionPane.INFORMATION_MESSAGE);
                Grafica.card.show(Grafica.container, "home");
            } catch (SQLException ex) {
                System.out.println("Errore dutante il salvataggio di un nuovo cliente");
            }
        });
        
        titlePanel.add(titleLabel);
        
        mainPanel.add(nome);
        mainPanel.add(cognome);
        mainPanel.add(sesso);
        mainPanel.add(eta);
        mainPanel.add(altezza);
        mainPanel.add(peso);
        mainPanel.add(braccio);
        mainPanel.add(torace);
        mainPanel.add(ombelico);
        mainPanel.add(coscia);
        mainPanel.add(plica1);
        mainPanel.add(plica2);
        mainPanel.add(plica3);
        
        submitPanel.add(annulla);
        submitPanel.add(salva);
        
        add(titlePanel);
        add(mainPanel);
        add(submitPanel);
              
        javax.swing.border.Border padding = BorderFactory.createEmptyBorder(220, 200, 220, 200);
        setBorder(padding);
    }
    
    private void controlloZero (JTextField textField){
        if (textField.getText().equals("0") || textField.getText().equals("0.0")) {
            textField.setText("");
        }
    }
    
    private boolean controlloDati (){
        
        return true;
    }    
    
}

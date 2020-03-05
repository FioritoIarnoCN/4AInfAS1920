package it.itis.cuneo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FormPrenotazioni extends JFrame implements ActionListener{

    public static final String FILE = "db.csv";

    private JPanel centerPanel;
    private JPanel southPanel;
    private ArrayList<Prenotazione> aPrenotazioni;

    private JTextField tCognome;
    private JTextField tNome;
    private JTextField tTelefono;
    private JTextField tPartenza;
    private JTextField tDestinazione;
    private JTextField tData;

    private JButton conferma;
    private JButton annulla;
    private JButton stampa;
    private JButton salva;

    public FormPrenotazioni(){
        super ("Prenota il tuo biglietto!");
        init();

        setSize(400, 300);
        setLocation(100, 50);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void init(){
        Container cp = getContentPane();
        aPrenotazioni = new ArrayList<>();


        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        JLabel lCognome = new JLabel("Cognome: ");
        tCognome = new JTextField(20);
        JLabel  lNome = new JLabel("Nome: ");
        tNome = new JTextField(20);
        JLabel  lTelefono = new JLabel("Telefono: ");
        tTelefono = new JTextField(20);
        JLabel  lPartenza = new JLabel("Partenza: ");
        tPartenza = new JTextField(20);
        JLabel  lDestinaione = new JLabel("Destinazione: ");
        tDestinazione = new JTextField(20);
        JLabel  lData = new JLabel("Data: ");
        tData = new JTextField(20);

        centerPanel.add(lCognome);
        centerPanel.add(tCognome);

        centerPanel.add(lNome);
        centerPanel.add(tNome);

        centerPanel.add(lTelefono);
        centerPanel.add(tTelefono);

        centerPanel.add(lPartenza);
        centerPanel.add(tPartenza);

        centerPanel.add(lDestinaione);
        centerPanel.add(tDestinazione);

        centerPanel.add(lData);
        centerPanel.add(tData);

        southPanel = new JPanel();
        conferma = new JButton("Conferma");
        annulla = new JButton("Annulla");
        stampa = new JButton("Stampa");
        salva = new JButton("Salva");

        southPanel.add(conferma);
        southPanel.add(annulla);
        southPanel.add(stampa);
        southPanel.add(salva);

        cp.add(centerPanel, BorderLayout.CENTER);
        cp.add(southPanel, BorderLayout.SOUTH);

        conferma.addActionListener(this);
        annulla.addActionListener(this);
        stampa.addActionListener(this);
        salva.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == conferma){
            String cognome = tCognome.getText();
            String nome = tNome.getText();
            String telefono = tTelefono.getText();
            String cittap = tPartenza.getText();
            String cittad = tDestinazione.getText();
            String data = tData.getText();
            Prenotazione pre = new Prenotazione(cognome, nome, telefono, cittap, cittad, data);
            aPrenotazioni.add(pre);
            JOptionPane.showMessageDialog(null, "La prenotazione e' stata registrata con successo");
        }

        if(e.getSource() == annulla){
            tCognome.setText("");
            tNome.setText("");
            tTelefono.setText("");
            tPartenza.setText("");
            tDestinazione.setText("");
            tData.setText("");
            JOptionPane.showMessageDialog(null, "La prenotazione e' stata annullata");
        }

        if(e.getSource() == stampa){
            JOptionPane.showMessageDialog(null, aPrenotazioni.toString());
        }

        if(e.getSource() == salva){
            salvaCSV();
        }
    }

    public void salvaCSV(){
        String str = "";
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(FILE));

            for (Prenotazione prenotazione : aPrenotazioni) {
                str = prenotazione.rowCSV();
                bw.write(str);
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        FormPrenotazioni form = new FormPrenotazioni();
        form.setVisible(true);
    }
}

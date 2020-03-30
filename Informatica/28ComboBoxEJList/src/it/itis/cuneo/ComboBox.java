package it.itis.cuneo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ComboBox extends JFrame implements ActionListener {

    JTextField fNome;
    JTextField fCognome;
    JButton jButton;
    JLabel err;

    ArrayList<String> lNomi;
    DefaultComboBoxModel cbModel;
    DefaultListModel jlModel;

    public ComboBox(){
        this.setTitle("ComboBox della classe");

        init();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void init(){
        lNomi = new ArrayList<>();

        //ComboBox
        cbModel = new DefaultComboBoxModel();
        JComboBox comboBox = new JComboBox(cbModel);

        //JList
        jlModel = new DefaultListModel<>();
        JList jList = new JList(jlModel);
        JScrollPane jspList = new JScrollPane(jList);

        //Creazione pannello top e aggiunta componenti
        JPanel top = new JPanel(new FlowLayout());
        top.add(comboBox);
        top.add(jspList);

        //Label e campi
        JLabel lNome = new JLabel("Nome: ");
        fNome = new JTextField(10);
        JLabel lCognome = new JLabel("Cognome: ");
        fCognome = new JTextField(10);
        err = new JLabel("");

        //Creazione pannello center e aggiunta componenti
        JPanel center = new JPanel(new FlowLayout());
        center.add(lNome);
        center.add(fNome);
        center.add(lCognome);
        center.add(fCognome);
        center.add(err);

        //Pulsante
        jButton = new JButton("Aggiungi");
        jButton.addActionListener(this);

        //Aggiunta al pannello principale
        this.add(top, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(jButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton) {
            if (fCognome.getText().equalsIgnoreCase("") || fCognome.getText().equalsIgnoreCase("")) {
                err.setText("Entrambi i campi devono essere pieni!");
            } else {
                String str = fCognome.getText() + " " + fNome.getText();
                lNomi.add(str);

                cbModel.removeAllElements();
                for (String nome : lNomi) {
                    cbModel.addElement(nome);
                }

                jlModel.removeAllElements();
                for (String nome : lNomi) {
                    jlModel.addElement(nome);
                }

                err.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new ComboBox();
    }
}

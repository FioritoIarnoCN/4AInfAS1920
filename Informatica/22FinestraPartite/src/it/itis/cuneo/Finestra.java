package it.itis.cuneo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Finestra extends JFrame implements ActionListener {

    private JTextField fPrimaSquadra1;
    private JTextField fSecondaSquadra1;
    private JLabel lSquadre1;

    private JTextField fPrimaSquadra2;
    private JTextField fSecondaSquadra2;
    private JLabel lSquadre2;

    private JTextField fPrimaSquadra3;
    private JTextField fSecondaSquadra3;
    private JLabel lSquadre3;

    private JTextField fPrimaSquadra4;
    private JTextField fSecondaSquadra4;
    private JLabel lSquadre4;

    private JButton invia1;
    private JButton invia2;
    private JButton invia3;
    private JButton invia4;

    public Finestra(){
        init();
        //pack();

        setSize(820, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(550, 240);

        setVisible(true);
    }

    public void init(){

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        initRow1(cp);
        initRow2(cp);
        initRow3(cp);
        initRow4(cp);
    }

    public void initRow1(Container cp){
        cp.add(new JLabel("Squadra 1: "));
        cp.add(fPrimaSquadra1 = new JTextField(20));
        cp.add(new JLabel("Squadra 2: "));
        cp.add(fSecondaSquadra1 = new JTextField(20));
        cp.add(invia1 = new JButton("Invia"));
        cp.add(lSquadre1 = new JLabel("Squadra1 - Squadra2"));
        invia1.addActionListener(this);
    }

    public void initRow2(Container cp){
        cp.add(new JLabel("Squadra 1: "));
        cp.add(fPrimaSquadra2 = new JTextField(20));
        cp.add(new JLabel("Squadra 2: "));
        cp.add(fSecondaSquadra2 = new JTextField(20));
        cp.add(invia2 = new JButton("Invia"));
        cp.add(lSquadre2 = new JLabel("Squadra1 - Squadra2"));
        invia2.addActionListener(this);
    }

    public void initRow3(Container cp){
        cp.add(new JLabel("Squadra 1: "));
        cp.add(fPrimaSquadra3 = new JTextField(20));
        cp.add(new JLabel("Squadra 2: "));
        cp.add(fSecondaSquadra3 = new JTextField(20));
        cp.add(invia3 = new JButton("Invia"));
        cp.add(lSquadre3 = new JLabel("Squadra1 - Squadra2"));
        invia3.addActionListener(this);
    }

    public void initRow4(Container cp){
        cp.add(new JLabel("Squadra 1: "));
        cp.add(fPrimaSquadra4 = new JTextField(20));
        cp.add(new JLabel("Squadra 2: "));
        cp.add(fSecondaSquadra4 = new JTextField(20));
        cp.add(invia4 = new JButton("Invia"));
        cp.add(lSquadre4 = new JLabel("Squadra1 - Squadra2"));
        invia4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == invia1){
            lSquadre1.setText(fPrimaSquadra1.getText() + " - " + fSecondaSquadra1.getText());
        }

        if (e.getSource() == invia2){
            lSquadre2.setText(fPrimaSquadra2.getText() + " - " + fSecondaSquadra2.getText());
        }

        if (e.getSource() == invia3){
            lSquadre3.setText(fPrimaSquadra3.getText() + " - " + fSecondaSquadra3.getText());
        }

        if (e.getSource() == invia4){
            lSquadre4.setText(fPrimaSquadra4.getText() + " - " + fSecondaSquadra4.getText());
        }
    }

    public static void main(String[] args) {
        Finestra finestra = new Finestra();
    }
}

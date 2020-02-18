package it.itis.cuneo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calcolatrice extends JFrame implements ActionListener {

    private JTextField fatt1;
    private JTextField fatt2;
    private JLabel ris;

    private JButton bSum;
    private JButton bSott;
    private JButton bMul;
    private JButton bDiv;

    public Calcolatrice(){
        init();
        //pack();

        setSize(800, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(560, 390);

        setVisible(true);
    }

    public void init(){
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        cp.add(new JLabel("Fattore 1: "));
        cp.add(fatt1 = new JTextField(10));
        cp.add(new JLabel("Fattore 2: "));
        cp.add(fatt2 = new JTextField(10));
        cp.add(bSum = new JButton("+"));

        bSum.addActionListener(this);
        cp.add(bSott = new JButton("-"));
        bSott.addActionListener(this);
        cp.add(bMul = new JButton("x"));
        bMul.addActionListener(this);
        cp.add(bDiv = new JButton(":"));
        bDiv.addActionListener(this);

        cp.add(new JLabel("Risultato: "));
        cp.add(ris = new JLabel());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        double num1, num2;

        num1 = Double.parseDouble(fatt1.getText());
        num2 = Double.parseDouble(fatt2.getText());

        if (e.getSource() == bSum){
            ris.setText(Double.toString(num1 + num2));
        }
        if (e.getSource() == bSott){
            ris.setText(Double.toString(num1 - num2));
        }
        if (e.getSource() == bMul){
            ris.setText(Double.toString(num1 * num2));
        }
        if (e.getSource() == bDiv){
            ris.setText(Double.toString(num1 / num2));
        }
    }

    public static void main(String[] args) {
        Calcolatrice calcolatrice = new Calcolatrice();
    }
}
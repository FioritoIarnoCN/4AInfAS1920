package it.itis.cuneo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tris extends JFrame implements ActionListener {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    public Tris(){
        init();

        setSize(350, 350);
        setLocation(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void init(){
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(3, 3));

        button1 = new JButton("X");
        button2 = new JButton("X");
        button3 = new JButton("X");
        button4 = new JButton("X");
        button5 = new JButton("X");
        button6 = new JButton("X");
        button7 = new JButton("X");
        button8 = new JButton("X");
        button9 = new JButton("X");

        cp.add(button1, "1");
        cp.add(button2, "2");
        cp.add(button3, "3");
        cp.add(button4, "4");
        cp.add(button5, "5");
        cp.add(button6, "6");
        cp.add(button7, "7");
        cp.add(button8, "8");
        cp.add(button9, "9");

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button1){
            if(button1.getText().equals("X"))
                button1.setText("O");
            else
                button1.setText("X");
        }

        if(e.getSource() == button2){
            if(button2.getText().equals("X"))
                button2.setText("O");
            else
                button2.setText("X");
        }

        if(e.getSource() == button3){
            if(button3.getText().equals("X"))
                button3.setText("O");
            else
                button3.setText("X");
        }

        if(e.getSource() == button4){
            if(button4.getText().equals("X"))
                button4.setText("O");
            else
                button4.setText("X");
        }

        if(e.getSource() == button5){
            if(button5.getText().equals("X"))
                button5.setText("O");
            else
                button5.setText("X");
        }

        if(e.getSource() == button6){
            if(button6.getText().equals("X"))
                button6.setText("O");
            else
                button6.setText("X");
        }

        if(e.getSource() == button7){
            if(button7.getText().equals("X"))
                button7.setText("O");
            else
                button7.setText("X");
        }

        if(e.getSource() == button8){
            if(button8.getText().equals("X"))
                button8.setText("O");
            else
                button8.setText("X");
        }

        if(e.getSource() == button9){
            if(button9.getText().equals("X"))
                button9.setText("O");
            else
                button9.setText("X");
        }
    }

    public static void main(String[] args) {
        new Tris();
    }
}

package it.itis.cuneo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Window extends JFrame{

    public Window(){
        init();
        //pack();

        setSize(800, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(560, 390);

        setVisible(true);
    }

    public void init(){
        Container cp = getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));

        JPanel centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        BoxLayout centerPanelLayout = new BoxLayout(centerPanel,  BoxLayout.Y_AXIS);
        FlowLayout bottomPanelLayout = new FlowLayout();

        centerPanel.setLayout(centerPanelLayout);
        bottomPanel.setLayout(bottomPanelLayout);

        JButton button = new JButton("Button");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton shortButton = new JButton("Short");
        shortButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton longButton = new JButton("Long - long - long button");
        longButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton ok = new JButton("Ok");
        JButton cancel = new JButton("Cancel");

        centerPanel.add(button);
        centerPanel.add(shortButton);
        centerPanel.add(longButton);

        bottomPanel.add(ok);
        bottomPanel.add(cancel);

        cp.add(centerPanel);
        cp.add(bottomPanel);
    }

    public static void main(String[] args) {
        new Window();
    }
}

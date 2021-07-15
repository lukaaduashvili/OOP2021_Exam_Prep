package Sem08;

import Sem07.MyContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class Main {
    public static int count = 0;
    public int i = 0;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(0, 1));

        JButton button = new JButton("Click");
        JLabel label = new JLabel("Count: 0");

        button.addActionListener(e -> {
            count++;
            label.setText("Count: " + count);
        });

        panel.add(button);
        panel.add(label);

        frame.setContentPane(panel);

        frame.setSize(500, 400);
        frame.setName("My Window");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

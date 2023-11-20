package ui.tabs;

import model.TradeList;

import javax.swing.*;
import java.awt.*;

public class TradeResults extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    private JTextArea display;
    private JButton submit;

    public TradeResults(TradeList tl, StringBuilder sb) {
        setTitle("NBA Player Trading Simulator");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextArea(sb.toString());
        display.setEditable(false);
        display.setLineWrap(true);
        display.setWrapStyleWord(true);
        submit = new JButton("OK");

        submit.addActionListener(e -> {
            dispose();
            new HomePage(tl);
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panel.add(new JScrollPane(display));
        panel.add(submit);

        getContentPane().add(panel);
        setVisible(true);
    }
}

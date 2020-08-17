package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {


        Table table = new Table();
        JFrame frame = new JFrame();
        table.setFrame(frame.getContentPane());
        frame.setSize(465,545);
        frame.setVisible(true);
         JOptionPane.showMessageDialog(frame,"New Game , Match up to 5 points\n Press (s) to start. ","Game",JOptionPane.PLAIN_MESSAGE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}

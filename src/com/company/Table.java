package com.company;
import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;

public class Table extends JPanel implements GameConstants {
//JPanel jPanel = new JPanel();
    public int Racket_X;
    JLabel jLabel1;
    int CounterX = 0;
    JLabel CounterPeople;
    public int CircleX = 10;
    public int CircleY = 10;
    public int x = 5;
    boolean start = false;
    JLabel jLabel = new JLabel("",SwingConstants.CENTER);
    Dimension dimension  = new Dimension(TableX,TableY);
    public Dimension getDimension() {
        return dimension;

    }
Point point = new Point(100,100);


    Table(){
        System.out.println(x);
        Engene engene = new Engene(this);
        addKeyListener(engene);
        addMouseMotionListener(engene);
    }
    public void setFrame(Container container){
        BoxLayout boxLayout = new BoxLayout(container,BoxLayout.Y_AXIS);
        container.setLayout(boxLayout);
        CounterPeople = new JLabel("Player = 0" + "  Computer  = 0");
        container.add(CounterPeople);
        container.add(this);

        container.setBackground(Color.cyan);
        container.add(jLabel);
        jLabel1 = new JLabel();
        container.add(jLabel1);

    }
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,450,485);
        g.setColor(Color.white);


if(point != null){

        g.fillRect(0, point.y, 10, 40);
    g.fillRect(TableX-65,CircleY, 10, 40);
        requestFocus();
    jLabel.setText("x = "+point.x + "  y = " + point.y);
    jLabel1.setText("x = "+CircleX + "  y = " + CircleY);
        jLabel.setHorizontalTextPosition(SwingConstants.CENTER);
}
if(start == true){
    g.setColor(Color.RED);
    g.fillOval(CircleX,CircleY,10,10);

}else {
    g.setColor(Color.GREEN);
    g.fillOval(10, point.y + 15, 10, 10);
}
    }
    public  void setCirclePosition (){
        repaint();

    }
  // public void setCircle(int i){
   //     CircleX+=i;
    //}
    public void setStart(boolean s){
        start = s;
    }

}

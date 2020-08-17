package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Engene extends JPanel implements KeyListener , MouseMotionListener,Runnable,GameConstants {
    Table table;
    boolean forward = false;
    boolean beak = false;
    boolean up = false;
    boolean down = false;
    public char button;
    boolean canMove = true;
    boolean stopGame = false;

    Engene(Table table) {
        this.table = table;
        table.repaint();

    }


    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        button = e.getKeyChar();
        if(button == 'n'){

        }
        if(button =='s'){
            table.CircleY=10;
            table.CircleX=10;
            forward = true;
            down = true;
            beak = false;
            up = false;
            canMove = true;
            table.CircleY = table.point.y + 15;
            table.setStart(true);
        }
        Thread thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        if (button == 's') {
            while (true) {
                if (canMove) {
                    if (forward) {
                        if (table.CircleX > 420) {
                            table.CircleX -= 3;
                            forward = false;
                            beak = true;
                        }
                        table.CircleX += 3;
                    }
                    if (beak) {
                        if (table.CircleX == 10 || table.CircleX == 1) {
                            table.CircleX += 3;
                            forward = true;
                            beak = false;
                        }
                        table.CircleX -= 3;
                    }
                    if (down) {
                        if (table.CircleY > 430) {
                            table.CircleY -= 3;
                            down = false;
                            up = true;
                        } else {
                            table.CircleY += 3;
                        }
                    }
                    if (up) {
                        if (table.CircleY == 0 || table.CircleY < 1 || table.CircleY == 3) {
                            table.CircleY += 3;
                            down = true;
                            up = false;
                        } else {
                            table.CircleY -= 3;
                        }
                    }

                    boolean win = check();
                    if (win == false) {
                        table.CounterPeople.setText(String.valueOf("Player = " + String.valueOf(table.CounterX += 1)) + "  Computer  = 0");
                        canMove = false;
                        table.setStart(false);

if(table.CounterX == 5){
    JOptionPane.showMessageDialog(null,"you loss","Game",JOptionPane.PLAIN_MESSAGE);
    table.CounterX =0;
    table.CounterPeople.setText(String.valueOf("Player = " + String.valueOf(table.CounterX)) + "  Computer  = 0");
}else{
    JOptionPane.showMessageDialog(null,"you loss","Game",JOptionPane.PLAIN_MESSAGE);
}
                    }
                    if(win == true){
                        table.repaint();
                    }

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }

                }
                else{
                }
            }

            }





        if(button =='q') {
        System.exit(0);
    }


}




    public boolean check(){
       if(table.CircleX == 10 && (table.point.y-10 >= table.CircleY || table.point.y+50 <= table.CircleY) ){
           return false;
       }else{
           return  true;
       }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
table.point.y = e.getY();
table.point.x = e.getX();
if(table.point.x > 410){
    table.point.x=410;

}
        if(table.point.y > 410){
            table.point.y=410;

        }
        if(stopGame){
            int i = 9;
        }else {

            table.repaint();
        }
    }


}

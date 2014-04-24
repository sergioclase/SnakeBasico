/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author aplicacciones web
 */
public class MiCanvas extends Canvas implements KeyListener {

    Snake snake;
    Comida comida;

    MiCanvas(Snake snake, Comida comida) {
        this.setBackground(Color.white);
        this.setBounds(50, 50, 300, 300);
        this.snake = snake;
        this.comida = comida;
        this.addKeyListener(this);
    }

    public void paint(Graphics g) {

        snake.draw(g);
        comida.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            if (snake.getMov() == 'R') {
            } else {
                snake.setMov('L');
            }
        }
        if (key == KeyEvent.VK_RIGHT) {
            if (snake.getMov() == 'L') {
            } else {
                snake.setMov('R');
            }
        }
        if (key == KeyEvent.VK_DOWN) {
            if (snake.getMov() == 'U') {
            } else {
                snake.setMov('D');
            }
        }
        if (key == KeyEvent.VK_UP) {
            if (snake.getMov() == 'D') {
            } else {
                snake.setMov('U');
            }
        }
        repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

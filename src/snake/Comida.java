/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author aplicacciones web
 */
public class Comida {
    Rectangle comida=new Rectangle();
    int lado;
    Comida(){
        Pintar();
    }

    void draw(Graphics g) {
    g.setColor(Color.red);
    g.fillOval(comida.x, comida.y, lado, lado);
    }
    
    public Rectangle getBounds(){
        return comida;
    }
    
    public void Pintar(){
        lado=10;
        comida.height=lado;
        comida.width=lado;
        comida.x=((int)(Math.random()*30))*10;
        comida.y=((int)(Math.random()*30))*10;
    }
    
}

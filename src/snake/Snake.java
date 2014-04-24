package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Snake {

    LinkedList<Rectangle> snake = new LinkedList();
    int lado = 10;//lado del rectangulo.
    int x,y;
    int body = 3;//cuadraditos que voy a pintar al iniciar el snake
    char mov;//para tener almacenado hacia donde se va a mover la serpiente L,R,U,D
    boolean crece;//
    Comida comida;
    

    Snake(Comida comida) //creo mis tres primeros rectangulos.
    {
        this.comida=comida;
        int x = 150;
        int y = 150;
        for (int i = 0; i < body; i++) {
            Rectangle r = new Rectangle(x, y, lado, lado);
            snake.add(r);
            y += 10;
        }
        crece = false;
    }
    
    public void draw(Graphics g)
    {
       g.setColor(Color.GREEN);
       for(int i=0; i<body;i++)
       {
           Rectangle r=snake.get(i);
           g.fillOval(r.x, r.y, r.width, r.height);
       }
       for (int i=1; i<snake.size();i++){
       if (this.snake.getFirst().intersects(snake.get(i)))
           GameOver();
           }
       
    }
    
    public void left()
    {
        Rectangle r=new Rectangle(snake.getFirst());
        r.x-=lado;
        if(r.x<0)
            r.x=300-lado;
        snake.addFirst(r);
        if (!r.intersects(comida.getBounds()))
            snake.removeLast();
        else {
            body++;
        comida.Pintar();
        }
    }
    
    public void right()
    {
        Rectangle r=new Rectangle(snake.getFirst());
        r.x+=lado;
        if(r.x>=300)
            r.x=0;
        snake.addFirst(r);
       if (!r.intersects(comida.getBounds()))
            snake.removeLast();
        else {
            body++;
        comida.Pintar();
        }
    }
    
    public void up()
    {
        Rectangle r=new Rectangle(snake.getFirst());
        r.y-=lado;
        if(r.y<0)
            r.y=300-lado;
        snake.addFirst(r);
       if (!r.intersects(comida.getBounds()))
            snake.removeLast();
        else {
            body++;
        comida.Pintar();
        }
    }
    
    public void down()
    {
        Rectangle r=new Rectangle(snake.getFirst());
        r.y+=lado;
        if(r.y>=300)
            r.y=0;
        snake.addFirst(r);
       if (!r.intersects(comida.getBounds()))
            snake.removeLast();
        else {
            body++;
            comida.Pintar();
        }
    }

    public char getMov() {
        return mov;
    }

    public void setMov(char mov) {
        this.mov = mov;
    }
    
    public Rectangle getPosicion(){
        return new Rectangle(x, y, lado, lado);
    }
    
    public void GameOver(){
        boolean perdido=false;
        if(!perdido){
        JOptionPane.showMessageDialog(null ,"GAME OVER");
        System.exit(0);
                
        }
    }
}

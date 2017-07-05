package unittest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Food {
    int x;
    int y;
    int width = 10;
    public Food(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, width);
    }
    public Rectangle getBounds(){
        return new Rectangle(x, y, width, width);
    }
}

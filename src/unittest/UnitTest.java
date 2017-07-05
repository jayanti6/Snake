package unittest;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class UnitTest extends JPanel{

    int direction = 2;
    int x = 0;
    int y = 0;
    Unit unit1;
    Food food;
    boolean collision = false;
    ArrayList<Unit> snakes = new ArrayList<>();
    
    public UnitTest(){
        
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    direction = 1;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    direction = 3;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    direction = 2;
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    direction = 4;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        setFocusable(true);
        unit1 = new Unit(x, y);
        snakes.add(unit1);
        food = new Food(100, 100);
    }
    public void move(){
        if(collision()){
            int a = (int)( Math.random() * 350);
            int b = (int)( Math.random() * 350);
            food.setX(a);
            food.setY(b);
            snakes.add(new Unit(snakes.get(snakes.size()-1).x, snakes.get(snakes.size()-1).y));
        }

        if(!collision()){
            for(int i = snakes.size()-1; i > 0; i--){
                Unit u = snakes.get(i);
                int previous = i-1;
                u.setX(snakes.get(previous).x);
                u.setY(snakes.get(previous).y);
            }
        }
        if(direction == 1){
            y = y - 10;
        }
        if(direction == 2){
            x = x + 10;
        }
        if(direction == 3){
            y = y + 10;
        }
        if(direction == 4){
            x = x - 10;
        }
        unit1.setX(x);
        unit1.setY(y);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        food.paint(g);
        unit1.paint(g);
        for(int i = 1; i < snakes.size(); i++){
            snakes.get(i).paint(g);
        }
        
    }
    public boolean collision(){
        return unit1.getBounds().intersects(food.getBounds());
    }
    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame("Unit Testing");
        UnitTest panel = new UnitTest();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true){
            panel.move();
            panel.repaint();
            Thread.sleep(100);
        }
    }
    
}

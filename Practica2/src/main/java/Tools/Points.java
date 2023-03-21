/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import static Tools.Simu.cant;
import static Tools.Simu.pos;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author fi944
 */
public class Points extends JPanel implements Runnable {

    private int x = 0;
    private int y = 0;
    private int dx = 1;
    private int dy = 1;

    public Points() {
        Thread point = new Thread(this);
        point.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        // 00
        g.setColor(Color.YELLOW);
        g.drawRect(0, 0, 100, 100);

        // 20
        g.setColor(Color.MAGENTA);
        g.drawRect(0, 200, 100, 100);

        // 40
        g.setColor(Color.RED);
        g.drawRect(0, 400, 100, 100);

        // 02
        g.setColor(Color.BLUE);
        g.drawRect(200, 0, 100, 100);

        // 22
        g.setColor(Color.ORANGE);
        g.drawRect(200, 200, 100, 100);

        // 42
        g.setColor(Color.BLACK);
        g.drawRect(200, 400, 100, 100);

        // 00
        if (0 <= x && x < 200 && y <= 100 && 0 <= y) {
            g.setColor(Color.YELLOW);
        }
        
        // 02
        if (200 <= x && x <= 300 && y < 200 && 0 <= y) {
            g.setColor(Color.BLUE);
        }
        
        // 22
        if (100 < x && x <= 300 && y < 400 && 200 <= y) {
            g.setColor(Color.ORANGE);
        }
        
        // 42
        if (100 < x && x <= 300 && y <= 500 && 400 <= y) {
            g.setColor(Color.BLACK);
        }
        
        // 20
        if (0 <= x && x <= 100 && y <= 300 && 200 < y) {
            g.setColor(Color.MAGENTA);
        }
        
        // 40
        if (0 <= x && x <= 100 && y <= 500 && 300 < y) {
            g.setColor(Color.RED);
        }
        g.fillOval(x, y, 5, 5);
    }

    public void run() {
        try {
            while (true) {
                // 00
                Thread.sleep(10);
                
                if (0 <= x && x < 200 && y <= 100 && 0 <= y) {
                    Thread.sleep(10);
                    x += dx;
                }
                
                // 02
                if (200 <= x && x <= 300 && y < 200 && 0 <= y) {
                    Thread.sleep(10);
                    y += dy;
                }

                // 22
                if (100 < x && x <= 300 && y < 400 && 200 <= y) {
                    Thread.sleep(10);
                    y += dy;
                }

                // 42
                if (99 <= x && x <= 300 && y <= 500 && 400 <= y) {
                    Thread.sleep(10);
                    x -= dx;
                }

                // 20
                if (0 <= x && x <=100 && y < 300 && 200 <= y) {
                    Thread.sleep(10);
                    x = x - 1;
                    y = y - 1 ;
                }
                
                // 40
                if (0 <= x && x <=99 && y <= 500 && 300 <= y){
                    Thread.sleep(10);
                    y -= dy; 
                }
                repaint();
            }
        } catch (Exception e) {
        }
    }
}

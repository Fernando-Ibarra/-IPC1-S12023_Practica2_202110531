/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import javax.swing.JFrame;

/**
 *
 * @author fi944
 */
public class Simu extends Thread {

    public Simu() {
    }

    public static int cant = 0;
    public static int pos = 0;

    public void run() {
        JFrame ventana = new JFrame("Simulación");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 600);
        try {
            while (cant < 31) {
                Points pon = new Points();
                ventana.add(pon);
                ventana.setVisible(true);
                cant +=1;
                pos +=3;
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

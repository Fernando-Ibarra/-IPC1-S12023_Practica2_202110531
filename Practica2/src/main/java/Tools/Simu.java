/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import static Vista.MenuPrincipal.miHilo;
import static Vista.MenuPrincipal.sm;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author fi944
 */
public class Simu extends Thread {
    public static JFrame ventana = new JFrame("Simulación");
    public Simu() {
    }

    public static int canInv = 0;
    public static int canPro = 0;
    public static int canEmpa = 0;
    public static int canSali = 0;
    public static int canFinal = 0;
    public static boolean desactiveMood = true;
    public static int cant = 0;
    public static int pos = 0;

    public void run() {
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 600);
        try {
            while (cant < 30) {
                Points pon = new Points();
                ventana.add(pon);
                ventana.setVisible(true);
                cant += 1;
                pos += 3;
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }
}

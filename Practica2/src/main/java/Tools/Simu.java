/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

/**
 *
 * @author fi944
 */
public class Simu extends Thread {

    public static int cant= 0;
    public static int pos = 1;
    public void run() {
        try {
            while (cant <3) {
                Points point = new Points();
                Thread.sleep(1000);
                cant +=1;
                pos +=1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

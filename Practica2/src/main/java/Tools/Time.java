/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import static Tools.Simu.desactiveMood;

/**
 *
 * @author fi944
 */
public class Time extends Thread {

    public static String time;
    int mins = 0;
    int segs = 0;
    int miles = 0;
    String min = "";
    String segn = "";
    String mil = "";

    public void run() {
        try {
            while (desactiveMood) {
                Thread.sleep(4);
                miles += 4;
                if (miles == 1000) {
                    miles = 0;
                    segs += 1;
                    if (segs == 60) {
                        segs = 0;
                        mins++;
                    }
                }
                if (mins < 10) {
                    min = "0" + mins;
                } else {
                    min = Integer.toString(mins);
                }

                if (segs < 10) {
                    segn = "0" + segs;
                } else {
                    segn = Integer.toString(segs);
                }

                if (miles < 10) {
                    mil = "0" + miles;
                } else if (miles < 100) {
                    mil = "00" + miles;
                } else {
                    mil = Integer.toString(miles);
                }
                time = Integer.toString(mins) + " : " + Integer.toString(segs) + " : " + Integer.toString(miles);
                //System.out.println(time);
            }
        } catch (Exception e) {
        }
        time = "00 : 00 : 00";
        System.out.println(time);
    }
}

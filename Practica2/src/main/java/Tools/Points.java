/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import static Tools.Simu.canEmpa;
import static Tools.Simu.canFinal;
import static Tools.Simu.canInv;
import static Tools.Simu.canPro;
import static Tools.Simu.canSali;
import static Tools.Simu.cant;
import static Tools.Simu.desactiveMood;
import static Tools.Simu.ventana;
import static Tools.Time.time;
import static Tools.Utils.makeReport;
import static Tools.Utils.makeFile;
import Vista.MenuPrincipal;
import static Vista.MenuPrincipal.miHilo;
import static Vista.MenuPrincipal.pos;
import static Vista.MenuPrincipal.sm;
import static Vista.MenuPrincipal.timeLeaving;
import static Vista.MenuPrincipal.timePackaging;
import static Vista.MenuPrincipal.timeProduction;
import static Vista.MenuPrincipal.timeStorage;
import static Vista.MenuPrincipal.valueLeaving;
import static Vista.MenuPrincipal.valuePackaging;
import static Vista.MenuPrincipal.valueProduction;
import static Vista.MenuPrincipal.valueStorage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author fi944
 */
public class Points extends JPanel implements Runnable {

    MenuPrincipal mp = new MenuPrincipal();
    private int x = 0;
    private int y = 0;
    private int dx = 1;
    private int dy = 1;
    public int cant2 = 0;
    private int timeInv = (timeStorage * 1000) - 10;
    private int timePro = (timeProduction * 1000) - 10;
    private int timePack = (timePackaging * 1000) - 10;
    private int timeExit = (timeLeaving * 1000) - 10;
    public JLabel label1 = new JLabel("Inicio");
    public JLabel label2 = new JLabel("Inventario: " + canInv);
    public JLabel label3 = new JLabel("Producción: " + canPro);
    public JLabel label4 = new JLabel("Empaquetado: " + canEmpa);
    public JLabel label5 = new JLabel("Salida: " + canSali);
    public JLabel label6 = new JLabel("Final: " + canFinal);
    public JLabel label7 = new JLabel(time);
    JButton botonB = new JButton("REGRESAR");
    JButton botonR = new JButton("REPORTE");

    public Points() {
        setLayout(null);
        elementosInicial();
        Thread point = new Thread(this);
        point.start();

        botonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == botonB) {
                    if (!point.isAlive()) {
                        mp.setVisible(true);
                        ventana.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "HILO ACTIVO, ESPERAR A QUE TERMINE.");
                    }
                }
            }
        });

        botonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == botonR) {
                    if (!point.isAlive()) {
                        String report = makeReport(timeStorage, valueStorage, timeProduction, valueProduction, timePackaging, valuePackaging, timeLeaving, valueLeaving);
                        makeFile(report);
                    } else {
                        JOptionPane.showMessageDialog(null, "HILO ACTIVO, ESPERAR A QUE TERMINE.");
                    }
                }
            }
        });
    }

    public void elementosInicial() {
        label1.setBounds(10, 50, 80, 50);
        label2.setBounds(210, 50, 80, 50);
        label3.setBounds(210, 250, 80, 50);
        label4.setBounds(210, 450, 100, 50);
        label5.setBounds(10, 450, 80, 50);
        label6.setBounds(10, 250, 80, 50);
        label7.setBounds(120, 250, 100, 50);
        botonB.setBounds(40, 520, 110, 25);
        botonR.setBounds(200, 520, 100, 25);

        label1.setFont(new Font("Arial", Font.BOLD, 12));
        label2.setFont(new Font("Arial", Font.BOLD, 12));
        label3.setFont(new Font("Arial", Font.BOLD, 12));
        label4.setFont(new Font("Arial", Font.BOLD, 12));
        label5.setFont(new Font("Arial", Font.BOLD, 12));
        label6.setFont(new Font("Arial", Font.BOLD, 12));
        label7.setFont(new Font("Arial", Font.BOLD, 12));
        botonB.setFont(new Font("Arial", Font.BOLD, 12));
        botonR.setFont(new Font("Arial", Font.BOLD, 12));

        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        add(label7);
        add(botonB);
        add(botonR);
    }

    public void paint(Graphics g) {
        super.paint(g);
        // 00
        g.setColor(Color.RED);
        g.drawRect(0, 0, 100, 100);

        // 20
        g.setColor(Color.MAGENTA);
        g.drawRect(0, 200, 100, 100);

        // 40
        g.setColor(Color.green);
        g.drawRect(0, 400, 100, 100);

        // 02
        g.setColor(Color.BLUE);
        g.drawRect(200, 0, 130, 100);

        // 22
        g.setColor(Color.ORANGE);
        g.drawRect(200, 200, 130, 100);

        // 42
        g.setColor(Color.BLACK);
        g.drawRect(200, 400, 130, 100);

        // 00
        if (0 <= x && x < 200 && y <= 100 && 0 <= y) {
            g.setColor(Color.RED);
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
            g.setColor(Color.green);
        }
        g.fillOval(x + pos, y + pos, 10, 10);
    }

    public void run() {
        try {
            while (desactiveMood) {
                label7.setText(time);
                // 00

                if (0 <= x && x < 205 && y <= 100 && 0 <= y) {
                    Thread.sleep(5);
                    x += dx;
                }

                // 02
                if (200 < x && x <= 300 && 0 <= y && y < 100) {
                    canInv = canInv + 1;
                    label2.setText("Inventario: " + canInv);
                    System.out.println("Inventario: " + canInv);
                    Thread.sleep(10);
                    x = x;
                    y = y;
                    Thread.sleep(timeInv);
                    y = 100;
                    canInv = canInv - 1;
                    label2.setText("Inventario: " + canInv);
                    System.out.println("Inventario: " + canInv);
                }

                // 02 -> 22
                if (200 <= x && x <= 300 && 100 <= y && y < 200) {
                    Thread.sleep(5);
                    y += dy;
                }

                // 22
                if (100 < x && x <= 300 && 200 <= y && y < 300) {
                    canPro += 1;
                    label3.setText("Producción: " + canPro);
                    System.out.println("Producción: " + canPro);
                    Thread.sleep(10);
                    x = x;
                    y = y;
                    Thread.sleep(timePro);
                    y = 300;
                    canPro -= 1;
                    label3.setText("Producción: " + canPro);
                    System.out.println("Producción: " + canPro);
                }

                // 22 -> 42
                if (200 <= x && x <= 300 && 300 <= y && y < 400) {
                    Thread.sleep(5);
                    y += dy;
                }

                // 42
                if (200 < x && x <= 300 && 400 <= y && y <= 500) {
                    canEmpa += 1;
                    label4.setText("Empaquetado: " + canEmpa);
                    System.out.println("Empaquetado: " + canEmpa);
                    Thread.sleep(10);
                    x = x;
                    y = y;
                    Thread.sleep(timePack);
                    x = 199;
                    y = 405;
                    canEmpa -= 1;
                    label4.setText("Empaquetado: " + canEmpa);
                    System.out.println("Empaquetado: " + canEmpa);
                }

                // 42 -> 40
                if (95 <= x && x <= 200 && 400 <= y && y <= 500) {
                    Thread.sleep(5);
                    x -= dx;
                }

                // 40
                if (0 <= x && x <= 95 && 400 <= y && y <= 500) {
                    canSali += 1;
                    label5.setText("Salida: " + canSali);
                    System.out.println("Salida: " + canSali);
                    Thread.sleep(10);
                    x = x;
                    y = y;
                    Thread.sleep(timeExit);
                    x = 50;
                    y = 399;
                    canSali -= 1;
                    System.out.println("Salida: " + canSali);
                    label5.setText("Salida: " + canSali);
                }

                // 40 -> 20
                if (0 <= x && x <= 100 && 295 < y && y < 400) {
                    Thread.sleep(5);
                    y -= dy;
                }

                // 20
                if (0 <= x && x <= 100 && 275 <= y && y <= 300) {
                    canFinal += 1;
                    label6.setText("Final: " + canFinal);
                    System.out.println("Final: " + canFinal);
                    x = 5;
                    y = 250;

                }

                repaint();
                if (cant == 30 && canSali == 0 && canEmpa == 0 && canInv == 0 && canPro == 0 && canFinal == 30) {
                    desactiveMood = false;
                    label6.setText("Final: " + canFinal);
                    label5.setText("Salida: " + canSali);
                    label4.setText("Empaquetado: " + canEmpa);
                    label2.setText("Inventario: " + canInv);
                    label3.setText("Producción: " + canPro);
                    System.out.println("Cantidad 1: " + cant);
                }
            }
            miHilo.stop();
            sm.stop();
        } catch (Exception e) {
        }
    }
}

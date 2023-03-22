/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author fi944
 */
public class Utils {

    public static String makeReport(int timeStorage, double valueStorage, int timeProduction, double valueProduction, int timePackaging, double valuePackaging, int timeLeaving, double valueLeaving) {
        double totalStro = Math.round(timeStorage * valueStorage * 30);
        double totalPro = Math.round(timeProduction * valueProduction * 30);
        double totalPack = Math.round(timePackaging * valuePackaging * 30);
        double totalLea = Math.round(timeLeaving * valueLeaving * 30);
        double total = Math.round(totalStro + totalPro + totalPack + totalLea);
        String report = "<!DOCTYPE html>\n"
                + "<html lang=\"es\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"descripcion\" content=\"REPORTE\" />\n"
                + "    <meta name=\"robots\" content=\"index,follow\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <title>REPORTE</title>\n"
                + "    <style type=\"text/css\" media=\"screen\">\n"
                + "        *{\n"
                + "            box-sizing: border-box;\n"
                + "            margin: 0;\n"
                + "            padding: 0;\n"
                + "            font-family: Arial, Helvetica, sans-serif;\n"
                + "        }\n"
                + "        html{\n"
                + "            font-size: 62.5%;\n"
                + "        }\n"
                + "        body{\n"
                + "            font-size: 1.6rem;\n"
                + "        }\n"
                + "        header{\n"
                + "            display: flex;\n"
                + "            justify-content: center;\n"
                + "        }\n"
                + "        table{\n"
                + "            margin: 10px;\n"
                + "            padding: 5px;\n"
                + "            border-spacing: 30px;\n"
                + "            border-collapse: collapse;\n"
                + "        }\n"
                + "        .tableCheck {\n"
                + "            width: 75%;\n"
                + "        }\n"
                + "        .titleTable {\n"
                + "            text-align: center;\n"
                + "            color: #002D62;\n"
                + "            font-size: 1.5rem;\n"
                + "        }\n"
                + "        .infoTable {\n"
                + "            text-align: left;\n"
                + "        }\n"
                + "        .imgTable {\n"
                + "            text-align: center;\n"
                + "        }\n"
                + "        main {\n"
                + "            display: flex;\n"
                + "            justify-content: center;\n"
                + "        }\n"
                + "        .productTable{\n"
                + "            border-collapse: collapse;\n"
                + "            margin: 25px 0;\n"
                + "            min-width: 200px;\n"
                + "            width: 50%;\n"
                + "        }\n"
                + "        .productTable thead tr {\n"
                + "            background-color: #002D62;\n"
                + "            color: #ffffff;\n"
                + "            text-align: center;\n"
                + "        }\n"
                + "        .productTable th, .productTable td {\n"
                + "            padding: 12px 15px;\n"
                + "        }\n"
                + "        .productTable tbody tr {\n"
                + "            border-bottom: 1px solid #dddddd;\n"
                + "        }\n"
                + "        .productTable tbody tr:nth-of-type(even){\n"
                + "            background-color: #f3f3f3;\n"
                + "        }\n"
                + "        footer{\n"
                + "            display: flex;\n"
                + "            justify-content: center;\n"
                + "        }\n"
                + "    </style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <header>\n"
                + "        <table class=\"tableCheck\">\n"
                + "            <tr>\n"
                + "                <td width=\"300\" class=\"imgTable\">\n"
                + "                    <section>\n"
                + "                        <figure>\n"
                + "                            <img width=\"400\" height=\"200\" src=\"C:\\Users\\fi944\\OneDrive\\Escritorio\\Universidad\\IPC1\\Monkey.png\" alt=\"LOGO USAC MONKEY\">\n"
                + "                        </figure>\n"
                + "                    </section>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "        </table>\n"
                + "    </header>\n"
                + "    <main>\n"
                + "        <table class=\"productTable\">\n"
                + "            <thead>\n"
                + "                <tr>\n"
                + "                    <th>ÁREA</th>\n"
                + "                    <th>COSTO</th>\n"
                + "                    <th>TIEMPO</th>\n"
                + "                    <th>COSTO TOTAL</th>\n"
                + "                </tr>\n"
                + "            </thead>\n"
                + "            <tbody>\n"
                + "                <tr>\n"
                + "                    <td>INVENTARIO</td>\n"
                + "                    <td> Q. " + valueStorage + "</td>\n"
                + "                    <td>" + timeStorage + "</td>\n"
                + "                    <td> Q. " + totalStro + "</td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>PRODUCCIÓN</td>\n"
                + "                    <td> Q. " + valueProduction + "</td>\n"
                + "                    <td>" + timeProduction + "</td>\n"
                + "                    <td> Q. " + totalPro + "</td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>EMPAQUETADO</td>\n"
                + "                    <td> Q. " + valuePackaging + "</td>\n"
                + "                    <td>" + timePackaging + "</td>\n"
                + "                    <td> Q. " + totalPack + "</td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>SALIDA</td>\n"
                + "                    <td> Q. " + valueLeaving + "</td>\n"
                + "                    <td>" + timeLeaving + "</td>\n"
                + "                    <td> Q. " + totalLea + "</td>\n"
                + "                </tr>\n"
                + "            </tbody>\n"
                + "            <thead>\n"
                + "                <tr>\n"
                + "                    <th colspan=\"3\">TOTAL POR SERVICIO</th>\n"
                + "                    <th> Q. " + total + "</th>\n"
                + "                </tr>\n"
                + "            </thead>\n"
                + "        </table>\n"
                + "    </main>\n"
                + "    <footer>\n"
                + "        <p> EMITADA POR: USAC MONKEY </p>\n"
                + "    </footer>\n"
                + "</body>\n"
                + "</html>";
        return report;
    }

    public static void makeFile(String stringToFile) {
        try {
            String ruta = "C:\\Users\\fi944\\Downloads\\reporte.html";
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(stringToFile);
            bw.close();

            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

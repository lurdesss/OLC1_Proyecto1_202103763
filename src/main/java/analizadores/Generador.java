/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadores;

public class Generador {
    public static void main(String[] args) {
        compilar();
    }

    private static void compilar(){

        try {
            String ruta = "src/main/java/analizadores/";
            //ruta donde tenemos los archivos con extension .jflex y .cup
            String opcFlex[] = { ruta + "DataForge.jflex", "-d", ruta };
            jflex.Main.generate(opcFlex);
            String opcCUP[] = { "-destdir", ruta, "-parser", "Parser", ruta + "DataForge.cup" };
            java_cup.Main.main(opcCUP);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

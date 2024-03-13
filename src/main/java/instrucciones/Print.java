/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import java.util.LinkedList;
import static utilidades.Singleton.consola;

/**
 *
 * @author lurde
 */
public class Print implements Instruccion {
    LinkedList<String> list;
    public Print(LinkedList<String> list) {
        this.list = list;
    }
    

    @Override
    public void ejecutar() {
    for (int i = 0; i < this.list.size(); i++) {
        consola += this.list.get(i);
        if (i < this.list.size() - 1) {
            consola += ",";
        }
    }
    consola += "\n";
}
    
}

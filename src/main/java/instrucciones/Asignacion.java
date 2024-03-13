/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import static utilidades.Singleton.variables;

/**
 *
 * @author lurde
 */
public class Asignacion implements Instruccion {
    String id;
    String dato;

    public Asignacion(String id, String dato) {
        this.id = id;
        this.dato = dato;

    }

    public Asignacion(String id, int dato) {
        this.id = id;
        this.dato = String.valueOf(dato);
    }

    @Override
    public void ejecutar() {
        variables.put(this.id, this.dato);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

/**
 *
 * @author lurde
 */
public class Asignar implements Instruccion {
    private String id;
    private String dato;
    
    public Asignar(String id, String dato) {
        this.id = id;
        this.dato = dato;
    }

    @Override
    public void ejecutar() {
        // Aquí podrías realizar la lógica para asignar el valor a la variable
        System.out.println("Asignando " + valor + " a la variable " + variable);
        // Por ejemplo, podrías tener una tabla de símbolos donde guardar el valor asignado a la variable
    }
    
}

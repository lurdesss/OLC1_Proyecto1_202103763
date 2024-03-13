/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

/**
 *
 * @author lurde
 */
import static utilidades.Singleton.variables;
public class Utilidades {
    public String retornaVariable(String id){
        return variables.get(id);
    }
}

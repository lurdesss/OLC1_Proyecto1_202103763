package errores;

public class ErrorLexico {
    public String tipo; //Error Lexico / Sintactico
    public String descripcion; //Caracter no valido / declaracion invalida
    public String linea;
    public String columna;

    public ErrorLexico (String tipo, String descripcion, String linea, String columna){
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
    }
}

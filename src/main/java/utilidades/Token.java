package utilidades;

/**
 *
 * @author lurde
 */
public class Token {
    private String Nombre;
    private String Tipo;
    private String Valor;
    private String Fila;
    private String Columna;

    public Token(String Nombre, String Tipo, String Valor, int Fila, int Columna) {
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Valor = Valor;
        this.Fila = Fila + "";
        this.Columna = Columna + "";
    }
}

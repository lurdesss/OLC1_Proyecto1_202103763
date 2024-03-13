package errores;

public class ErrorSintactico {
    public String lexema;
    public int row;
    public int col;

    public ErrorSintactico(String lexema, int row, int col){
        this.lexema = lexema;
        this.row = row;
        this.col = col;
    }
}

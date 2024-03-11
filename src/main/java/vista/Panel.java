package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Panel extends JPanel {
    static JTextArea areaTexto;
    static JPanel panel;

    public Panel() {
        panel = new JPanel(new BorderLayout());
        JPanel cajas = new JPanel(new FlowLayout());

        // ------------------------- Crear un nuevo área de texto-----------------
        areaTexto = new JTextArea();

        // Establecer el texto y algunas propiedades del área de texto
        areaTexto.setEditable(true);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setRows(24);
        areaTexto.setColumns(42);
        // Agregar el área de texto a un panel con barra de desplazamiento
        JScrollPane panelTexto = new JScrollPane(areaTexto);
        panelTexto.setBorder(new EmptyBorder(10, 0, 10, 0));
        cajas.add(panelTexto); // Agregar el JScrollPane en lugar del área de texto directamente

        // --------------------------------Crear un JTextPane para mostrar el
        // texto-------------------------
        JTextArea salida = new JTextArea(); // consola de salida
        // Establecer el texto y algunas propiedades del área de texto
        salida.setEditable(false);
        salida.setLineWrap(true);
        salida.setWrapStyleWord(true);
        salida.setRows(24);
        salida.setColumns(42);

        // Agregar el área de texto a un panel con barra de desplazamiento
        JScrollPane panelTexto2 = new JScrollPane(salida);
        panelTexto2.setBorder(new EmptyBorder(10, 0, 10, 0));
        cajas.add(panelTexto2); // Agregar el JScrollPane en lugar del área de texto directamente
        add(cajas, BorderLayout.CENTER);

    }
}

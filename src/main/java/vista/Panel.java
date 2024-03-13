package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {
    static JTextArea areaTexto;
    static JPanel panel;

    public Panel() {
        panel = new JPanel(new BorderLayout());
        JPanel cajas = new JPanel(new BorderLayout()); // Cambiamos el LayoutManager a BorderLayout
        JPanel btn = new JPanel(new FlowLayout());

        // ------------------------- Crear un nuevo área de texto-----------------
        areaTexto = new JTextArea();

        // Establecer el texto y algunas propiedades del área de texto
        areaTexto.setEditable(true);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setRows(24);
        areaTexto.setColumns(42); // Ajusta el número de columnas para ajustar el tamaño
        // Agregar el área de texto a un panel con barra de desplazamiento
        JScrollPane panelTexto = new JScrollPane(areaTexto);
        panelTexto.setBorder(new EmptyBorder(10, 10, 10, 5));
        cajas.add(panelTexto, BorderLayout.WEST); // Agregamos el JScrollPane al oeste del panel

        // --------------------------------Crear un JTextPane para mostrar el
        // texto-------------------------
        JTextArea salida = new JTextArea(); // consola de salida
        // Establecer el texto y algunas propiedades del área de texto
        salida.setEditable(false);
        salida.setLineWrap(true);
        salida.setWrapStyleWord(true);
        salida.setRows(24);
        salida.setColumns(42); // Ajusta el número de columnas para ajustar el tamaño

        // Agregar el área de texto a un panel con barra de desplazamiento
        JScrollPane panelTexto2 = new JScrollPane(salida);
        panelTexto2.setBorder(new EmptyBorder(10, 5, 10, 10));
        cajas.add(panelTexto2, BorderLayout.EAST); // Agregamos el JScrollPane al este del panel
        
        JButton boton = new JButton("Ejecutar");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Esta función se ejecutará cuando se haga clic en el botón
                String consola = areaTexto.getText();
                salida.setText(consola);
                System.out.println("si");
                JOptionPane.showMessageDialog(panel,"¡Has hecho clic en el botón!");
            }
        });

        btn.add(boton);
        cajas.add(btn, BorderLayout.SOUTH); // Agregamos el botón al sur del panel cajas

        add(cajas, BorderLayout.CENTER);
    }
}
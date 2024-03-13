package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import static vista.Panel.areaTexto;

public class Root extends JFrame implements ActionListener {
    private String currentFile = null;
    // opciones de archivo
    JMenuItem nwarchivo;
    JMenuItem abrir;
    JMenuItem gdefault;
    JMenuItem limpiarc;
    // opciones de ejecucion
    JMenuItem ejecutaLSI; // ejecutar Lexico, Sintactico, Instrucciones
    // opciones de reportes
    JMenuItem rTokens; // reporte de tokens
    JMenuItem rErrores; // reporte de errores Lexicos / Sintacticos
    JMenuItem rTablaSmb; // reporte de tabla de simbolos
    static String ruta;
    private JLabel estadoArchivoLabel; // JLabel para mostrar el estado del archivo

    public Root() {
        setSize(1000, 540);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Data Forge");
        setLocationRelativeTo(null);
//        setResizable(false);

        JPanel contenedor = new JPanel();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        add(contenedor);

        // Creamos el JLabel
        estadoArchivoLabel = new JLabel("No hay archivo seleccionado"); // Texto predeterminado
        contenedor.add(estadoArchivoLabel); // Agregamos el JLabel al contenedor

        // Creamos el Panel
        Panel panel = new Panel();
        contenedor.add(panel); // Agregamos el Panel al contenedor

        JMenuBar menuBar = new JMenuBar();

        JMenu archivo = new JMenu("Archivo");

        nwarchivo = new JMenuItem("Nuevo archivo");
        abrir = new JMenuItem("Abrir archivo");
        gdefault = new JMenuItem("Guardar");
        limpiarc = new JMenuItem("Limpiar consola");

        archivo.add(nwarchivo);
        archivo.add(abrir);
        archivo.add(gdefault);
        archivo.add(limpiarc);

        abrir.addActionListener(this);
        gdefault.addActionListener(this);
        nwarchivo.addActionListener(this);
        limpiarc.addActionListener(e -> LimpiarConsola());

        menuBar.add(archivo);

        JMenu reportes = new JMenu("Reportes");
        rTokens = new JMenuItem("Reporte de Tokens");
        rErrores = new JMenuItem("Reporte de Errores Lexicos");
        rTablaSmb = new JMenuItem("Tabla de Simbolos");
        rTokens.addActionListener(this);
        rErrores.addActionListener(this);
        rTablaSmb.addActionListener(this);
        reportes.add(rTokens);
        reportes.add(rErrores);
        reportes.add(rTablaSmb);
        menuBar.add(reportes);
        
        setJMenuBar(menuBar);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == abrir) {
            JFileChooser fileChooser = new JFileChooser(new File("E:\\AAASEMESTRE2024\\compiladores1"));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos .df", "df"); // Filtro para archivos
            fileChooser.setFileFilter(filter); // Aplica el filtro al JFileChooser
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    // Leer el contenido del archivo
                    BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                    String line = null;
                    StringBuilder sb = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        sb.append("\n");
                    }
                    reader.close();
                    String content = sb.toString();

                    // Establecer el contenido del JTextArea
                    areaTexto.setText(content);
                    currentFile = fileChooser.getSelectedFile().getAbsolutePath();
                    ruta = fileChooser.getSelectedFile().getName();
                    estadoArchivoLabel.setText("Archivo cargado: " + ruta); // Actualizar el texto del JLabel
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == gdefault) {
            if (currentFile != null) {
                try {
                    // Guardar el contenido en el archivo actual
                    BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile));
                    writer.write(areaTexto.getText());
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                // Si no se ha especificado un archivo actual, muestra un cuadro de diálogo
                // "Nuevo Archivo"
                nuevoArchivo();
            }
        } else if (e.getSource() == nwarchivo) {
            nuevoArchivo();
        }
    }

    public String getCurrentFile() {
        return currentFile;
    }

    private void LimpiarConsola() {
        areaTexto.setText("");
    }

    public void nuevoArchivo() {
        JFileChooser fileChooser = new JFileChooser(new File("E:\\AAASEMESTRE2024\\compiladores1"));

        // Agregar filtro de extensión .df
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos .df", "df");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                // Obtener el archivo seleccionado
                File selectedFile = fileChooser.getSelectedFile();

                // Verificar si el nombre del archivo ya tiene la extensión .df
                String fileName = selectedFile.getName();
                if (!fileName.toLowerCase().endsWith(".df")) {
                    // Si no tiene la extensión, agregarla
                    selectedFile = new File(selectedFile.getAbsolutePath() + ".df");
                }

                // Guardar el contenido en el archivo seleccionado
                BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));
                writer.write(areaTexto.getText());
                writer.close();

                // Actualizar el estado del archivo
                currentFile = selectedFile.getAbsolutePath();
                ruta = selectedFile.getName();
                estadoArchivoLabel.setText("Archivo creado: " + ruta);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
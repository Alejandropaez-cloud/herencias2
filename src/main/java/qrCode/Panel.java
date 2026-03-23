/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrCode;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro Páez Milán 
 */
public class Panel extends JPanel {

    // Tamaño del panel. Constantes
    public static final int ANCHO_PANEL = 600;
    public static final int ALTO_PANEL = 200;

    // Atributos del panel
    private JButton btnGenerar, btnCerrar;
    private JLabel lblUrl, lblFichero, lblExtension;
    private JTextField tfUrl, tfFichero;
    private JRadioButton rbPng, rbJpg;
    private ButtonGroup bgExtension;
    private String nombreFichero;

    // Constructor 
    public Panel() {
        // Establece el layout del panel
        this.setLayout(new FlowLayout());
        // Establece el color del fondo del panel
        this.setBackground(Color.gray);
        // Establece el tamaño del panel
        this.setSize(ANCHO_PANEL, ALTO_PANEL);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Añade URL Label
        lblUrl = new JLabel("Introduce el texto: ");
        this.add(lblUrl);

        // Añade área de texto para la URL
        // Ancho de unos 40 caracteres aprox
        tfUrl = new JTextField(40);
        this.add(tfUrl);

        // Añade Fichero Label
        lblFichero = new JLabel("Nombre del fichero: ");
        this.add(lblFichero);

        // Añade área de texto para el nombre del fichero
        tfFichero = new JTextField(40);
        this.add(tfFichero);

        // Añade etiqueta para la extensión del fichero
        lblExtension = new JLabel("Extensión del fichero:");
        this.add(lblExtension);

        // Crear ButtonGroup para que los radio buttons sean mutuamente excluyentes
        // Esto asegura que solo uno de los JRadioButton pueda estar seleccionado a la vez
        bgExtension = new ButtonGroup();

        // Añade JRadioButton para PNG
        rbPng = new JRadioButton("png");
        rbPng.setSelected(true); // Por defecto seleccionado PNG
        bgExtension.add(rbPng); // Agregar al grupo para exclusión mutua
        this.add(rbPng);

        // Añade JRadioButton para JPG
        rbJpg = new JRadioButton("jpg");
        bgExtension.add(rbJpg); // Agregar al grupo para exclusión mutua
        this.add(rbJpg);

        // Añade el botón generar
        btnGenerar = new JButton("Generar código QR");
        this.add(btnGenerar);
        // Comportamiento del botón generar
        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Si el contenido de los textField no está vacío
                if (!tfUrl.getText().isEmpty()&&!tfFichero.getText().isEmpty()){
                    // Determinar la extensión seleccionada mediante los JRadioButton
                    // Si rbPng está seleccionado, usar "png"; de lo contrario, "jpg"
                    String extension = rbPng.isSelected() ? "png" : "jpg";
                    // Anexar la extensión al nombre del fichero para formar el nombre completo
                    String nombreCompleto = tfFichero.getText() + "." + extension;
                    // Genera el fichero con la imagen del QR en el formato seleccionado
                    // Llama al método escribirQR con el texto, nombre completo y formato
                    QR.escribirQR(tfUrl.getText(), nombreCompleto, extension);
                    // Abre una nueva ventana para mostrar el resultado
                    new VentanaResultado(nombreCompleto);
                } else {
                    JOptionPane.showMessageDialog(null, "No puede haber campos vacíos.");
                }
            }
        });
        // Añade botón cerrar
        btnCerrar = new JButton("Salir");
        this.add(btnCerrar);
        // Comportamiento del botón Cerrar
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }

}
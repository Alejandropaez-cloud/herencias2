package componentesbasicospanelesydistribuidores;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class Saludo extends JPanel {
    
    // Componentes gráficos: un botón y un area de texto
    private JButton boton;
    private JTextArea texto;
    
    public Saludo(){
        initComponenents();
    }

    private void initComponenents() {
        // Tamaño del panel
        this.setPreferredSize(new Dimension(600, 200));
        
        // Borde del panel
        this.setBorder(new TitledBorder("Borde del panel"));

        // Creamos el botón, con un texto a mostrar.
        boton = new JButton("Saludar");

        // Creamos el textArea de una fila po 25 columnas.
        texto = new JTextArea(1, 25);

        // Establecemos el color de fondo del textArea.
        texto.setBackground(Color.ORANGE);

        // Posicionamiento de componentes con FlowLayout
        this.setLayout(new FlowLayout());

        // Añadimos los componentes al panel.
        this.add(boton);
        this.add(texto);
    }
}

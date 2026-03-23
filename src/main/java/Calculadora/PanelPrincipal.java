package Calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Alejandro Páez Milán
 */

public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;
    private double primerOperando;
    private String operacion;
    private boolean nuevaEntrada;

    // Constructor
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
        nuevaEntrada = true;
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        // Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);
        // Agregar listeners a los botones
        for (JButton boton : botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.matches("[0-9]")) {
            if (nuevaEntrada) {
                areaTexto.setText(comando);
                nuevaEntrada = false;
            } else {
                areaTexto.append(comando);
            }
        } else if (comando.equals("+") || comando.equals("-") || comando.equals("*") || comando.equals("/")) {
            primerOperando = Double.parseDouble(areaTexto.getText());
            operacion = comando;
            nuevaEntrada = true;
        } else if (comando.equals("=")) {
            double segundoOperando = Double.parseDouble(areaTexto.getText());
            double resultado = 0;
            switch (operacion) {
                case "+":
                    resultado = primerOperando + segundoOperando;
                    break;
                case "-":
                    resultado = primerOperando - segundoOperando;
                    break;
                case "*":
                    resultado = primerOperando * segundoOperando;
                    break;
                case "/":
                    if (segundoOperando != 0) {
                        resultado = primerOperando / segundoOperando;
                    } else {
                        areaTexto.setText("Error");
                        return;
                    }
                    break;
            }
            areaTexto.setText(String.valueOf(resultado));
            nuevaEntrada = true;
        } else if (comando.equals("C")) {
            areaTexto.setText("");
            primerOperando = 0;
            operacion = null;
            nuevaEntrada = true;
        }
    }
}

package componentesbasicospanelesydistribuidores;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mipanel extends JPanel{
    // añadimos un componente de tipo etiqueta (JLabel)
    private JLabel etiqueta;

    // Constructor pasando un color, que llama al método initComponents()
    public Mipanel(Color color){
        initComponenents();
        cambiarColorFondo(color);
        
    }

    private void initComponenents() {
        // Construimos la etiqueta con el texto que queremos que muestre 
        etiqueta = new JLabel("Etiqueta de MiPanel");
        // Añade la etiqueta al contenedor MiPanel (al Panel)
        this.add(etiqueta);
    }

    private void cambiarColorFondo(Color color){
        // Establece el color de fondo del panel
        this.setBackground(color);
    }

    // Método getter
    public JLabel getEtiqueta(){
        return etiqueta;
    }
}

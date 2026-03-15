package componentesbasicospanelesydistribuidores;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
// JFrame es un contenedor y por lo tanto contiene en su interior componentes a estos componentes
// se les conoce como paneles (JPanel) la definición de estas sería ventanas internas que incluimos dentro 
// dentro de las ventanas principales (JFrame)


public class Test {
    public static void main(String[] args) {
        // Construimos la ventana.
        JFrame ventanaPrincipal = new JFrame("Aplicación");

        // Establecemos posición y tamaño.
        ventanaPrincipal.setBounds(250, 250, 800, 600);

        // Hacemos visible la ventana.
        ventanaPrincipal.setVisible(true);

        // Acción por defecto al pulsar el botón de cierre.
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecemos posición y tamaño 
        // ventaPrincipal.setBounds(250, 250, 800, 600);
        ventanaPrincipal.setSize(800, 600);
        ventanaPrincipal.setLocationRelativeTo(null);

        // Etablecemos el layout del JFrame 
        ventanaPrincipal.setLayout(new BorderLayout());

        // Añadimos los paneles en cada posición del BorderLayout

        // Añadir panel amarillo en la posición superior (North)
        ventanaPrincipal.add(new Mipanel(Color.yellow), BorderLayout.NORTH);

        // Añadir panel rojo en la posición inferior (South)
        ventanaPrincipal.add(new Mipanel(Color.red), BorderLayout.SOUTH);

        // Añadir panel gris en la posición central (Center)
        ventanaPrincipal.add(new Mipanel(Color.gray), BorderLayout.CENTER);

        // Añadir panel verde en la posición izquierda (West)
    	ventanaPrincipal.add(new Mipanel(Color.green), BorderLayout.WEST);

        // Añadir panel cián en la posición derecha (East)
    	ventanaPrincipal.add(new Mipanel(Color.cyan), BorderLayout.EAST);

        // Construimos la ventana.
        JFrame frame = new JFrame("App");
        
        // La ventana no se puede redimensionar
        frame.setResizable(false);

        // Posición de la ventana.
        frame.setLocationRelativeTo(null);

        // Incluimos el panel en la ventana.
        frame.add(frame, new PanelSaludo());

        //Ajusta el frame al contenido.
        frame.pack();

        // Hacemos visible la ventana.
        frame.setVisible(true);

        // Accion por defecto al pulsar el boton de cierre de la ventana.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

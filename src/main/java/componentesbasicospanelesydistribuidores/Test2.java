package componentesbasicospanelesydistribuidores;

import javax.swing.JFrame;

public class Test2 {
    public static void main(String[] args) {
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

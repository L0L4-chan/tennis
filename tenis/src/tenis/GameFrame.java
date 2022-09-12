package tenis;

import javax.swing.JFrame;
import java.awt.*;


public class GameFrame extends JFrame {
	/**
	 * automaticamente genrado
	 */
	private static final long serialVersionUID = -2928409580623053722L;
	// instanciamos panel  
	GamePanel panel;

	public GameFrame() {
		//  inicializamos
		 panel = new GamePanel();
		 //y damos caracteristicas a nuestra ventana
		 this.add(panel);// añadimos panel
		 this.setTitle("PONG GAME");// titulo
		 this.setResizable(false); // no se podra cambiar el tamaño
		 this.setBackground(Color.BLACK);// fondo negro
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);// operacion de cierre
		 this.setLocationRelativeTo(null);// donde aparecera
		 this.pack();// ventana construida alrededor del panel 
		
		 this.setVisible(true);// hacemos visible
		
		
		
		
	}
	
}

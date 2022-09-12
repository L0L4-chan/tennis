package tenis;

import java.awt.*;


public class Score extends Rectangle{
	
	/**
	 * automaticamente generado
	 */
	private static final long serialVersionUID = 6489912751946657912L;
	//variable de tamaño
	static int WIDTH;
	static int HEIGHT;
	// puntuaciones por jugador
	int player1;
	int player2;
	
	
	public Score(int width,int height) {
		
		//asignamso tamaño
		Score.WIDTH = width;
		Score.HEIGHT = height;
		
	}
	
	public void draw(Graphics g) {
		//dibujamos el marcador en la pantalla
		g.setColor(Color.YELLOW);//elegimon color
		g.setFont(new Font("Consolas", Font.PLAIN,60));//elegimos letra
		// texto que se muestra
		//a
		//g.drawString("Blue: "+ player1 + " Red: " + player2, (WIDTH/2)-250, 50);
		//b
		//g.drawString(String.valueOf(player1), (WIDTH/2)-85, 50);
		//g.drawString(String.valueOf(player2), (WIDTH/2)+20, 50);
		//c
		g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (WIDTH/2)-85, 50);
		g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (WIDTH/2)+20, 50);
				
		g.setColor(Color.white);
		g.drawLine(WIDTH/2, 0, WIDTH/2, HEIGHT);// linea en el medio que divide la pantalla
		
	}

}

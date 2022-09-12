package tenis;

import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle{
	/**
	 * automaticamente generado
	 */
	private static final long serialVersionUID = -8479327744194740125L;
	//variables
	int id; // para saber si es la paleta derecha o la izquierda
	int yVelocity; // posiciones que mueve en el eje de la y
	int speed = 15;// cuantos pixeles se mueve
	
	
	public Paddle(int x,int y, int width,int heigth,int id) {
		super(x,y,width,heigth);// constructor de rectangle la superclase
		this.id = id;//asignamos id
		
		
		
	}
	
	public void keyPressed(KeyEvent e) {
		
		switch(id) {
		case 1:// si es el judador 1 azul
			if(e.getKeyCode()==KeyEvent.VK_W) {// si la tecla es la w
				setYDirection(-speed);// nos movemos en la y hacia arriba
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {// si la tecla es la s
				setYDirection(speed);// nos movemos en la y hacia abajo
				move();
			}
			break;
		
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {// si la tecla es la w
				setYDirection(-speed);// nos movemos en la y hacia arriba
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {// si la tecla es la s
				setYDirection(speed);// nos movemos en la y hacia abajo
				move();
			}
			break;
			
		}
		
	}
	
	public void keyRelease(KeyEvent e) {
		

		switch(id) {
		case 1:// si es el judador 1 azul
			if(e.getKeyCode()==KeyEvent.VK_W) {// si la tecla es la w
				setYDirection(0);// 
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {// si la tecla es la s
				setYDirection(0);// 
				move();
			}
			break;
		
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {// si la tecla es la w
				setYDirection(0);// 
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {// si la tecla es la s
				setYDirection(0);// 
				move();
			}
			break;
			
		}
	}
	
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	
	public void move() {
		y = y + yVelocity;
	}

	public void draw(Graphics g) {
		// establecemos graphics
		
		if(id==1 ) {
			// set color
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}else {
			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);
		}
		
	}
}

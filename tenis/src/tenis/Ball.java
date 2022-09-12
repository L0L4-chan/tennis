package tenis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball extends Rectangle{

	/**
	 * automaticamente generado
	 */
	private static final long serialVersionUID = -8662252651761503239L;
	//variables
	Random random;// instancia de random
	int xVelocity;// coordenada x hacia la que se dirige
	int yVelocity;//coordenada y hacia la que se dirige
	int inicialspeed = 2;// velocidad de movimiento de la bola
	//constructor
 public Ball(int x, int y, int width, int heigth) {
	 super(x,y,width,heigth);// superclase constructor
	 //inicializamos 
	 random= new Random();
	 int randomXDirec = random.nextInt(2);//local 1 sera derecha 0 izquierda
	 if (randomXDirec==0) {
		 randomXDirec--;
		 }// nos movemos a la izquierda
		 setXDirection(randomXDirec*inicialspeed);// cambiamos direccion
	int randomYDirec = random.nextInt(2);//local 1 sera derecha 0 izquierda
	if (randomYDirec==0) {
		 randomYDirec--;// nos movemos a la izquierda
		 }
		 setYDirection(randomYDirec*inicialspeed);// cambiamos direccion
			 	 
 }
 
 public void setXDirection(int randomXDirection) {
	 xVelocity = randomXDirection;
 }
 
public void setYDirection(int randomYdirection) {
	 yVelocity = randomYdirection;
 }
 
public void move() {
	// movimiento de la pelota
	x += xVelocity;//
	y += yVelocity;//
}

public void draw(Graphics g) {
	// configuramos los graficos de la pelota
	g.setColor(Color.white);
	g.fillOval(x, y, width, height);
}

}

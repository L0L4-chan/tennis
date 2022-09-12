package tenis;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class GamePanel extends JPanel implements Runnable{
	/**
	 * automaticamente generado
	 */
	private static final long serialVersionUID = -1871576967260596486L;
	//variables
	//alto y ancho
	static final int WIDTH = 1200;//ancho del panel que actuara de mesa
	static final int HEIGHT =(int)( WIDTH* (.5555));// ratio de una mesa de pingpong 
	// dimension o tamaño de las cuadriculas
	static final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);
	// dimensiones de la pelota y las raquetas
	static final int BALL_DIAMETER = 20;//diametro de la bola
	static final int PADDLE_WIDTH =25;//ancho de la raqueta
	static final int PADDLE_HEIGHT =100;//largo de la raqueta
	
	// variables que se necesitan
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1;
	Paddle paddle2;
	Ball ball;
	Score score;

//constructor	
	public GamePanel() {
		newPaddle();//cramos raquetas
		newBall();//creamos bola
		
		score = new Score(WIDTH,HEIGHT);//creamos marcador/es
		
		this.setFocusable(true);//revisar en la api
		this.addKeyListener(new AL());// asjudicamos quien recibira las acciones triggered por el teclado
		this.setPreferredSize(SCREEN_SIZE);// damos dimensiones
		
		gameThread = new Thread(this);
		gameThread.start();
				
		
		
	}
	
	public void newBall() {
		//inicializamos  la pelota y la situamos
		/*ball = new Ball((WIDTH/2)-(BALL_DIAMETER/2),
				(HEIGHT/2)-(BALL_DIAMETER/2),
				BALL_DIAMETER,BALL_DIAMETER);*/
		// para que aparezca en cualquier parte de la pantalla
		// inicializamos
		random = new Random();
		ball= new Ball((WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
	}
	
	public void newPaddle() {
		//inicializamos variables de las raquetas y  donde lo colocamos
		paddle1 = new Paddle(0,(HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH, PADDLE_HEIGHT,1);
		//
		
		paddle2= new Paddle((WIDTH-PADDLE_WIDTH),(HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH, PADDLE_HEIGHT,2);
		
	}
	
	public void paint(Graphics g) {
		// añadimos una imagen
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		//añadimos la imagen al panel
		draw(graphics);
		g.drawImage(image,0,0,this);
		
		
		
	}
	public void draw(Graphics g) {
		// dibujamos las raquetas
		paddle1.draw(g);
		paddle2.draw(g);
		
		//dibujamos la pelota
		ball.draw(g);
		
		// dibujamos el marcador
		score.draw(g);
	}
	
	public void move() {
		// para mejorar el movimiento lo actualizmos
		paddle1.move();
		paddle2.move();
		
		ball.move();
	}
	
	public void checkCollision() {
		
		// movimiento de la pelota en los limites del panel
		if (ball.y <=0) {ball.setYDirection(-ball.yVelocity);};//top
		if (ball.y >=HEIGHT-BALL_DIAMETER) {ball.setYDirection(-ball.yVelocity);}//botton
		
		
		//rebotes en las raquetas
		if (ball.intersects(paddle1)) 
		{
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //aumenta la velocidad tras rebote
			if (ball.yVelocity>0) {
				ball.yVelocity++;
			}else {ball.yVelocity--;}
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		 }
		
		if (ball.intersects(paddle2)) 
		{
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //aumenta la velocidad tras rebote
			if (ball.yVelocity>0) {
				ball.yVelocity++;
			}else {ball.yVelocity--;}
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		
		
		
		//evitar que las raquetas salgan del marco
		if(paddle1.y<= 0) {paddle1.y=0;}
		if(paddle1.y>=HEIGHT-PADDLE_HEIGHT) {paddle1.y = HEIGHT-PADDLE_HEIGHT;}
		
		if(paddle2.y<= 0) {paddle2.y=0;}
		if(paddle2.y>=HEIGHT-PADDLE_HEIGHT) {paddle2.y = HEIGHT-PADDLE_HEIGHT;}
		
		//como se obtiene los puntos
		if(ball.x<=0) {
			score.player2++;
			newPaddle();
			newBall();	
			// test
			//System.out.println("Jugador rojo puntuacion; " + score.player2);
		}
		
		if (ball.x>= WIDTH-BALL_DIAMETER) {
			score.player1++;
			newPaddle();
			newBall();	
			// test
		//	System.out.println("Jugador rojo puntuacion; " + score.player1);
		}
		
		
	}
	
	public void run() {
		//game loop pendiente de investigar y mejorar
		long lastTime = System.nanoTime();// ahora pasado
		double amountOfTicks = 60.0;//  
		double ns = 1000000000/ amountOfTicks;// nanosegundos
		double delta = 0;//aux
		while(true) {//bucle
			long now= System.nanoTime();//ahora presente
			delta += (now-lastTime)/ns;//auxiliar aumenta la diferencia de tiempos entre los ns 
			lastTime = now;//actualizamos el valor del ahora pasado
			
			if (delta>= 1) {// si nuestra auxiliar el uno o mayor
				move();// movemos		
				checkCollision();//comprobamos colisiones
				repaint();// actualizamos la imagen en el panel
				delta--; // reseteamos el auxiliar
				
			}
			
		}
		
		
		
	}

	public class AL extends KeyAdapter{
		
		public void keyPressed(KeyEvent e) {
			// movimiento de las raquetas
			paddle1.keyPressed(e);//llave presionada
			paddle2.keyPressed(e);
			
		}
		
		public void keyRelease(KeyEvent e) {
			// movimiento de las raquetas
			paddle1.keyRelease(e);
			paddle2.keyRelease(e);
		}
	}
}

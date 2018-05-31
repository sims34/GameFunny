package com.sims.JavaHub;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Main Frame
 * extends JFrame
 * @author simon_bens
 * Thread lessons on teacher du net and newboston
 */
public class JavaGame extends JFrame implements Runnable{
	
	int x,y, xDirection, yDirection;
	

	//create a buffer image & graphics
	private Image dbImage;
	private Graphics dbGraphics;
	Image face;
	
	//set run method for thread
	//the speed of the main program	
	@Override
	public void run() {
		try {
			//through a while loop we control how fast is the run method
			while(true){
				//ask constantly to check the move() method
				move();
				//ask to the run method to stop for millisecond
				// it's kind of control of the speed compute of the program
				// more > millisecond more the program is slow
				Thread.sleep(100);
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	//method update into the thread
	public void move(){
		//x & y move depend of xDirection/yDirection
		x+= xDirection;
		y+= yDirection;
		
		//collision detection
		if(x <= 0)
			x = 0;
		if(x >=310)
			x = 310;
		if(y<= 20)
			y = 20;
		if(y >= 310)
			y = 310;
	}
	//set xDirection/yDirection
	public void setxDirection(int xDirection) {
		this.xDirection = xDirection;
	}
	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
	}
	
	//action listener on keyboard
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			//stock the value of the button pressed
			int keyCode = e.getKeyCode();
			if(keyCode == e.VK_LEFT){
				//move to left on x axe
				setxDirection(-1);
			}
			if(keyCode == e.VK_RIGHT){
				//move to right side
				setxDirection(+1);	
			}
			if(keyCode == e.VK_UP){
				setyDirection(-1);
			}
			if(keyCode == e.VK_DOWN){
				setyDirection(+1);
			}				
		}
		public void keyReleased(KeyEvent e){
			int keyCode = e.getKeyCode();
			if(keyCode == e.VK_LEFT){
				setxDirection(0);	
			}
			if(keyCode == e.VK_RIGHT){
				setxDirection(0);	
			}
			if(keyCode == e.VK_UP){
				setyDirection(0);	
			}
			if(keyCode == e.VK_DOWN){
				setyDirection(0);	
			}
		}
	}
	
	//constructor
	public JavaGame() {
		//load image set the path
		ImageIcon imgIcon = new ImageIcon("C:/Users/simon_bens/workspace/GameHobby/src/com/sims/JavaHub/face.png");
		face = imgIcon.getImage();
		
		//add key listener
		addKeyListener(new AL());
		setTitle("Java Game Engine");
		setSize(450,450);
		setBackground(Color.CYAN);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x = 150;
		y = 150;
	}
	/**
	 * this method it's to paint an image
	 * out of the main screen ==> we don't see
	 * set this image in buffer in the memory
	 * and call the simple method of graphics class :
	 * drawImage() => in parameters our main screen
	 * we past our image in buffer (out of screen) to the main screen
	 */
	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight()); //get with & height of the oval object
		dbGraphics = dbImage.getGraphics(); //get the graphics of the image
		paintComponents(dbGraphics); //send this graphics to the method to display it
		g.drawImage(dbImage, 0, 0, this); //send all to the main screen
	}
	//add color to frame
	// want do something on the screen call Graphics class
	public void paintComponent(Graphics g){
		
	//	g.setColor(Color.RED);
		g.drawImage(face, x, y, this);
		
		//update the object graphic
		repaint();
	}
	
	public static void main(String[] args) {
		//thread
	 	Thread t1 = new Thread(new JavaGame());
	 	t1.start();

	}
	

}

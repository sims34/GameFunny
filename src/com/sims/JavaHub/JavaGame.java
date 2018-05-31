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
public class JavaGame extends JFrame{
	
	int x,y;
	//create a buffer image & graphics
	private Image dbImage;
	private Graphics dbGraphics;
	Image face;
	
	
	//action listener on keyboard
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			//stock the value of the button pressed
			int keyCode = e.getKeyCode();
			if(keyCode == e.VK_LEFT){
				if(x <= 0){
					x = 0;
				}else{
					//x and y start on haut à gauche
					x+= -5;
				}
				
			}
			if(keyCode == e.VK_RIGHT){
				if(x >=310){
					x = 310;
				}else{
					x+= +5;
				}
				
			}
			if(keyCode == e.VK_UP){
				if(y<= 20){
					y = 20;
				}else{
					y+= -5;
				}
			
			}
			if(keyCode == e.VK_DOWN){
				if(y >= 310){
					y = 310;
				}else{
					y+= +5;
				}
			}				
		}
		public void keyReleased(KeyEvent e){
			
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
	public void paintComponents(Graphics g){
		
	//	g.setColor(Color.RED);
		g.drawImage(face, x, y, this);
		
		//update the object graphic
		repaint();
	}
	
	public static void main(String[] args) {
		new JavaGame();

	}

}

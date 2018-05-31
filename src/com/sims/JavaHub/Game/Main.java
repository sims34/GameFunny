package com.sims.JavaHub.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	private static final int WIDTH = 400;
	private static final int HEIGTH = 300;
	private Image imgBuffer;
	private Graphics graphicBuffer;
	private int x,y;
	private boolean mouseOnScreen;
	
	
	public class Mouse extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			int xCoord = e.getX();
			int yCoord = e.getY();
			x = xCoord-7;
			y = yCoord-7;
		}
		public void mouseReleased(MouseEvent e){
			
		}
		//mouse into the screen 
		public void mouseEntered(MouseEvent e){
			mouseOnScreen = true;
		}
		//mouse outside of the screen
		public void mouseExited(MouseEvent e){
			mouseOnScreen = false;
		}
	}
	
	public Main() { 
		//listener
		addMouseListener(new Mouse());
		setSize(WIDTH, HEIGTH);
		setTitle("Game");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.x = 15;
		this.y = 15;
		
	}
	public void paint(Graphics g){
		imgBuffer = createImage(getWidth(), getHeight());
		graphicBuffer = imgBuffer.getGraphics();
		paintComponent(graphicBuffer);
		g.drawImage(imgBuffer, 0,0, this);
	}
	
	public void paintComponent(Graphics g) {
		g.fillOval(this.x, this.y, 15, 15);
		g.setColor(Color.RED);
		//print the coordanate on the screen
		if(mouseOnScreen)
			g.drawString("Coord : ("+x+", "+y+")",80, 100);
		repaint();
	}
	public static void main(String[] args) {
		new Main();

	}

}

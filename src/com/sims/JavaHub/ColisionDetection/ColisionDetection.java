package com.sims.JavaHub.ColisionDetection;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import org.w3c.dom.css.Rect;



public class ColisionDetection extends JFrame{

	private static final int WIDTH = 400;
	private static final int HEIGTH = 300;
	private Image imgBuffer;
	private Graphics graphicBuffer;
	private int rectX,rectY;
	
	//class ActionListener
	public class AL extends MouseAdapter{
		@Override
		public void mouseMoved(MouseEvent e) {
			rectX = e.getX()-12;
			rectY = e.getY()-12;
			
		}
	}
	
	public ColisionDetection() {
		addMouseMotionListener(new AL());
		setSize(WIDTH, HEIGTH);
		setTitle("Game");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
	}
	public void paint(Graphics g){
		imgBuffer = createImage(getWidth(), getHeight());
		graphicBuffer = imgBuffer.getGraphics();
		paintComponent(graphicBuffer);
		g.drawImage(imgBuffer, 0,0, this);
	}
	
	public void paintComponent(Graphics g) {
		//create 2 rectangle one attack and one no move
		Rectangle rectMove = new Rectangle(rectX,rectY,25,25);
		Rectangle rectNoMove = new Rectangle(175,75,50,50);
		g.setColor(Color.RED);
		g.fillRect(rectNoMove.x, rectNoMove.y, rectNoMove.width, rectNoMove.height);
		//set color
		g.setColor(Color.BLUE);
		//fill rectangle
		g.fillRect(rectMove.x, rectMove.y, rectMove.width, rectMove.height);
		
		if(rectMove.intersects(rectNoMove)){
			g.drawString("Colision !! ", 80, 80);
		}
		
		repaint();
	}
	
	public static void main(String[] args) {
		new ColisionDetection();

	}


}

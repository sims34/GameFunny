package com.sims.JavaHub.Basic.template;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

public class Main extends JFrame{
	private static final int WIDTH = 400;
	private static final int HEIGTH = 300;
	private Image imgBuffer;
	private Graphics graphicBuffer;
	private int x,y;
	
	//class ActionListener

	
	public Main() {
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
		
		repaint();
	}
	
	public static void main(String[] args) {
		new Main();

	}

}

package com.sims.JavaHub.MouseMotion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import com.sims.JavaHub.Basic.template.Main;

public class Mouse extends JFrame implements MouseMotionListener{

	private static final int WIDTH = 400;
	private static final int HEIGTH = 300;
	private Image imgBuffer;
	private Graphics graphicBuffer;
	private int mx,my;
	private boolean mouseDragged;

	public Mouse() {
		setSize(WIDTH, HEIGTH);
		setTitle("Game");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseMotionListener(this);
		
		
	}
	@Override
	//mouse move on the screen + button pressed
	public void mouseDragged(MouseEvent e) {
		mx = e.getX()-10; //centrer le curseur au milieu du carre
		my =e.getY()-10;
		mouseDragged = true;
		e.consume();
		
	}
	@Override
	//only move on the screen
	public void mouseMoved(MouseEvent e) {
		mx = e.getX()-10;
		my =e.getY()-10;
		mouseDragged = false;
		e.consume();
		
	}

	public void paint(Graphics g){
		imgBuffer = createImage(getWidth(), getHeight());
		graphicBuffer = imgBuffer.getGraphics();
		paintComponent(graphicBuffer);
		g.drawImage(imgBuffer, 0,0, this);
	}
	
	public void paintComponent(Graphics g) {
		if(mouseDragged){
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 0, getWidth(), getHeight()); //kind of background with color
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(mx, my, 20, 20);
		}else{
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, getWidth(), getHeight()); //kind of background with color
			g.setColor(Color.DARK_GRAY);
			g.fillRect(mx, my, 20, 20);
		}
			
		repaint();
	}
	
	public static void main(String[] args) {
		new Mouse();

	}
	
}

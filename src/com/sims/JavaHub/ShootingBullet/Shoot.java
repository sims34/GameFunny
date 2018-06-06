package com.sims.JavaHub.ShootingBullet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Shoot extends JFrame{
	private Image imgBuffer;
	private Graphics gphBuffer;
	static Ship myShip;
	
	public Shoot() {
		inintFrame();
		addKeyListener(new AL());
		myShip = new Ship();
	}
	
	//create main frame
	private void inintFrame(){
		//frame
		setSize(450, 300);
		setTitle("Shoot Ship");
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g){
		imgBuffer = createImage(getWidth(),getHeight());
		gphBuffer = imgBuffer.getGraphics();
		paintComponents(gphBuffer);
		g.drawImage(imgBuffer, 0, 0, this);
	}
	public void paintComponents(Graphics g){
		//method draw of the ship class
		myShip.draw(g);
		repaint();
	}
	
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			myShip.keyPressed(e);
		}
		public void keyReleased(KeyEvent e){
			myShip.keyReleased(e);
		}
	}
	public static void main(String[] args) {
		new Shoot();
		Thread tShip = new Thread(myShip);
		tShip.start();
	}

}

















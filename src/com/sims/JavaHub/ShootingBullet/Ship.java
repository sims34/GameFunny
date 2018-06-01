package com.sims.JavaHub.ShootingBullet;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Ship extends JFrame  {
	private static final int WIDTH = 400;
	private static final int HEIGTH = 300;
	private int x,y,xDirection;
	public Ship() {
	
		this.x = 175;
		this.y  = 275;
	}
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 40, 10);
		g.fillRect(x+18, y-7, 4, 7);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

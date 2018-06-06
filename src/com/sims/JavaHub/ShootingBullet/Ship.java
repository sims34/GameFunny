package com.sims.JavaHub.ShootingBullet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import org.w3c.dom.css.Rect;

public class Ship implements Runnable{
	private int x,y,xDirection;
	private boolean readyToFire, shot =false;
	
	private Rectangle bullet;
	private int bulletX,bulletY;
	public Ship() {
		this.x =175;
		this.y = 275;
	}
	public void draw(Graphics g){
		//boaat
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 40, 10);
		g.fillRect(x+18, y-7, 4, 7);
		if(shot){
			g.setColor(Color.YELLOW);
			g.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);
		}
	}
	//detection colision 
	public void move(){
		x += xDirection;
		if(x <= 0) x=0;
		if(x >= 360) x =360;
		
	}
	public void setxDirection(int xDirection) {
		this.xDirection = xDirection;
	}
	
	//key action
	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
		//move on screen
		if(keyCode == e.VK_LEFT) setxDirection(-1);
		if(keyCode == e.VK_RIGHT) setxDirection(1);
		//attack bullet
		if(keyCode == e.VK_SPACE){
			readyToShootGunner();
		}
	}
	
	private void readyToShootGunner() {
		if(bullet ==null) readyToFire =true;
		if(readyToFire){
			bulletX = x+18;
			bulletY =  y-7;
			bullet= new Rectangle(bulletX, bulletY, 3, 5);
			shot = true;
		}
	}
	public void keyReleased(KeyEvent e){
		int keyCode = e.getKeyCode();
		//move on screen
		if(keyCode == e.VK_LEFT) setxDirection(0);
		if(keyCode == e.VK_RIGHT) setxDirection(0);
		//attack bullet
		if(keyCode == e.VK_SPACE){
			stopToShootCunner();
				
			}
		}
	private void stopToShootCunner() {
		readyToFire = false;
		if(bullet.y <=-5){
			bullet = new Rectangle(0, 0, 0, 0);
			shot = false;
			readyToFire = true;
		}
	}
	public void gunner(){
		if(shot) bullet.y --;
	}
	@Override
	public void run() {
		//main loop
		try {
			while (true) {
				gunner();
				move();
				Thread.sleep(5);		
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	

}

package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;

// a class to make new objects in the game

public abstract class GameObject {

	protected float x, y; //use protected so other extended classes can use (inherited)
	protected ID id;
	protected float velX, velY;
	
	//constructor
	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick(); // it's abstract so we can call it in another class and add code	
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void setId(ID id){
		this.id = id;
	}
	public ID getId(){
		return id;
	}
	public void setVelX(int velX){
		this.velX = velX;
	}
	public void setVelY(int velY){
		this.velY = velY;
	}
	public float getVelX(){
		return velX;
	}
	public float getVelY(){
		return velY;
	}
}

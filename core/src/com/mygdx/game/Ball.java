package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Ball {
	
	private Vector2 position;


    public int stopBall=0;
    public float ballSpeed = 5;
    public int xAxisDiredtion = 1;
    public int yAxisDiredtion = 1;
    
    private double deg_x = 1;
    private double deg_y = 1;
    
    private int radius = 30;
    
	
    public Ball(int x ,int y) {
		position = new Vector2(x,y);
	}
    
    public void move () {
		position.x += ballSpeed*xAxisDiredtion*stopBall*deg_x;
		position.y += ballSpeed*yAxisDiredtion*stopBall*deg_y;
	}
    
    public void setToInit() {
    	position.x = HockeyGame.screenWidth/2;
    	position.y = HockeyGame.screenHeight/2; 
    	ballSpeed = 5;
    	deg_x = 1;
    	deg_y = 1;
    }

	public Vector2 getPosition() {
		return position;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void start() {
		stopBall = 1;
	}
	
	public void stop()
	{
		stopBall = 0;
	}
	public void changeDirXAxis() {
		xAxisDiredtion *= -1;
	}
	
	public void changeDirToUp() {
		yAxisDiredtion = 1;
	}
	
	public void changeDirToDown() {
		yAxisDiredtion = -1;
	}
	
	
	public void increaseSpeed() {
		ballSpeed += 0.5 ;
	}
	
	public float getSpeed() {
		return ballSpeed;
	}
	


	public void changeDegree(Vector2 objectPosition, Vector2 ballPosition) {
		double degree =  Math.atan((objectPosition.x-ballPosition.x)/(objectPosition.y-ballPosition.y));
		deg_x =  Math.sin(degree);
		deg_y = Math.cos(degree);

	}
	
}


	
    
	
    
	
	
	

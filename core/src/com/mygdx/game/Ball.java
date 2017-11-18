package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Ball {
	
	private Vector2 position;


    public int stop_ball=0;
    public float BALL_SPEED = 5;
    public int X_AXIS_DIRECTION = 1;
    public int Y_AXIS_DIRECTION = 1;
    
    private double deg_x = 1;
    private double deg_y = 1;
    
    private int radius = 30;
    
	
    public Ball(int x ,int y) {
		position = new Vector2(x,y);
	}
    
    public void move () {
		position.x += BALL_SPEED*X_AXIS_DIRECTION*stop_ball*deg_x;
		position.y += BALL_SPEED*Y_AXIS_DIRECTION*stop_ball*deg_y;
	}
    
    public void set_to_init() {
    	position.x = HockeyGame.SC_WIDTH/2;
    	position.y = HockeyGame.SC_HEIGHT/2; 
    	BALL_SPEED = 5;
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
		stop_ball = 1;
	}
	
	public void stop()
	{
		stop_ball = 0;
	}
	public void CHANGE_DIR_X_AXIS() {
		X_AXIS_DIRECTION *= -1;
	}
	
	public void CHANGE_DIR_TO_UP() {
		Y_AXIS_DIRECTION = 1;
	}
	
	public void CHANGE_DIR_TO_DOWN() {
		Y_AXIS_DIRECTION = -1;
	}
	
	
	public void INCREASE_SPEED() {
		BALL_SPEED += 0.5 ;
	}
	
	public float getSpeed() {
		return BALL_SPEED;
	}
	


	public void change_deg(Vector2 obj_pos, Vector2 ball_pos) {
		double degree =  Math.atan((obj_pos.x-ball_pos.x)/(obj_pos.y-ball_pos.y));
		deg_x =  Math.sin(degree);
		deg_y = Math.cos(degree);

	}
	
}


	
    
	
    
	
	
	

package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Ball {
	
	private Vector2 position;


    
    public int BALL_SPEED = 2;
    public int X_AXIS_DIRECTION = 1;
    public int Y_AXIS_DIRECTION = 1;
	
    public Ball(int x ,int y) {
		position = new Vector2(x,y);
	}
    
    public void move () {
		position.x += BALL_SPEED*X_AXIS_DIRECTION;
		position.y += BALL_SPEED*Y_AXIS_DIRECTION;
	}
    

	public Vector2 getPosition() {
		return position;
	}
	
	public void CHANGE_DIR_X_AXIS() {
		X_AXIS_DIRECTION *= -1;
	}
	
	public void CHANGE_DIR_Y_AXIS() {
		Y_AXIS_DIRECTION *= -1;
	}
	
	public void INCREASE_SPEED() {
		BALL_SPEED +=0.5 ;
	}
	
	public int getSpeed() {
		return BALL_SPEED;
	}
		
	
}


	
    
	
    
	
	
	
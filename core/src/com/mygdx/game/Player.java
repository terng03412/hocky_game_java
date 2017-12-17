package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Player {

	private Vector2 position;

    public static final int dirRight = 1;
    public static final int dirLeft = 2;
    public static final int dirStill = 0;
    private int speed =7;
    
    
    private int radius = 40;
    
    public int getRadius() {
    	return radius;
    }
    
   
	private static final int [][] dirOffsets = new int [][] {
		{0,0},
		{1,0},
        {-1,0}
    };
    
	public Player(int x ,int y) {
		position = new Vector2(x,y);
	}
	
	public void move (int dir) {
		position.x += speed*dirOffsets[dir][0]; 
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	 public void setToInit() {
		 position.x = HockeyGame.screenWidth/2;
	 }
	    
		
}

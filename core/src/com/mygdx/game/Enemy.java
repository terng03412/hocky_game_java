package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Enemy {

	private Vector2 position;

    public static final int dirRight = 1;
    public static final int dirLeft = 2;
    public static final int dirStill = 0;
    private float enemySpeed = 4;
    
    public int radius = 40;
    
	private static final int [][] dirOffsets = new int [][] {
		{0,0},
		{1,0},
        {-1,0}
    };
    
	public Enemy(int x ,int y) {
		position = new Vector2(x,y);
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setSpeedToInit() {
		enemySpeed  = 4;
	}
	
	public void move (int dir) {
		position.x += enemySpeed*dirOffsets[dir][0]; 
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public void increaseSpeed() {
		enemySpeed += 0.2; // win rate 45 per
	}
		
}



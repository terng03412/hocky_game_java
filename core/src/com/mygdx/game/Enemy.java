package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Enemy {

	private Vector2 position;

    public static final int DIRECTION_RIGHT = 1;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_STILL = 0;
    private int enemy_speed = 2;
    
	private static final int [][] DIR_OFFSETS = new int [][] {
		{0,0},
		{1,0},
        {-1,0}
    };
    
	public Enemy(int x ,int y) {
		position = new Vector2(x,y);
	}
	
	public void move (int dir) {
		position.x += enemy_speed*DIR_OFFSETS[dir][0]; 
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public void increase_speed() {
		enemy_speed += 1;
	}
		
}



package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	
	private HockeyGame hockeyGame;
	private SpriteBatch batch;
	private World world;
	private Texture playerImg;

	public WorldRenderer(HockeyGame hockeyGame, World world) {
	        this.hockeyGame = hockeyGame;
	        batch = hockeyGame.batch;
	 
	        this.world = world;
	 
	        playerImg = new Texture("player.png");
	    }
	
	public void render(float delta) {
		
		SpriteBatch batch = hockeyGame.batch;
		
		Player player = world.getPlayer();
		batch.begin();
		Vector2 pos = player.getPosition();
		batch.draw(playerImg, pos.x ,pos.y);
		batch.end();
	
	}
	

}

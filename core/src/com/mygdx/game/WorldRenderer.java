package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	
	private HockeyGame hockeyGame;
	private SpriteBatch batch;
	private World world;
	
	private Texture playerImg;
	private Texture ballImg;
	private Texture enemyImg;
	private Texture randomObjImg;
	
	private BitmapFont font;
	
	public WorldRenderer(HockeyGame hockeyGame, World world) {
	        this.hockeyGame = hockeyGame;
	        batch = hockeyGame.batch;
	 
	        this.world = world;
	 
	        playerImg = new Texture("base.gif");
	        ballImg = new Texture("ball.gif");
	        enemyImg = new Texture("base.gif");
	        
	        font = new BitmapFont();

	}
	
	public void render(float delta) {
		
		SpriteBatch batch = hockeyGame.batch;
		
		Player player = world.getPlayer();
		Ball ball = world.getBall();
		Enemy enemy = world.getEnemy();

		
		batch.begin();
		
		Vector2 player_pos = player.getPosition();
		Vector2 ball_pos = ball.getPosition();
		Vector2 enemy_pos = enemy.getPosition();
		
		
		batch.draw(playerImg, player_pos.x ,player_pos.y);
		batch.draw(ballImg, ball_pos.x ,ball_pos.y);
		batch.draw(enemyImg, enemy_pos.x, enemy_pos.y);
		
		font.draw(batch, "My score " + world.get_myScore() + "   Opponent Score  " + world.get_opScore() ,180, 40);
		
		
		batch.end();
	
	}
	

}

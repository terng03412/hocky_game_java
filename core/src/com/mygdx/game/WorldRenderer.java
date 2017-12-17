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
	private Texture bgImg;
	
	private int i=0;
	
	private BitmapFont font;
	private Texture introImg;
	private Texture winImg;
	private Texture loseImg;
	
	public WorldRenderer(HockeyGame hockeyGame, World world) {
	        this.hockeyGame = hockeyGame;
	        batch = hockeyGame.batch;
	 
	        this.world = world;
	 
	        playerImg = new Texture("base.gif");
	        ballImg = new Texture("ball.gif");
	        enemyImg = new Texture("base.gif");
	        bgImg = new Texture("bg.gif");
	        introImg = new Texture("intro.gif");
	        winImg = new Texture("win.gif");
	        loseImg = new Texture("lose.gif");
	        
	        
	        font = new BitmapFont();

	}
	

	

	
	public void render(float delta) {
		
		SpriteBatch batch = hockeyGame.batch;
		
		Player player = world.getPlayer();
		Ball ball = world.getBall();
		Enemy enemy = world.getEnemy();

		if(world.gameState==world.playState) {
			batch.begin();
			
			
			Vector2 playerPosition = player.getPosition();
			Vector2 ballPosition = ball.getPosition();
			Vector2 enemyPosition = enemy.getPosition();
			
			batch.draw(bgImg, 0 , 0);
			batch.draw(playerImg, playerPosition.x ,playerPosition.y);
			batch.draw(ballImg, ballPosition.x ,ballPosition.y);
			batch.draw(enemyImg, enemyPosition.x, enemyPosition.y);
			
			font.draw(batch, "My score " + world.getMyScore() + "   Opponent Score  " + world.getOppScore() ,180, 40);
			
			
			batch.end();
		}
		if(world.gameState == world.introState)
		{
			batch.begin();
			batch.draw(introImg, 0 , 0);
			batch.end();
			
		}
		if(world.gameState == world.winState)
		{
			batch.begin();
			batch.draw(winImg, 0 , 0);
			batch.end();
		}
		if(world.gameState == world.loseState)
		{
			batch.begin();
			batch.draw(loseImg, 0 , 0);
			batch.end();
		}
		
	}
	

}

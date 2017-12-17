package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter{

	private HockeyGame hockeyGame;
	
	private Texture playerImg;
	private Texture ballImg;
	private Texture enemyImg;
	private Texture randomObjImg;
	
	
	World world;
	WorldRenderer worldRenderer;
	
	private Player player;
	private Ball ball;
	private Enemy enemy;

	private Vector2 enemyPosition;

	private Vector2 ballPosition;

	private Vector2 playerPosition;

	
	
	
	public GameScreen(HockeyGame hockeyGame) {
		this.hockeyGame = hockeyGame ;

		world = new World(hockeyGame);
		worldRenderer = new WorldRenderer(hockeyGame , world);
		
		playerImg = new Texture("base.gif");
		ballImg = new Texture("ball.gif");
		enemyImg = new Texture("base.gif");
		

	}
	
	private double distance(Vector2 obj1 , Vector2 obj2) {
		double disX = Math.pow((obj1.x-obj2.x), 2);
		double disY = Math.pow((obj1.y-obj2.y), 2);
		
		return Math.sqrt(disX + disY);
	}
	
	public void update(float delta) {
		
		if(world.gameState==world.introState | world.gameState==world.winState | world.gameState==world.loseState) {
			if(Gdx.input.isKeyPressed(Keys.SPACE))
			{
				world.ChangeToGame();
				world.Restart();
			}
		}
		
		
	
		if(world.gameState==world.playState) {
			player = world.getPlayer();
			ball = world.getBall();
			enemy = world.getEnemy();
	
			playerPosition = player.getPosition();
			ballPosition = ball.getPosition();
			enemyPosition = enemy.getPosition();
			
			
//		-----------------------------------------------------Control
			if(Gdx.input.isKeyPressed(Keys.LEFT)) {
				player.move(player.dirLeft);
				ball.start();	
			}
			else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
				player.move(player.dirRight);
				ball.start();
			}
			else {
				player.move(player.dirStill);	
			}
		
	//		------------------------------------------------------
			
	//BOUNCE WALL		
			if(ballPosition.x<50) {
				ball.changeDirXAxis();
			}
			else if(ballPosition.x > HockeyGame.screenWidth-100) {
				ball.changeDirXAxis();
			}
			
			ball.move();
	
			//--------------------------------------------
			//BOUNCE PLAYER
			
	
			if(distance(playerPosition , ballPosition)<player.getRadius()+ball.getRadius()
					) {
				
				ball.changeDegree(playerPosition,ballPosition);
				
				ball.changeDirToUp();
				ball.changeDirXAxis();
				
				ball.increaseSpeed();
				ball.move();
				
				enemy.increaseSpeed();
				
				
			}
			
	//		----------------------------------------------------
			//BOUNCE ENEMY
			
			if(distance(enemyPosition , ballPosition)<enemy.getRadius()+ball.getRadius())
			{
				
				ball.changeDegree(enemyPosition,ballPosition);
				ball.changeDirToDown();
				ball.changeDirXAxis();
				ball.increaseSpeed();
				ball.move();
				
				enemy.increaseSpeed();
				
	
			}
	//--------------------- bot 
			if(enemyPosition.x>ballPosition.x & ballPosition.y > HockeyGame.screenHeight*4/7) {
				enemy.move(enemy.dirLeft);
			}
			else if(enemyPosition.x < ballPosition.x & ballPosition.y > HockeyGame.screenHeight/2) {
				enemy.move(enemy.dirRight);
			}
			//-----------------------------------------------------
			//increase score
			if( ballPosition.y<100) {
				ball.stop(); 
				ball.setToInit();
				enemy.setSpeedToInit();
				player.setToInit();
				world.increaseOppScore();
			}
			
			if(ballPosition.y > HockeyGame.screenHeight-100 ) {
				ball.stop();
				ball.setToInit();
				enemy.setSpeedToInit();
				player.setToInit();
				world.increaseMySpeed();
			}
		}
		
		
		
	
	}
	
	@Override
	public void render(float delta) {
		
		update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
		worldRenderer.render(delta);
		
	}
	
	
}

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
	
	World world;
	WorldRenderer worldRenderer;
	
	private Player player;
	private Ball ball;
	private Enemy enemy;
	
	private int player_width = 50;
	private int player_height = 40;
	
	private int enemy_width = 50;
	private int enemy_height = 40;
	
	public GameScreen(HockeyGame hockeyGame) {
		this.hockeyGame = hockeyGame ;
		
		playerImg = new Texture("base.gif");
		ballImg = new Texture("player.png");
		enemyImg = new Texture("base.gif");
		
		
		world = new World(hockeyGame);
		worldRenderer = new WorldRenderer(hockeyGame , world);
	}
	
	public void update(float delta) {
		
		player = world.getPlayer();
		ball = world.getBall();
		enemy = world.getEnemy();
		
//		-----------------------------------------------------
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			player.move(player.DIRECTION_LEFT);
			ball.start();
			
		}
		else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			player.move(player.DIRECTION_RIGHT);
			ball.start();
		}
		else {
			player.move(player.DIRECTION_STILL);	
		}
//		------------------------------------------------------
		Vector2 ball_pos = ball.getPosition();
		
		
		if(ball_pos.x<100) {
			ball.CHANGE_DIR_X_AXIS();
		}
		else if(ball_pos.x > 400) {
			ball.CHANGE_DIR_X_AXIS();
		}
		
		ball.move();
//		----------------------------------------------------
		Vector2 player_pos = player.getPosition();
		
		if(ball_pos.x < player_pos.x+player_width 
				& ball_pos.x > player_pos.x-player_width 
				& ball_pos.y < player_pos.y+player_height
				) {
			ball.CHANGE_DIR_Y_AXIS();
			ball.INCREASE_SPEED();
			ball.move();
			enemy.increase_speed();
		}
		
//		----------------------------------------------------
		Vector2 enemy_pos = enemy.getPosition();
		
		if(ball_pos.x < enemy_pos.x+enemy_width 
				& ball_pos.x > enemy_pos.x-enemy_width 
				& ball_pos.y > enemy_pos.y-enemy_height
				) {
			ball.CHANGE_DIR_Y_AXIS();
			ball.INCREASE_SPEED();
			ball.move();
			enemy.increase_speed();
		}
		
		if(enemy_pos.x>ball_pos.x) {
			enemy.move(2);
		}
		else if(enemy_pos.x < ball_pos.x) {
			enemy.move(1);
		}
		
		
		if(ball_pos.y > 730 || ball_pos.y<70) {
			ball.stop();
			ball.set_to_init();
			enemy.set_speed_toInit();
			
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

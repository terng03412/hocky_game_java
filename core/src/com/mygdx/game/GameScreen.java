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

	
	private int player_width = 60;
	private int player_height = 20;
	
	private int enemy_width = 60;
	private int enemy_height = 30;
	
	public GameScreen(HockeyGame hockeyGame) {
		this.hockeyGame = hockeyGame ;

		world = new World(hockeyGame);
		worldRenderer = new WorldRenderer(hockeyGame , world);
		
		playerImg = new Texture("base.gif");
		ballImg = new Texture(worldRenderer.getText_color());
		enemyImg = new Texture("base.gif");
		

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
		
		if(Gdx.input.isKeyPressed(Keys.S)) {
			ball.slow();
		}
		
		if(Gdx.input.isKeyPressed(Keys.I)) {
			ball.INCREASE_SPEED();
		}
		
		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
			ball.CHANGE_DIR_X_AXIS();
		}
		
//		debug------- bot mode
//		Vector2 player_pos = player.getPosition();
//		Vector2 ball_pos = ball.getPosition();
//------------
//		
//		if(player_pos.x>ball_pos.x) {
//			player.move(player.DIRECTION_LEFT);
//		}
//		else if(player_pos.x < ball_pos.x) {
//			player.move(player.DIRECTION_RIGHT);
//		}
//		
//		------------------------------------------------------
		Vector2 ball_pos = ball.getPosition();
		//debug
		
		if(ball_pos.x<100) {
			ball.CHANGE_DIR_X_AXIS();
		}
		else if(ball_pos.x > HockeyGame.SC_WIDTH-100) {
			ball.CHANGE_DIR_X_AXIS();
		}
		
		ball.move();

		//--------------------------------------------
		Vector2 player_pos = player.getPosition();
		//debug
		
		if(ball_pos.x < player_pos.x+player_width+20
				& ball_pos.x > player_pos.x-player_width-20
				& ball_pos.y < player_pos.y+player_height
				& ball_pos.y > player_pos.y-10
				) {
			ball.CHANGE_DIR_Y_AXIS();
			ball.INCREASE_SPEED();
			ball.move();
			enemy.increase_speed();
			worldRenderer.changeBallImg();
			
			
		}
		
//		----------------------------------------------------
		Vector2 enemy_pos = enemy.getPosition();
		
		if(ball_pos.x < enemy_pos.x+enemy_width
				& ball_pos.x > enemy_pos.x-enemy_width
				& ball_pos.y > enemy_pos.y-enemy_height-10
				& ball_pos.y < enemy_pos.y+10
				) {
			ball.CHANGE_DIR_Y_AXIS();
			ball.INCREASE_SPEED();
			ball.move();
			enemy.increase_speed();
			
			worldRenderer.changeBallImg();
			

		}
		
		if(enemy_pos.x>ball_pos.x) {
			enemy.move(2);
		}
		else if(enemy_pos.x < ball_pos.x) {
			enemy.move(1);
		}
		
		//increase score
		if( ball_pos.y<100) {
			ball.stop(); 
			
//			debug
			ball.set_to_init();
//			ball.move();
			
			enemy.set_speed_toInit();
			
			world.increase_opponent_score();
		}
		
		if(ball_pos.y > HockeyGame.SC_HEIGHT-100 ) {
			ball.stop();
			ball.set_to_init();
			
//			debug
//			ball.move();
			
			enemy.set_speed_toInit();
			
			world.increase_my_score();
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

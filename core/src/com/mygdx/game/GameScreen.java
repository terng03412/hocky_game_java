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

	private Vector2 enemy_pos;

	private Vector2 ball_pos;

	private Vector2 player_pos;

	
	
	
	public GameScreen(HockeyGame hockeyGame) {
		this.hockeyGame = hockeyGame ;

		world = new World(hockeyGame);
		worldRenderer = new WorldRenderer(hockeyGame , world);
		
		playerImg = new Texture("base.gif");
		ballImg = new Texture(worldRenderer.getText_color());
		enemyImg = new Texture("base.gif");
		

	}
	
	private double distance(Vector2 obj1 , Vector2 obj2) {
		double dis_x = Math.pow((obj1.x-obj2.x), 2);
		double dis_y = Math.pow((obj1.y-obj2.y), 2);
		
		return Math.sqrt(dis_x + dis_y);
	}
	
	public void update(float delta) {
		
		player = world.getPlayer();
		ball = world.getBall();
		enemy = world.getEnemy();

		player_pos = player.getPosition();
		ball_pos = ball.getPosition();
		enemy_pos = enemy.getPosition();
		
//		-----------------------------------------------------Control
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
		
//BOUNCE WALL		
		if(ball_pos.x<100) {
			ball.CHANGE_DIR_X_AXIS();
		}
		else if(ball_pos.x > HockeyGame.SC_WIDTH-100) {
			ball.CHANGE_DIR_X_AXIS();
		}
		
		ball.move();

		//--------------------------------------------
		//BOUNCE PLAYER
		

		if(distance(player_pos , ball_pos)<player.getRadius()+ball.getRadius()
				) {
			
			ball.change_deg(player_pos,ball_pos);
			
			ball.CHANGE_DIR_TO_UP();
			ball.CHANGE_DIR_X_AXIS();
			
			ball.INCREASE_SPEED();
			ball.move();
			
			enemy.increase_speed();
			
			
		}
		
//		----------------------------------------------------
		//BOUNCE ENEMY
		
		if(distance(enemy_pos , ball_pos)<enemy.getRadius()+ball.getRadius())
		{
			
			ball.change_deg(enemy_pos,ball_pos);
			ball.CHANGE_DIR_TO_DOWN();
			ball.CHANGE_DIR_X_AXIS();
			ball.INCREASE_SPEED();
			ball.move();
			
			enemy.increase_speed();
			worldRenderer.changeBallImg();
			

		}
//--------------------- bot 
		if(enemy_pos.x>ball_pos.x & ball_pos.y > HockeyGame.SC_HEIGHT*4/7) {
			enemy.move(enemy.DIRECTION_LEFT);
		}
		else if(enemy_pos.x < ball_pos.x & ball_pos.y > HockeyGame.SC_HEIGHT/2) {
			enemy.move(enemy.DIRECTION_RIGHT);
		}
		//-----------------------------------------------------
		//increase score
		if( ball_pos.y<100) {
			ball.stop(); 
			ball.set_to_init();
			enemy.set_speed_toInit();
			world.increase_opponent_score();
		}
		
		if(ball_pos.y > HockeyGame.SC_HEIGHT-100 ) {
			ball.stop();
			ball.set_to_init();
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

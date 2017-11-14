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
	
	World world;
	WorldRenderer worldRenderer;
	
	private Player player;
	private Ball ball;
	private int player_width = 20;
	private int player_height = 20;
	
	
	public GameScreen(HockeyGame hockeyGame) {
		this.hockeyGame = hockeyGame ;
		
		playerImg = new Texture("player.png");
		ballImg = new Texture("player.png");
		
		world = new World(hockeyGame);
		worldRenderer = new WorldRenderer(hockeyGame , world);
	}
	
	public void update(float delta) {
		
		player = world.getPlayer();
		ball = world.getBall();
		
//		-----------------------------------------------------
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			player.move(player.DIRECTION_LEFT);
		}
		else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			player.move(player.DIRECTION_RIGHT);
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

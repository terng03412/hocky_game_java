package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter{

	private HockeyGame hockeyGame;
	private Texture playerImg;
	private Player player;
	
	public GameScreen(HockeyGame hockeyGame) {
		this.hockeyGame = hockeyGame ;
		playerImg = new Texture("player.png");
		
		player = new Player(100,100);
	}
	
	public void update(float delta) {

		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			player.move(player.DIRECTION_LEFT);
		}
		else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			player.move(player.DIRECTION_RIGHT);
		}
		else {
			player.move(player.DIRECTION_STILL);
			
		}
		
		
	
	
	}
	
	@Override
	public void render(float delta) {
		
		update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
		SpriteBatch batch = hockeyGame.batch;
		
		batch.begin();
		Vector2 pos = player.getPosition();
		batch.draw(playerImg, pos.x ,pos.y);
		batch.end();
	}
	
	
}

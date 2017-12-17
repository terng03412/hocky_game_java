package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HockeyGame extends Game {
	public SpriteBatch batch;
	Texture img;
	
	public static final int screenHeight = 800;
	public static final int screenWidth = 500;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
		
	}

	@Override
	public void render () {
		super.render();
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

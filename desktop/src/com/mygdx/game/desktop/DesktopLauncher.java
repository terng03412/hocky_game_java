package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.HockeyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = HockeyGame.screenWidth;
		config.height = HockeyGame.screenHeight;
		
		
		new LwjglApplication(new HockeyGame(), config);
	
		
	}
}

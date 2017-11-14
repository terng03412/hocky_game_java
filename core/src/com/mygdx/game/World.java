package com.mygdx.game;

public class World {
	private Player player;
	private Ball ball;
	private Enemy enemy;
	
	private HockeyGame hockeyGame;
	
	World(HockeyGame hockeyGame){
		this.hockeyGame = hockeyGame;
		
		player = new Player(HockeyGame.SC_WIDTH/2, 100);
		ball = new Ball(HockeyGame.SC_WIDTH/2,HockeyGame.SC_HEIGHT/2);
		enemy = new Enemy(HockeyGame.SC_WIDTH/2, HockeyGame.SC_HEIGHT-100);
	}
	Player getPlayer() {
		return player;
	}
	
	Ball getBall() {
		return ball;
	}
	
	Enemy getEnemy() {
		return enemy;
	}
}

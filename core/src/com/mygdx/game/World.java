package com.mygdx.game;

public class World {
	private Player player;
	private Ball ball;
	private Enemy enemy;
	
	private HockeyGame hockeyGame;
	
	World(HockeyGame hockeyGame){
		this.hockeyGame = hockeyGame;
		
		player = new Player(250, 100);
		ball = new Ball(250,400);
		enemy = new Enemy(250, 700);
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

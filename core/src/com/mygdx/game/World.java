package com.mygdx.game;

public class World {
	private Player player;
	private Ball ball;
	private HockeyGame hockeyGame;
	
	World(HockeyGame hockeyGame){
		this.hockeyGame = hockeyGame;
		
		player = new Player(250, 100);
		ball = new Ball(250,400);
	}
	Player getPlayer() {
		return player;
	}
	
	Ball getBall() {
		return ball;
	}
}

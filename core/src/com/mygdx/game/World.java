package com.mygdx.game;

public class World {
	private Player player;
	private HockeyGame hockeyGame;
	
	World(HockeyGame hockeyGame){
		this.hockeyGame = hockeyGame;
		
		player = new Player(100, 100);
	}
	Player getPlayer() {
		return player;
	}
}

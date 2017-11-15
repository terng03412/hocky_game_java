package com.mygdx.game;

public class World {
	private Player player;
	private Ball ball;
	private Enemy enemy;
	private int player_score = 0;
	private int opponent_score = 0;
	
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
	
	public void increase_my_score() {
		player_score += 1;
	}
	
	public void increase_opponent_score() {
		opponent_score += 1;
	}
	
	public int get_myScore() {
		return player_score;
	}
	
	public int get_opScore() {
		return opponent_score;
	}
	
	
	Ball getBall() {
		return ball;
	}
	
	Enemy getEnemy() {
		return enemy;
	}
}

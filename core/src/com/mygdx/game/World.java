package com.mygdx.game;


public class World {
	private Player player;
	private Ball ball;
	private Enemy enemy;
	
	private int player_score = 0;
	private int opponent_score = 0;
	
	private HockeyGame hockeyGame;
	
	public static final int introState = 0;
 	public static final int playState = 1;
 	public static final int winState = 2;
 	public static final int loseState = 3;
 	
 	public int gameState = introState;
	
	World(HockeyGame hockeyGame){
		this.hockeyGame = hockeyGame;
		
		player = new Player(HockeyGame.SC_WIDTH/2, 100);
		ball = new Ball(HockeyGame.SC_WIDTH/2,HockeyGame.SC_HEIGHT/2);
		enemy = new Enemy(HockeyGame.SC_WIDTH/2, HockeyGame.SC_HEIGHT-100);
		
	
	}
	
	public void ChangeToGame() {
		gameState = playState;
	}
	
	public void ChangeToWin() {
		gameState = winState;
	}
	
	public void ChangeToLose() {
		gameState = loseState;
	}
	
	public void ChangeToIntro() {
		gameState = introState;
	}
	
	public void Restart() {
		gameState = playState;
		player_score = 0;
		opponent_score = 0;
	}
	
	Player getPlayer() {
		return player;
	}
	

	public void increase_my_score() {
		player_score += 1;
		if(player_score >= 5) {
			ChangeToWin();
		}
	}
	
	public void increase_opponent_score() {
		opponent_score += 1;
		if(opponent_score >= 5) {
			ChangeToLose();
		}
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

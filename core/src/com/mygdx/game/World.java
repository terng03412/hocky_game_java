package com.mygdx.game;


public class World {
	private Player player;
	private Ball ball;
	private Enemy enemy;
	
	private int playerScore = 0;
	private int opponentScore = 0;
	
	private HockeyGame hockeyGame;
	
	public static final int introState = 0;
 	public static final int playState = 1;
 	public static final int winState = 2;
 	public static final int loseState = 3;
 	
 	public int gameState = introState;
	
	World(HockeyGame hockeyGame){
		this.hockeyGame = hockeyGame;
		
		player = new Player(HockeyGame.screenWidth/2, 100);
		ball = new Ball(HockeyGame.screenWidth/2,HockeyGame.screenHeight/2);
		enemy = new Enemy(HockeyGame.screenWidth/2, HockeyGame.screenHeight-100);
		
	
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
		playerScore = 0;
		opponentScore = 0;
	}
	
	Player getPlayer() {
		return player;
	}
	

	public void increaseMySpeed() {
		playerScore += 1;
		if(playerScore >= 5) {
			ChangeToWin();
		}
	}
	
	public void increaseOppScore() {
		opponentScore += 1;
		if(opponentScore >= 5) {
			ChangeToLose();
		}
	}
	
	public int getMyScore() {
		return playerScore;
	}
	
	public int getOppScore() {
		return opponentScore;
	}
	
	
	Ball getBall() {
		return ball;
	}
	
	Enemy getEnemy() {
		return enemy;
	}
}

package com.poscodx.springstudy;

import com.poscodx.springstudy.game.GameRunner;
import com.poscodx.springstudy.game.MarioGame;
import com.poscodx.springstudy.game.PacmanGame;
import com.poscodx.springstudy.game.SuperContraGame;

public class App01GamingBasic {

	public static void main(String[] args) {
		var game = new PacmanGame();
//		var game = new MarioGame();
//		var game = new SuperContraGame();
		var gameRunner = new GameRunner(game);
		gameRunner.run();
	}

}

package com.poscodx.springstudy.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //spring이 관리할 component
@Qualifier("pacman")
public class PacmanGame implements GamingConsole {
	
	@Override
	public void up() {
		System.out.println("pacman up");
	}

	@Override
	public void down() {
		System.out.println("down");

	}

	@Override
	public void left() {
		System.out.println("left");

	}

	@Override
	public void right() {
		System.out.println("right");

	}

}

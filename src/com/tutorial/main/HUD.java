package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int HEALTH = 100;
	private int greenValue = 255; // full green

	private int score = 0;
	private int level = 1;
	
	public void tick() {
		HEALTH = Utils.clamp(HEALTH, 0, 100);
		greenValue = Utils.clamp(greenValue, 0, 255);
		greenValue = HEALTH * 2;
		
		score++;
		if(score % 100 == 0) {
			level++;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(15, 15, 200, 32);

		g.setColor(new Color(255 - greenValue, greenValue, 0));
		g.fillRect(15, 15, HEALTH*2, 32);
		
		g.setColor(Color.WHITE);
		g.drawRect(15, 15, 200, 32);
		
		// TODO import font
		g.drawString("SCORE: " + score, 15, 64);
		g.drawString("LEVEL: " + level, 15, 80);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}

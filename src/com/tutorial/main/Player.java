package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	
	Random r = new Random();
	Handler handler;

	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick() {
		x+= velX;
		y+= velY;
		
		x = Utils.clamp(x, 0, Game.WIDTH - 36);
		y = Utils.clamp(y, 0, Game.HEIGHT - 60);
		
		handler.addObject(new Trail(x,y,ID.TRAIL,Color.white,32,32,0.05f,handler));
		
		collisionCheck();
		
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y, 32, 32);
		
		Graphics2D g2d = (Graphics2D)g;
		g.setColor(Color.GREEN);
		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}
	
	private void collisionCheck() {
		for(GameObject gObj:handler.object) {
			if(gObj.id==ID.ENEMY || gObj.id == ID.FASTENEMY || gObj.id == ID.SMARTENEMY){
				if(getBounds().intersects(gObj.getBounds())) {
					// collide code
					HUD.HEALTH -= 2;
				}
			}
		}
	}
	
}

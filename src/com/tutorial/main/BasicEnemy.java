package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {
	
	private Handler handler;

	public BasicEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		velX = 5;
		velY = 5;
		this.handler = handler;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if(y<=0 || y>=Game.HEIGHT-32) {
			velY *= -1;
		}
		if(x<=0 || x>=Game.WIDTH-32) {
			velX *= -1;
		}
		
		handler.addObject(new Trail(x,y,ID.TRAIL,Color.red,16,16,0.02f,handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)x, (int)y, 16, 16);
		
		Graphics2D g2d = (Graphics2D)g;
		g.setColor(Color.GREEN);
		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,16,16);
	}

}

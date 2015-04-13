package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {

	private Handler handler;
	private GameObject player;

	public SmartEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;
		for (GameObject gObj : handler.object) {
			if (gObj.getId() == ID.PLAYER) {
				player = gObj;
			}
		}
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float) Math.sqrt(((x - player.getX())*(x - player.getX())) + ((y - player.getY())*(y - player.getY())) );
		
		velX = (int) ((-1.0/distance) * diffX);
		velY = (int) ((-1.0/distance) * diffY);

		if (y <= 0 || y >= Game.HEIGHT - 32) {
			velY *= -1;
		}
		if (x <= 0 || x >= Game.WIDTH - 32) {
			velX *= -1;
		}

		handler.addObject(new Trail(x, y, ID.TRAIL, Color.cyan, 16, 16, 0.02f, handler));

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int)x, (int)y, 16, 16);

		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.RED);
		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
}

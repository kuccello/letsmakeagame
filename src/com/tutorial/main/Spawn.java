package com.tutorial.main;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private int lastLevel = 0;
	
	public Spawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		if(hud.getLevel() > lastLevel) {
			lastLevel = hud.getLevel();
			
			if(hud.getLevel() % 4 == 0) {
				// do spawn
				spawnFastEnemy();
			} else if(hud.getLevel() % 5 == 0) {
				spawnSmartEnemy();
			} else {
				spawnEnemy();
			}
			
		}
	}
	
	private void spawnFastEnemy() {
		handler.addObject(new FastEnemy(Utils.nextInt(Game.WIDTH),Utils.nextInt(Game.HEIGHT),ID.ENEMY,handler));
	}

	public void spawnEnemy() {
		handler.addObject(new BasicEnemy(Utils.nextInt(Game.WIDTH),Utils.nextInt(Game.HEIGHT),ID.ENEMY,handler));
	}
	
	public void spawnSmartEnemy() {
		handler.addObject(new SmartEnemy(Utils.nextInt(Game.WIDTH),Utils.nextInt(Game.HEIGHT),ID.ENEMY,handler));
	}
	
}

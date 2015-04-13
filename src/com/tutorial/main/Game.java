package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * 
 * @author kucce_000
 *
 */
public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1233345234542345L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	
	public static void main(String[] args) {
		new Game();
	}
	
	public Game() {
		handler = new Handler();
		hud = new HUD();
		spawner = new Spawn(handler, hud);
		
		this.addKeyListener(new KeyInput(handler));

		handler.addObject(new Player(100,100,ID.PLAYER,handler));

		new Window(WIDTH, HEIGHT, "Let's Build a Game", this);
	}

	@Override
	public void run() {
		this.requestFocus();
		
		// Standard game loop

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0f;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
		
	}
	
	private void tick() {
		// TODO Auto-generated method stub
		handler.tick();
		hud.tick();
		spawner.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3); // tripple buffer
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		hud.render(g);
		
		g.dispose();
		bs.show();
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try{
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		keyDown[0] = false; // w
		keyDown[1] = false; // s
		keyDown[2] = false; // d
		keyDown[3] = false; // a
	}

	@Override
	public void keyTyped(KeyEvent e) {
		super.keyTyped(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		
		int key = e.getKeyCode();
		
		for(GameObject gObj:handler.object) {
			if(gObj.getId() == ID.PLAYER) {
				// check key events for player 1
				
				if(key == KeyEvent.VK_W) {gObj.setVelY(-5); keyDown[0] = true;}
				if(key == KeyEvent.VK_S) {gObj.setVelY(5); keyDown[1] = true;}
				if(key == KeyEvent.VK_D) {gObj.setVelX(5); keyDown[2] = true;}
				if(key == KeyEvent.VK_A) {gObj.setVelX(-5); keyDown[3] = true;}
				
				
				break;
			}
		}
		
//		System.out.println("KEY Pressed: " + key);
		
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		
		
		int key = e.getKeyCode();
		
		
		for(GameObject gObj:handler.object) {
			if(gObj.getId() == ID.PLAYER) {
				// check key events for player 1
				
				if(key == KeyEvent.VK_W) keyDown[0] = false; //gObj.setVelY(0);
				if(key == KeyEvent.VK_S) keyDown[1] = false; //gObj.setVelY(0);
				if(key == KeyEvent.VK_D) keyDown[2] = false; //gObj.setVelX(0);
				if(key == KeyEvent.VK_A) keyDown[3] = false; //gObj.setVelX(0);
				
				// vertical movement
				if(!keyDown[0] && !keyDown[1]) gObj.setVelY(0);
				if(!keyDown[2] && !keyDown[3]) gObj.setVelX(0);
				
				break;
			}
		}
		
		System.out.println("KEY Released: " + key);
	}

	
	
}

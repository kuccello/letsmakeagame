package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

// manage GOs
public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		for(int i=0;i<object.size();i++){
			object.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		for (GameObject gObj:object) {
			gObj.render(g);
		}
	}
	
	public void addObject(GameObject gObj) {
		object.add(gObj);
	}
	
	public void removeObject(GameObject gObj) {
		object.remove(gObj);
	}
	
}

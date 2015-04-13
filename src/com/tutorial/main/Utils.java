package com.tutorial.main;

import java.util.Random;

public class Utils {
	
	private static Random r = new Random(System.currentTimeMillis());

	public static int nextInt(int rangeMax) {
		return r.nextInt(rangeMax);
	}
	
	public static float clamp(float var, float min, float max) {
		if(var>=max) {
			return var = max;
		} else if (var <=min) {
			return var = min;
		} else {
			return var;
		}
	}
	
	public static int clamp(int var, int min, int max) {
		if(var>=max) {
			return var = max;
		} else if (var <=min) {
			return var = min;
		} else {
			return var;
		}
	}
	
}

package com.skeggib.Tools;

public abstract class MathHelper {

	public static double round(double x, int decimals) {
		if (decimals < 0)
			decimals = 0;

		double mult = Math.pow(10.0, decimals);
		
		return Math.round(x * mult) / mult;
	}

	public static float round(float x, int decimals) {
		if (decimals < 0)
			decimals = 0;

		double mult = Math.pow(10.0, decimals);
		
		return Math.round(x * mult) / (float)mult;
	}

}
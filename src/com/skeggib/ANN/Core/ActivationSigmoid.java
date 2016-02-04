package com.skeggib.ANN.Core;

public class ActivationSigmoid implements ActivationFunction {

	private double threshold;

	public ActivationSigmoid() {
		
	}

	public ActivationSigmoid(ActivationSigmoid sigmoid) {
		this();
	}

	public double activation(double input) {
		return 1 / (1 + Math.pow(Math.E, -input));
	}

	public void setThreshold(double threshold) {
		// Do nothing
	}

}
package com.skeggib.ANN.Core.Neuron;

public class ActivationLinear implements ActivationFunction {

	private double threshold;

	public ActivationLinear() {
		
	}

	public ActivationLinear(ActivationLinear linear) {
		this();
	}

	public double activation(double input) {
		return input;
	}

	public void setThreshold(double threshold) {
		// Do nothing
	}

	public String toString() {
		return "Linear";
	}

}
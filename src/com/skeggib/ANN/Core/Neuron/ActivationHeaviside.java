package com.skeggib.ANN.Core.Neuron;

public class ActivationHeaviside implements ActivationFunction {

	private double threshold;

	public ActivationHeaviside() {
		
	}

	public double activation(double input) {
		if (input >= this.threshold)
			return 1;
		else
			return 0;
	}

	public String toString() {
		return "Heaviside";
	}

}
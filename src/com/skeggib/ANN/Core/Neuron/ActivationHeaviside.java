package com.skeggib.ANN.Core.Neuron;

public class ActivationHeaviside implements ActivationFunction {

	private double threshold;

	public ActivationHeaviside() {
		this.setThreshold(0);
	}

	public ActivationHeaviside(double threshold) {
		this();
		this.setThreshold(threshold);
	}

	public ActivationHeaviside(ActivationHeaviside heaviside) {
		this();
		this.threshold = heaviside.threshold;
	}

	public double activation(double input) {
		if (input >= this.threshold)
			return 1;
		else
			return 0;
	}

	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

}
package com.skeggib.ANN.Core.Neuron.Activation;

public class ActivationSigmoid implements ActivationFunction {

	private double threshold;

	public ActivationSigmoid() {
		
	}

	public double activation(double input) {
		return 1 / (1 + Math.pow(Math.E, -input));
	}

	public String toString() {
		return "Sigmoid";
	}

}
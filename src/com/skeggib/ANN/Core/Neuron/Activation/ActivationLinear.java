package com.skeggib.ANN.Core.Neuron.Activation;

public class ActivationLinear implements ActivationFunction {

	private double threshold;

	public ActivationLinear() {
		
	}

	public double activation(double input) {
		return input;
	}

	public String toString() {
		return "Linear";
	}

}
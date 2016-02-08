package com.skeggib.ANN.Core.Neuron;

public class NeuronHeaviside extends Neuron {

	public NeuronHeaviside() {
		super();
		this.setActivationFunction(new ActivationHeaviside());
	}

	public NeuronHeaviside(double threshold) {
		super(threshold);
		this.setActivationFunction(new ActivationHeaviside());
	}

	public NeuronHeaviside(double threshold, int inputs_count) {
		super(threshold, inputs_count);
		this.setActivationFunction(new ActivationHeaviside());
	}

}
package com.skeggib.ANN.Core.Neuron;

import com.skeggib.ANN.Core.Neuron.Activation.ActivationSigmoid;

public class NeuronSigmoid extends Neuron {

	public NeuronSigmoid() {
		super();
		this.setActivationFunction(new ActivationSigmoid());
	}

	public NeuronSigmoid(double threshold) {
		super(threshold);
		this.setActivationFunction(new ActivationSigmoid());
	}

	public NeuronSigmoid(double threshold, int inputs_count) {
		super(threshold, inputs_count);
		this.setActivationFunction(new ActivationSigmoid());
	}

}
package com.skeggib.ANN.Core.Neuron;

import com.skeggib.ANN.Core.Neuron.Activation.ActivationLinear;

public class NeuronLinear extends Neuron {

	public NeuronLinear() {
		super();
		this.setActivationFunction(new ActivationLinear());
	}

	public NeuronLinear(double threshold) {
		super(threshold);
		this.setActivationFunction(new ActivationLinear());
	}

	public NeuronLinear(double threshold, int inputs_count) {
		super(threshold, inputs_count);
		this.setActivationFunction(new ActivationLinear());
	}

}
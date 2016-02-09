package com.skeggib.ANN.Core.Neuron;

public class NeuronSigmoidFactory extends NeuronFactory {

	public Neuron createNeuron() {
		return new NeuronSigmoid();
	}

}
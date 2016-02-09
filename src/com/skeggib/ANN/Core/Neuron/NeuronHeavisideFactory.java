package com.skeggib.ANN.Core.Neuron;

public class NeuronHeavisideFactory extends NeuronFactory {

	public Neuron createNeuron() {
		return new NeuronHeaviside();
	}

}
package com.skeggib.ANN.Core.Neuron.Factory;

import com.skeggib.ANN.Core.Neuron.Neuron;
import com.skeggib.ANN.Core.Neuron.NeuronHeaviside;

public class NeuronHeavisideFactory extends NeuronFactory {

	public Neuron createNeuron() {
		return new NeuronHeaviside();
	}

}
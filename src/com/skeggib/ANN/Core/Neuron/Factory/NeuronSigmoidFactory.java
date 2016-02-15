package com.skeggib.ANN.Core.Neuron.Factory;

import com.skeggib.ANN.Core.Neuron.Neuron;
import com.skeggib.ANN.Core.Neuron.NeuronSigmoid;

public class NeuronSigmoidFactory extends NeuronFactory {

	public Neuron createNeuron() {
		return new NeuronSigmoid();
	}

}
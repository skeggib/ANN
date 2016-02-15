package com.skeggib.ANN.Core.Neuron.Factory;

import com.skeggib.ANN.Core.Neuron.Neuron;
import com.skeggib.ANN.Core.Neuron.NeuronLinear;

public class NeuronLinearFactory extends NeuronFactory {

	public Neuron createNeuron() {
		return new NeuronLinear();
	}

}
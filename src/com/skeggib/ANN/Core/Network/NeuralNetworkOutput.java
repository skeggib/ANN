package com.skeggib.ANN.Core.Network;

import com.skeggib.ANN.Core.Neuron.Neuron;

public class NeuralNetworkOutput {

	private Neuron neuron;

	public NeuralNetworkOutput() {
		this.neuron = null;
	}

	public double getResult() {
		return this.neuron.getResult();
	}

	public void setNeuron(Neuron neuron) {
		this.neuron = neuron;
	}

	public Neuron getNeuron() {
		return this.neuron;
	}

}
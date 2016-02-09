package com.skeggib.ANN.Core.Network;

import java.util.ArrayList;

import com.skeggib.ANN.Core.Neuron.Neuron;
import com.skeggib.ANN.Core.Neuron.NeuronInput;

public class NeuralNetworkInput {

	private ArrayList<NeuronInput> neuron_inputs;
	private double value;
	private NeuralNetworkLayer layer;
	private boolean ready;

	public NeuralNetworkInput() {
		this.neuron_inputs = new ArrayList<NeuronInput>();
		this.setValue(0.0);
		this.layer = null;
		this.ready = false;
	}

	public void arm() throws Exception {
		this.ready = true;
		for (int i = 0; i < this.neuron_inputs.size(); i++) {
			this.neuron_inputs.get(i).arm();
		}
	}

	public void disarm() {
		this.ready = false;
		for (int i = 0; i < this.neuron_inputs.size(); i++) {
			this.neuron_inputs.get(i).disarm();
		}
	}

	public boolean isReady() {
		return this.ready;
	}

	public void setNeuralNetworkLayer(NeuralNetworkLayer layer) {
		this.layer = layer;
		this.neuron_inputs = new ArrayList<NeuronInput>();

		for (int i = 0; i < layer.getNeurons().size(); i++) {
			Neuron current_neuron = layer.getNeurons().get(i);
			NeuronInput neuron_input = new NeuronInput();
			current_neuron.addInput(neuron_input);
			this.neuron_inputs.add(neuron_input);
		}
	}

	public NeuralNetworkLayer getNeuralNetworkLayer() {
		return this.layer;
	}

	public void setValue(double value) {
		this.value = value;

		for (int i = 0; i < this.neuron_inputs.size(); i++) {
			this.neuron_inputs.get(i).setValue(value);
		}
	}

	public double getValue() {
		return this.value;
	}

	public ArrayList<NeuronInput> getNeuronInputs() {
		return this.neuron_inputs;
	}

}
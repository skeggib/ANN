package com.skeggib.ANN.Core.Network;

import java.util.ArrayList;

import com.skeggib.ANN.Core.Neuron.Neuron;
import com.skeggib.ANN.Core.Neuron.NeuronFactory;

public class NeuralNetwork {

	private ArrayList<NeuralNetworkLayer> layers;
	private ArrayList<NeuralNetworkInput> inputs;
	private ArrayList<NeuralNetworkOutput> outputs;
	private NeuronFactory neuron_factory;

	public NeuralNetwork(int inputs_count, ArrayList<Integer> layers_sizes, NeuronFactory neuron_factory) {
		this.neuron_factory = neuron_factory;
		this.layers = new ArrayList<NeuralNetworkLayer>();
		this.inputs = new ArrayList<NeuralNetworkInput>();
		this.outputs = new ArrayList<NeuralNetworkOutput>();

		this.createLayers(layers_sizes, neuron_factory);
		this.createInputs(inputs_count);
		this.createOutputs();
	}

	private void createLayers(ArrayList<Integer> layers_sizes, NeuronFactory neuron_factory) {

		NeuralNetworkLayer next_layer = null;
		NeuralNetworkLayer current_layer;

		ArrayList<NeuralNetworkLayer> temp_array = new ArrayList<NeuralNetworkLayer>();

		for (int i = layers_sizes.size() - 1; i >= 0; i--) {
			int current_size = layers_sizes.get(i);

			if (i < layers_sizes.size() - 1)
				current_layer = new NeuralNetworkLayer(current_size, neuron_factory, next_layer);
			else
				current_layer = new NeuralNetworkLayer(current_size, neuron_factory);

			temp_array.add(current_layer);

			next_layer = current_layer;
		}

		for (int i = temp_array.size() - 1; i >= 0; i--) {
			this.layers.add(temp_array.get(i));
		}

	}

	private void createInputs(int inputs_count) {
		for (int i = 0; i < inputs_count; i++) {
			NeuralNetworkInput input = new NeuralNetworkInput();
			input.setNeuralNetworkLayer(this.layers.get(0));
			this.inputs.add(input);
		}
	}

	private void createOutputs() {
		NeuralNetworkLayer last_layer = this.layers.get(this.layers.size() - 1);
		for (int i = 0; i < last_layer.getNeurons().size(); i++) {
			Neuron current_neuron = last_layer.getNeurons().get(i);	
			NeuralNetworkOutput output = new NeuralNetworkOutput();
			output.setNeuron(current_neuron);
			this.outputs.add(output);	
		}
	}

	public void randomizeWeights() throws Exception {
		try {
			for (int i = 0; i < this.layers.size(); i++) {
				this.layers.get(i).randomizeWeights();
			}
		}
		catch (Exception e) {
			throw new Exception("Cannot randomize neural network weights", e);
		}
	}

	public ArrayList<NeuralNetworkInput> getInputs() {
		return this.inputs;
	}

	public ArrayList<NeuralNetworkOutput> getOutputs() {
		return this.outputs;
	}

	public String toString() {
		String str = "";

		str += "\n";
		str += "INPUTS\n";
		for (int i = 0; i < this.inputs.size(); i++) {
			str += this.inputs.get(i).getValue() + "\n";
		}

		for (int i = 0; i < this.layers.size(); i++) {
			str += "\n";
			str += "LAYER " + (i+1) + "\n";
			str += this.layers.get(i).toString();
		}

		str += "\n";
		str += "OUTPUTS\n";
		for (int i = 0; i < this.outputs.size(); i++) {
			str += this.outputs.get(i).getResult() + "\n";
		}

		return str;
	}

}
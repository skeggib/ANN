package com.skeggib.ANN.Core.Network;

import java.util.ArrayList;

import com.skeggib.ANN.Core.Neuron.Neuron;
import com.skeggib.ANN.Core.Neuron.Input;

public class NeuralNetworkLayer {

	private ArrayList<Neuron> neurons;
	private NeuralNetworkLayer next_layer;

	public NeuralNetworkLayer() {
		this.neurons = new ArrayList<Neuron>();
		this.next_layer = null;
	}

	public NeuralNetworkLayer(int neurons_count) {
		this();
		for (int i = 0; i < neurons_count; i++) {
			this.neurons.add(new Neuron());
		}
	}

	public NeuralNetworkLayer(int neurons_count, NeuralNetworkLayer next_layer) {
		this(neurons_count);
		this.setNextLayer(next_layer);
	}

	public void setNextLayer(NeuralNetworkLayer next_layer) {
		this.next_layer = next_layer;

		// Supprimer tout les liens entre les sorties des neurones et les
		// entrees d'autres
		for (int i = 0; i < this.neurons.size(); i++) {
			this.neurons.get(i).setNextInputs(new ArrayList<Input>());
		}

		// Creer les liens entre les neurones et les entrees des neurones
		// de la couche suivante

		// Pour chaque neurone
		for (int i = 0; i < this.neurons.size(); i++) {
			Neuron current_neuron = this.neurons.get(i);

			// Pour chaque neurone de la couche suivante
			for (int j = 0; j < next_layer.getNeurons().size(); j++) {
				Neuron next_layer_neuron = next_layer.getNeurons().get(j);
				Input input = new Input();

				// On ajoute l'entree au neurone de la couche suivante
				next_layer_neuron.addInput(input);
				// On fait le lien entre la sortie du neurone de cette couche
				// et l'entree du neurone de la couche suivante
				current_neuron.addNextInput(input);
			}
		}
	}

	public NeuralNetworkLayer getNextLayer() {
		return this.next_layer;
	}

	public ArrayList<Neuron> getNeurons() {
		return this.neurons;
	}

}
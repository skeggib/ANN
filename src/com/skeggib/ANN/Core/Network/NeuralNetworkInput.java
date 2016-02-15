package com.skeggib.ANN.Core.Network;

import java.util.ArrayList;

import com.skeggib.ANN.Core.Neuron.Neuron;
import com.skeggib.ANN.Core.Neuron.NeuronInput;
import com.skeggib.ObserverPattern.Observer;
import com.skeggib.ObserverPattern.Observable;

public class NeuralNetworkInput implements Observable {

	private ArrayList<NeuronInput> neuron_inputs;
	private double value;
	private NeuralNetworkLayer layer;
	private boolean ready;

	private ArrayList<Observer> observers;

	public NeuralNetworkInput() {
		this.neuron_inputs = new ArrayList<NeuronInput>();
		this.observers = new ArrayList<Observer>();
		this.setValue(0.0);
		this.layer = null;
		this.ready = false;
	}

	public void registerObserver(Observer o) {
		this.observers.add(o);
	}

	public void unregisterObserver(Observer o) {
		this.observers.remove(o);
	}

	public void notifyObservers() {
		for (int i = 0; i < this.observers.size(); i++) {
			this.observers.get(i).update();
		}
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

		this.notifyObservers();
	}

	public double getValue() {
		return this.value;
	}

	public ArrayList<NeuronInput> getNeuronInputs() {
		return this.neuron_inputs;
	}

}
package com.skeggib.ANN.Core.Network;

import java.util.ArrayList;

import com.skeggib.ANN.Core.Neuron.Neuron;
import com.skeggib.ObserverPattern.Observer;
import com.skeggib.ObserverPattern.Observable;

public class NeuralNetworkOutput implements Observable, Observer {

	private Neuron neuron;

	private ArrayList<Observer> observers;

	public NeuralNetworkOutput() {
		this.neuron = null;
		
		this.observers = new ArrayList<Observer>();
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

	public void update() {
		this.notifyObservers();
	}

	public double getResult() {
		return this.neuron.getResult();
	}

	public void setNeuron(Neuron neuron) {
		this.neuron = neuron;
		this.neuron.registerObserver(this);
	}

	public Neuron getNeuron() {
		return this.neuron;
	}

}
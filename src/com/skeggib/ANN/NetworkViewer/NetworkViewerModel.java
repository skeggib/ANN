package com.skeggib.ANN.NetworkViewer;

import java.util.ArrayList;

import com.skeggib.ObserverPattern.Observer;
import com.skeggib.ObserverPattern.Observable;
import com.skeggib.ANN.Core.Network.NeuralNetwork;

public class NetworkViewerModel implements INetworkViewerModelObservable, Observer {

	private ArrayList<Observer> observers;
	private NeuralNetwork neural_network;

	public NetworkViewerModel() {
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

	public NeuralNetwork getNeuralNetwork() {
		return this.neural_network;
	}

	public void setNeuralNetwork(NeuralNetwork neural_network) {
		if (this.neural_network != null)
			this.neural_network.unregisterObserver(this);
		this.neural_network = neural_network;
		this.neural_network.registerObserver(this);
		this.notifyObservers();
	}

}
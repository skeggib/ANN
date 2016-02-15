package com.skeggib.ANN.NetworkViewer;

import com.skeggib.ANN.Core.Network.NeuralNetwork;

public interface INetworkViewerModel {

	public void setNeuralNetwork(NeuralNetwork neural_network);
	public NeuralNetwork getNeuralNetwork();

}
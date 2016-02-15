package com.skeggib.ANN.NetworkViewer;

import java.util.ArrayList;
import java.util.Random;

import com.skeggib.ANN.Core.Network.NeuralNetwork;
import com.skeggib.ANN.Core.Network.NeuralNetworkInput;
import com.skeggib.ANN.Core.Neuron.Factory.*;
import com.skeggib.Tools.StopWatch;
import com.skeggib.Tools.TerminalMsg;

public class NetworkViewer {

	private INetworkViewerModelObservable model;
	private INetworkViewerView view;

	public NetworkViewer() {
		this.model = new NetworkViewerModel();
		this.view = new NetworkViewerView(this.model);
	}

	public void setNeuralNetwork(NeuralNetwork neural_network) {
		this.model.setNeuralNetwork(neural_network);
	}



	public static void main(String[] args) throws Exception {
		NetworkViewer networkViewer = new NetworkViewer();

		ArrayList<Integer> layers_sizes = new ArrayList<Integer>();
		layers_sizes.add(3);
		layers_sizes.add(5);
		layers_sizes.add(2);

		NeuralNetwork network = new NeuralNetwork(3, layers_sizes, new NeuronSigmoidFactory());
		network.randomizeWeights();

		networkViewer.setNeuralNetwork(network);

		NeuralNetworkInput in0 = network.getInputs().get(0);
		NeuralNetworkInput in1 = network.getInputs().get(1);
		NeuralNetworkInput in2 = network.getInputs().get(2);

		StopWatch stop_watch = new StopWatch();
		stop_watch.start();
		double last_time = 0;
		int calc_in_last_sec = 0;
		
		while (true) {
			in0.setValue(new Random().nextDouble());
			in1.setValue(new Random().nextDouble());
			in2.setValue(new Random().nextDouble());

			in0.arm();
			in1.arm();
			in2.arm();

			calc_in_last_sec++;

			double elapsed_time = stop_watch.getElapsedTime() - last_time;
			if (elapsed_time > 1000) {
				last_time = stop_watch.getElapsedTime();
				// Effacer la ligne
				System.out.print("\r                                                                      ");
				System.out.print("\r" + calc_in_last_sec + " calculations per second");
				calc_in_last_sec = 0;
			}
		}
	}

}
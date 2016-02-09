package com.skeggib.ANN.Core.Neuron;

import java.util.ArrayList;

public class SumCoefficient implements SumFunction {

	public double sum(ArrayList<NeuronInput> inputs) {
		double sum = 0;
		for (int i = 0; i < inputs.size(); i++) {
			NeuronInput current = inputs.get(i);
			sum += current.getValue() * current.getCoefficient();
		}
		return sum;
	}

}
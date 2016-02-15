package com.skeggib.ANN.Core.Neuron.Sum;

import java.util.ArrayList;

import com.skeggib.ANN.Core.Neuron.NeuronInput;

public interface SumFunction {

	public double sum(ArrayList<NeuronInput> inputs, double threshold);

}
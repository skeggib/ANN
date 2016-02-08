package com.skeggib.ANN.Core.Neuron;

public interface ActivationFunction {

	/**
	 * Calculate the result with activation function
	 *
	 * @param      input  Sum of inputs
	 *
	 * @return     
	 */
	public double activation(double input);

	public void setThreshold(double threshold);

}
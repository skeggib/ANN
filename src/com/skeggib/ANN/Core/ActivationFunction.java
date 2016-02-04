package com.skeggib.ANN.Core;

public interface ActivationFunction {

	/**
	 * Calculate the result with activation function
	 *
	 * @param      input  Sum of inputs
	 *
	 * @return     
	 */
	public float activation(float input);

	public void setThreshold(float threshold);

}
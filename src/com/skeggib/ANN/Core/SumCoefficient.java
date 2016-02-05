package com.skeggib.ANN.Core;

import java.util.ArrayList;

public class SumCoefficient implements SumFunction {

	public double sum(ArrayList<Input> inputs) {
		double sum = 0;
		for (int i = 0; i < inputs.size(); i++) {
			Input current = inputs.get(i);
			sum += current.getValue() * current.getCoefficient();
		}
		return sum;
	}

}
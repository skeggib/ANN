package com.skeggib.ANN.Core.Neuron;

import java.util.ArrayList;

public class Neuron {

	private ArrayList<NeuronInput> inputs;
	private ArrayList<NeuronInput> next_inputs;
	private double threshold;
	private double result;
	private ActivationFunction activation_func;
	private SumFunction sum_func;

	/**
	 * Default contructor
	 */
	public Neuron() {
		this.inputs = new ArrayList<NeuronInput>();
		this.next_inputs = new ArrayList<NeuronInput>();
		this.threshold = 0.0;
		this.result = 0.0;
		this.activation_func = new ActivationLinear();
		this.sum_func = new SumCoefficient();
	}

	/**
	 * Threshold constructor
	 *
	 * @param      threshold  Neuron's threshold
	 */
	public Neuron(double threshold) {
		this();
		this.setThreshold(threshold);
	}

	/**
	 * Threshold and inputs count contructor
	 *
	 * @param      threshold     Neuron's threshold
	 * @param      inputs_count  Neuron's inputs coune
	 */
	public Neuron(double threshold, int inputs_count) {
		this(threshold);
		for (int i = 0; i < inputs_count; i++) {
			this.addInput(new NeuronInput());
		}
	}

	public boolean isActive() {
		return this.result >= this.threshold;
	}

	private double runSumFunction() {
		return this.sum_func.sum(this.inputs);
	}

	private void runActivationFunction() throws Exception {
		double sum = this.runSumFunction();
		this.result = this.activation_func.activation(sum);
		// Update all next inputs value
		for (int i = 0; i < this.next_inputs.size(); i++) {
			NeuronInput current = this.next_inputs.get(i);
			current.setValue(this.result);
			try {
				current.arm();
			} catch (Exception e) {
				throw new Exception("Cannot arm input", e);
			}
		}
	}

	/**
	 * Check if all inputs are ready, if so, the neuron will run his activation function and notify next inputs
	 *
	 * @throws     Exception  If activation function cannot be run
	 */
	public void update() throws Exception {
		boolean all_inputs_ready = true;
		// Check if all inputs are ready
		for (int i = 0; i < this.inputs.size(); i++) {
			if (!this.inputs.get(i).isReady())
				all_inputs_ready = false;
		}
		if (all_inputs_ready) {
			try {
				this.runActivationFunction();
			} catch (Exception e) {
				throw new Exception("Cannot run activation function", e);
			}
		}
	}

	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

	public double getThreshold() {
		return this.threshold;
	}

	public double getResult() {
		return this.result;
	}

	/* --- inputs --- */

	public ArrayList<NeuronInput> getInputs() {
		return this.inputs;
	}

	public void setInputs(ArrayList<NeuronInput> inputs) {
		for (int i = 0; i < this.inputs.size(); i++) {
			NeuronInput current = this.inputs.get(i);
			this.removeInput(current);
		}

		for (int i = 0; i < inputs.size(); i++) {
			NeuronInput current = inputs.get(i);
			this.addInput(current);
		}
	}

	public void addInput(NeuronInput input) {
		if (input.getNeuron() != null)
			input.getNeuron().removeInput(input);
		this.inputs.add(input);
		input.setNeuron(this);
	}

	public void removeInput(NeuronInput input) {
		input.setNeuron(null);
		this.inputs.remove(input);
	}

	public ArrayList<NeuronInput> getNextInputs() {
		return this.next_inputs;
	}

	/* --- next inputs --- */

	public void setNextInputs(ArrayList<NeuronInput> inputs) {
		this.next_inputs = inputs;
	}

	public void addNextInput(NeuronInput input) {
		this.next_inputs.add(input);
	}

	public void removeNextInput(NeuronInput input) {
		this.next_inputs.remove(input);
	}

	/* --- functions --- */

	public void setActivationFunction(ActivationFunction activation_func) {
		this.activation_func = activation_func;
	}

	public void setSumFunction(SumFunction sum_func) {
		this.sum_func = sum_func;
	}

}
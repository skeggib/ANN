package com.skeggib.ANN.Core.Neuron;

public class NeuronInput {

	private Neuron neuron;
	private String name;
	private double coefficient;
	private double value;
	private boolean ready;

	/**
	 * Default constructor
	 */
	public NeuronInput() {
		this.setNeuron(null);
		this.setName("");
		this.coefficient = 1.0;
		this.setValue(0.0);
		this.ready = false;
	}

	/**
	 * Name constructor
	 *
	 * @param      name  NeuronInput's name
	 */
	public NeuronInput(String name) {
		this();
		this.setName(name);
	}

	/**
	 * Coefficient constructor
	 *
	 * @param      coefficient  NeuronInput's coefficient
	 * 
	 * @throws     Exception If coefficient is not between 0 and 1
	 */
	public NeuronInput(double coefficient) throws Exception {
		this();
		this.setCoefficient(coefficient);
	}

	/**
	 * Name and coefficient constructor
	 *
	 * @param      name         NeuronInput's name
	 * @param      coefficient  NeuronInput's coefficient
	 * 
	 * @throws     Exception  If coefficient is not between 0 and 1
	 */
	public NeuronInput(String name, double coefficient) throws Exception {
		this(name);
		this.setCoefficient(coefficient);
	}

	/**
	 * @return     True if input is ready (armed)
	 */
	public boolean isReady() {
		return this.ready;
	}

	/**
	 * Arm the intput
	 *
	 * @throws     Exception  If input's neuron is null
	 */
	public void arm() throws Exception {
		this.ready = true;
		this.notifyNeuron();
	}

	/**
	 * Disarm the input
	 */
	public void disarm() {
		this.ready = false;
	}

	/**
	 * Notify neuron that input is ready
	 *
	 * @throws     Exception  If input's neuron is null
	 */
	private void notifyNeuron() throws Exception {
		if (this.neuron == null)
			throw new Exception("NeuronInput has no neuron");

		this.neuron.update();
	}

	public void setNeuron(Neuron neuron) {
		this.neuron = neuron;
	}

	public Neuron getNeuron() {
		return this.neuron;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setCoefficient(double coefficient) throws Exception {
		if (coefficient > 1)
			throw new Exception("Coefficient cannot be greater than 1");
		if (coefficient < 0)
			throw new Exception("Coefficient cannot be less than 0");

		this.coefficient = coefficient;
	}

	public double getCoefficient() {
		return this.coefficient;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getValue() {
		return this.value;
	}

}
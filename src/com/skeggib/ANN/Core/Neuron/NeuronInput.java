package com.skeggib.ANN.Core.Neuron;

public class NeuronInput {

	private Neuron neuron;
	private String name;
	private double weight;
	private double value;
	private boolean ready;

	/**
	 * Default constructor
	 */
	public NeuronInput() {
		this.setNeuron(null);
		this.setName("");
		this.weight = 1.0;
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
	 * Weight constructor
	 *
	 * @param      weight  NeuronInput's weight
	 * 
	 * @throws     Exception If weight is not between 0 and 1
	 */
	public NeuronInput(double weight) throws Exception {
		this();
		this.setWeight(weight);
	}

	/**
	 * Name and weight constructor
	 *
	 * @param      name         NeuronInput's name
	 * @param      weight  NeuronInput's weight
	 * 
	 * @throws     Exception  If weight is not between 0 and 1
	 */
	public NeuronInput(String name, double weight) throws Exception {
		this(name);
		this.setWeight(weight);
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

	public void setWeight(double weight) throws Exception {
		if (weight > 1)
			throw new Exception("Weight cannot be greater than 1");
		if (weight < 0)
			throw new Exception("Weight cannot be less than 0");

		this.weight = weight;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getValue() {
		return this.value;
	}

}
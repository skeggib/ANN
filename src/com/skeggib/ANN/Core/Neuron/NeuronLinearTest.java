package com.skeggib.ANN.Core.Neuron;

import junit.framework.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import com.skeggib.ANN.Core.Neuron.NeuronLinear;

public class NeuronLinearTest extends TestCase {

    public void test_default_constructor() {
        Neuron neuron = new NeuronLinear();
        assertEquals(0, neuron.getInputs().size());
        assertEquals(0, neuron.getNextInputs().size());
        assertEquals(true, neuron.isActive());
        assertEquals(0.0, neuron.getThreshold());
        assertEquals(0.0, neuron.getResult());
    }

    public void test_threshold_constructor() {
        Neuron neuron = new NeuronLinear(0.5);
        assertEquals(0, neuron.getInputs().size());
        assertEquals(0, neuron.getNextInputs().size());
        assertEquals(false, neuron.isActive());
        assertEquals(0.5, neuron.getThreshold());
        assertEquals(0.0, neuron.getResult());
    }

    public void test_threshold_inputsCount_constructor() {
        Neuron neuron = new NeuronLinear(0.5, 5);
        assertEquals(5, neuron.getInputs().size());
        assertEquals(0, neuron.getNextInputs().size());
        assertEquals(false, neuron.isActive());
        assertEquals(0.5, neuron.getThreshold());
        assertEquals(0.0, neuron.getResult());
    }

    public void test_update() throws Exception {
        NeuronInput input1 = new NeuronInput("input1", 0.5);
        NeuronInput input2 = new NeuronInput("input2", 1);
        NeuronInput input3 = new NeuronInput("input3", 0.2);
        NeuronInput input4 = new NeuronInput("input4", 0.89);
        NeuronInput input5 = new NeuronInput("input5", 0.33);

        Neuron neuron = new NeuronLinear(0.5);

        neuron.addInput(input1);
        neuron.addInput(input2);
        neuron.addInput(input3);
        neuron.addInput(input4);
        neuron.addInput(input5);

        input1.setValue(3.0);
        input1.arm();
        input2.setValue(0.5);
        input2.arm();
        input3.setValue(4.6);
        input3.arm();
        input4.setValue(10.45);
        input4.arm();
        input5.setValue(0.99);
        input5.arm();

        assertEquals(12.0472, neuron.getResult());
        assertEquals(true, neuron.isActive());
    }

}

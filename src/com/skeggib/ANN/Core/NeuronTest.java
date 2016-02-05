package com.skeggib.ANN.Core;

import junit.framework.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.skeggib.ANN.Core.Neuron;
import com.skeggib.ANN.Core.Input;

import java.util.ArrayList;

public class NeuronTest extends TestCase {

    public void test_default_constructor() {
        Neuron neuron = new Neuron();
        assertEquals(0, neuron.getInputs().size());
        assertEquals(0, neuron.getNextInputs().size());
        assertEquals(true, neuron.isActive());
        assertEquals(0.0, neuron.getThreshold());
        assertEquals(0.0, neuron.getResult());
    }

    public void test_threshold_constructor() {
        Neuron neuron = new Neuron(0.5);
        assertEquals(0, neuron.getInputs().size());
        assertEquals(0, neuron.getNextInputs().size());
        assertEquals(false, neuron.isActive());
        assertEquals(0.5, neuron.getThreshold());
        assertEquals(0.0, neuron.getResult());
    }

    public void test_threshold_inputsCount_constructor() {
        Neuron neuron = new Neuron(0.5, 5);
        assertEquals(5, neuron.getInputs().size());
        assertEquals(0, neuron.getNextInputs().size());
        assertEquals(false, neuron.isActive());
        assertEquals(0.5, neuron.getThreshold());
        assertEquals(0.0, neuron.getResult());
    }

    public void test_update() throws Exception {
        Input input1 = new Input("input1", 0.5);
        Input input2 = new Input("input2", 1);
        Input input3 = new Input("input3", 0.2);
        Input input4 = new Input("input4", 0.89);
        Input input5 = new Input("input5", 0.33);

        Neuron neuron = new Neuron(0.5);

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

        assertEquals(12.5472, neuron.getResult());
    }

}

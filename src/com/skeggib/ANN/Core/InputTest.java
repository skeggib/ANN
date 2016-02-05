package com.skeggib.ANN.Core;

import junit.framework.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.skeggib.ANN.Core.Input;
import com.skeggib.ANN.Core.Neuron;

import java.util.ArrayList;

public class InputTest extends TestCase {

    public void test_default_constructor() throws Exception {
        Input input = new Input();
        assertEquals(null, input.getNeuron());
        assertEquals("", input.getName());
        assertEquals(1.0, input.getCoefficient());
        assertEquals(0.0, input.getValue());
        assertEquals(false, input.isReady());
    }

    public void test_name_constructor() throws Exception {
        Input input = new Input("foo");
        assertEquals(null, input.getNeuron());
        assertEquals("foo", input.getName());
        assertEquals(1.0, input.getCoefficient());
        assertEquals(0.0, input.getValue());
        assertEquals(false, input.isReady());
    }

    public void test_name_coefficient_constructor() throws Exception {
        Input input = new Input("bar", 0.5);
        assertEquals(null, input.getNeuron());
        assertEquals("bar", input.getName());
        assertEquals(0.5, input.getCoefficient());
        assertEquals(0.0, input.getValue());
        assertEquals(false, input.isReady());
    }

    public void test_setNeuron() throws Exception {
        Neuron neuron = new Neuron();
        Input input = new Input();
        input.setNeuron(neuron);
        assertEquals(neuron, input.getNeuron());
    }

    public void test_setName() throws Exception {
        Input input = new Input();
        input.setName("foo");
        assertEquals("foo", input.getName());
    }

    public void test_setCoefficient_with_exception_greater_one() throws Exception {
        Input input = new Input();
        try {
            input.setCoefficient(1.89);
            fail("setCoefficient did not throw Exception");
        } catch (Exception e) {

        }
    }

    @Test(expected = Exception.class)
    public void test_setCoefficient_with_exception_less_zero() throws Exception {
        Input input = new Input();
        try {
            input.setCoefficient(-0.1);
            fail("setCoefficient did not throw Exception");
        } catch (Exception e) {

        }
    }

    public void test_setCoefficient_without_exception() throws Exception {
        Input input = new Input();
        input.setCoefficient(0.33);
        assertEquals(0.33, input.getCoefficient());
    }

    public void test_setValue() throws Exception {
        Input input = new Input();
        input.setValue(34.7);
        assertEquals(34.7, input.getValue());
    }

    @Test(expected = Exception.class)
    public void test_arm_with_exception() throws Exception {
        Input input = new Input();
        input.setNeuron(null);
        try {
            input.arm();
            fail("arm did not throw Exception");
        } catch (Exception e) {

        }
    }

    public void test_arm_without_exception() throws Exception {
        Input input = new Input();
        input.setNeuron(new Neuron());
        input.arm();
        assertEquals(true, input.isReady());
    }

    public void test_disarm() throws Exception {
        Input input = new Input();
        input.setNeuron(new Neuron());
        input.arm();
        input.disarm();
        assertEquals(false, input.isReady());
    }

}

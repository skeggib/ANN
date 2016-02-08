package com.skeggib.ANN.Core.Neuron;

import junit.framework.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.skeggib.ANN.Core.Neuron.ActivationFunction;
import com.skeggib.ANN.Core.Neuron.ActivationHeaviside;

public class ActivationHeavisideTest extends TestCase {

    public void test_activation() {
        ActivationFunction heaviside = new ActivationHeaviside();

        assertEquals(1.0, heaviside.activation(0));

        assertEquals(1.0, heaviside.activation(4));
        assertEquals(1.0, heaviside.activation(4673927));
        assertEquals(1.0, heaviside.activation(0.678));

        assertEquals(0.0, heaviside.activation(-4));
        assertEquals(0.0, heaviside.activation(-4673927));
        assertEquals(0.0, heaviside.activation(-0.678));

        heaviside.setThreshold(3.3);

        assertEquals(1.0, heaviside.activation(3.3));

        assertEquals(1.0, heaviside.activation(4));
        assertEquals(1.0, heaviside.activation(4673927));
        assertEquals(0.0, heaviside.activation(0.678));

        assertEquals(0.0, heaviside.activation(-4));
        assertEquals(0.0, heaviside.activation(-4673927));
        assertEquals(0.0, heaviside.activation(-0.678));
    }

}

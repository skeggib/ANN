package com.skeggib.ANN.Core.Neuron.Activation;

import junit.framework.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
    }

}

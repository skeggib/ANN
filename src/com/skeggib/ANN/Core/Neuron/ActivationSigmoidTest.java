package com.skeggib.ANN.Core.Neuron;

import junit.framework.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.skeggib.ANN.Core.Neuron.ActivationFunction;
import com.skeggib.ANN.Core.Neuron.ActivationSigmoid;

import java.util.ArrayList;

public class ActivationSigmoidTest extends TestCase {

    public void test_activation() {
        ActivationFunction sigmoid = new ActivationSigmoid();

        ArrayList<Double> values = new ArrayList<Double>();
        values.add(-1.0);
        values.add(-3.89);
        values.add(0.0);
        values.add(1.0);
        values.add(7.23);

        for (int i = 0; i < values.size(); i++) {
            assertEquals(this.sigmoid(values.get(i)), sigmoid.activation(values.get(i)));
        }
    }

    private double sigmoid(double input) {
        return 1 / (1 + Math.pow(Math.E, -input));
    }

}

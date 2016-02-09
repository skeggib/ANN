package com.skeggib.ANN.Core.Network;

import junit.framework.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import com.skeggib.ANN.Core.Neuron.Neuron;
import com.skeggib.ANN.Core.Neuron.NeuronInput;
import com.skeggib.ANN.Core.Neuron.NeuronFactory;

import com.skeggib.ANN.Core.Network.NeuralNetworkInput;

public class NeuralNetworkInputTest extends TestCase {

    public void test_default_constructor() {
        NeuralNetworkInput input = new NeuralNetworkInput();
        assertEquals(0, input.getNeuronInputs().size());
        assertEquals(0.0, input.getValue());
        assertEquals(null, input.getNeuralNetworkLayer());
        assertEquals(false, input.isReady());
    }

    public void test_setNeuralNetworkLayer() {
        NeuralNetworkLayer layer = new NeuralNetworkLayer(4, new NeuronFactory());
        NeuralNetworkInput input1 = new NeuralNetworkInput();
        NeuralNetworkInput input2 = new NeuralNetworkInput();
        input1.setNeuralNetworkLayer(layer);
        input2.setNeuralNetworkLayer(layer);

        assertEquals(layer, input1.getNeuralNetworkLayer());
        assertEquals(layer, input2.getNeuralNetworkLayer());

        // Chaque neurone de la couche doit avoir exactement une entree connectee
        // a l'entree du reseau

        // Pour chaque neurone de la couche
        for (int i = 0; i < layer.getNeurons().size(); i++) {
            Neuron current_neuron = layer.getNeurons().get(i);

            int connected_input1_count = 0;
            int connected_input2_count = 0;

            // Pour chaque entree du neurone
            for (int j = 0; j < current_neuron.getInputs().size(); j++) {
                NeuronInput current_neuron_input = current_neuron.getInputs().get(j);

                // Chaque entree de reseau doit avoir ses propres entrees de neurones
                if (input1.getNeuronInputs().contains(current_neuron_input))
                    connected_input1_count++;
                else if (input2.getNeuronInputs().contains(current_neuron_input))
                    connected_input2_count++;
            }

            assertEquals(1, connected_input1_count);
            assertEquals(1, connected_input2_count);
        }
    }

    public void test_setValue() {
        NeuralNetworkInput input = new NeuralNetworkInput();
        NeuralNetworkLayer layer = new NeuralNetworkLayer(2, new NeuronFactory());

        input.setNeuralNetworkLayer(layer);

        input.setValue(4.87);
        assertEquals(4.87, input.getValue());
        
        for (int i = 0; i < input.getNeuronInputs().size(); i++) {
            NeuronInput current = input.getNeuronInputs().get(i);
            assertEquals(4.87, current.getValue());
        }
    }

    public void test_arm_disarm() throws Exception {
        NeuralNetworkInput input = new NeuralNetworkInput();
        NeuralNetworkLayer layer = new NeuralNetworkLayer(6, new NeuronFactory());

        input.setNeuralNetworkLayer(layer);

        input.arm();

        for (int i = 0; i < input.getNeuronInputs().size(); i++) {
            assertEquals(true, input.getNeuronInputs().get(i).isReady());
        }

        input.disarm();

        for (int i = 0; i < input.getNeuronInputs().size(); i++) {
            assertEquals(false, input.getNeuronInputs().get(i).isReady());
        }
    }

}

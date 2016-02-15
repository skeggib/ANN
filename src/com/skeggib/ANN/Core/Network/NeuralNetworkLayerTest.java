package com.skeggib.ANN.Core.Network;

import junit.framework.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import com.skeggib.ANN.Core.Neuron.Neuron;
import com.skeggib.ANN.Core.Neuron.NeuronInput;
import com.skeggib.ANN.Core.Neuron.Factory.NeuronLinearFactory;

import com.skeggib.ANN.Core.Network.NeuralNetworkLayer;

public class NeuralNetworkLayerTest extends TestCase {

    public void test_default_constructor() {
        NeuralNetworkLayer layer = new NeuralNetworkLayer();
        assertEquals(0, layer.getNeurons().size());
        assertEquals(null, layer.getNextLayer());
    }

    public void test_neurons_count_constructor() {
        NeuralNetworkLayer layer = new NeuralNetworkLayer(5, new NeuronLinearFactory());
        assertEquals(5, layer.getNeurons().size());
        assertEquals(null, layer.getNextLayer());
    }

    public void test_neurons_count_next_layer_constructor() {
        NeuralNetworkLayer next_layer = new NeuralNetworkLayer();
        NeuralNetworkLayer layer = new NeuralNetworkLayer(5, new NeuronLinearFactory(), next_layer);
        assertEquals(5, layer.getNeurons().size());
        assertEquals(next_layer, layer.getNextLayer());
    }

    public void test_setNextLayer() {
        NeuralNetworkLayer next_layer = new NeuralNetworkLayer(3, new NeuronLinearFactory());
        NeuralNetworkLayer first_layer = new NeuralNetworkLayer(2, new NeuronLinearFactory(), next_layer);

        ArrayList<Neuron> first_layer_neurons = first_layer.getNeurons();
        ArrayList<Neuron> next_layer_neurons = next_layer.getNeurons();

        // La sortie de chaque neuron de first_layer doit etre reliee a une
        // entree de chaque neurone de next_layer

        // Pour chaque neurone de first_layer
        for (int i = 0; i < first_layer_neurons.size(); i++) {
            Neuron current_first = first_layer_neurons.get(i);

            // Pour chaque neurone de next_layer
            for (int j = 0; j < next_layer_neurons.size(); j++) {
                Neuron current_next = next_layer_neurons.get(j);
                
                // On compte combien d'entrees de current_next sont
                // dans current_first.getNextInputs()
                int inputs_in_nextInputs = 0;
                for (int k = 0; k < current_next.getInputs().size(); k++) {
                    NeuronInput current_input_next = current_next.getInputs().get(k);

                    // Si l'entree de current_next est dans
                    // current_first.nextInputs()
                    if (current_first.getNextInputs().contains(current_input_next))
                        inputs_in_nextInputs ++;
                }

                // Exactement une entree de current_next doit etre dans
                // current_first.getNextInputs()
                assertEquals(1, inputs_in_nextInputs);
            }
        }
    }

}

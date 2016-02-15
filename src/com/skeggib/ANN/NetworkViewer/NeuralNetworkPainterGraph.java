package com.skeggib.ANN.NetworkViewer;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

import com.skeggib.ANN.Core.Neuron.Neuron;
import com.skeggib.ANN.Core.Network.NeuralNetwork;
import com.skeggib.ANN.Core.Network.NeuralNetworkLayer;

public class NeuralNetworkPainterGraph implements NeuralNetworkPainter {

	private float min_neuron_result = 0;
	private float max_neuron_result = 0;

	public void paint(Graphics g, NeuralNetwork neural_network, int x, int y, int w, int h) {
		g.setColor(Color.black);

		if (neural_network == null) {
			g.drawString("No neural network set", x, y);
			return;
		}

		ArrayList<NeuralNetworkLayer> layers = neural_network.getLayers();
		int layer_place_w = w / layers.size();
		int neuron_size = 50;

		for (int i = 0; i < layers.size(); i++) {
			NeuralNetworkLayer current_layer = layers.get(i);

			int layer_pos_x = layer_place_w * i + (layer_place_w / 2) - (neuron_size / 2);
			int neuron_place_h = h / current_layer.getNeurons().size();

			for (int j = 0; j < current_layer.getNeurons().size(); j++) {
				Neuron current_neuron = current_layer.getNeurons().get(j);

				int neuron_pos_y = neuron_place_h * j + (neuron_place_h / 2) - (neuron_size / 2);

				float neuron_result = (float)current_neuron.getResult();
				this.updateColorScale(neuron_result);

				Color neuron_color = this.getNeuronColor(neuron_result, this.min_neuron_result, this.max_neuron_result);
				g.setColor(neuron_color);
				
				g.fillOval(	x + layer_pos_x,
							y + neuron_pos_y,
							x + neuron_size,
							y + neuron_size);

				g.drawString(String.valueOf(current_neuron.getResult()), x + layer_pos_x, y + neuron_pos_y - 4);
			}
		}
	}

	private void updateColorScale(float neuron_result) {
		if (neuron_result > this.max_neuron_result)
			this.max_neuron_result = neuron_result;
		if (neuron_result < this.min_neuron_result)
			this.min_neuron_result = neuron_result;
	}

	private Color getNeuronColor(float neuron_result, float min, float max) {
		float r = 0;
		float v = 0;
		float b = 0;

		float diff = max - min;
		float middle = min + (diff / 2);

		if (neuron_result >= min && neuron_result <= middle) {
			float perc = (neuron_result - min) / (diff / 2);
			r = 0;
			v = perc;
			b = 1.0f - perc;
		}
		else if (neuron_result > middle && neuron_result <= max) {
			float perc = (neuron_result - min - (diff / 2)) / (diff / 2);
			r = perc;
			v = 1.0f - perc;
			b = 0;
		}

		return new Color(r, v, b);
	}

}
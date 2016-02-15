package com.skeggib.ANN.NetworkViewer;

import java.awt.Graphics;
import java.awt.Color;

import com.skeggib.ANN.Core.Network.NeuralNetwork;

public class NeuralNetworkPainterText implements NeuralNetworkPainter {

	public void paint(Graphics g, NeuralNetwork neural_network, int x, int y, int w, int h) {
		g.setColor(Color.black);

		if (neural_network == null) {
			g.drawString("No neural network set", x, y);
			return;
		}

		String[] lines = neural_network.toString().split("\n");

		for (int i = 0; i < lines.length; i++) {
			g.drawString(lines[i], x, y + (i * 12));
		}
	}

}
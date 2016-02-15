package com.skeggib.ANN.NetworkViewer;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

import com.skeggib.ANN.Core.Network.NeuralNetwork;

public class NeuralNetworkPanel extends JPanel {

	private NeuralNetwork neural_network;
	private NeuralNetworkPainter neural_network_painter;

	public NeuralNetworkPanel(NeuralNetwork neural_network) {
		this.setNeuralNetwork(neural_network);
		this.setNeuralNetworkPainter(new NeuralNetworkPainterGraph());
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
		this.neural_network_painter.paint(g, this.neural_network, 0, 0, this.getWidth(), this.getHeight());
	}

	public void setNeuralNetwork(NeuralNetwork neural_network) {
		this.neural_network = neural_network;
	}

	public void setNeuralNetworkPainter(NeuralNetworkPainter neural_network_painter) {
		this.neural_network_painter = neural_network_painter;
	}

}
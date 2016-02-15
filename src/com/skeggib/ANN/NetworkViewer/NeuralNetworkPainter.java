package com.skeggib.ANN.NetworkViewer;

import java.awt.Graphics;

import com.skeggib.ANN.Core.Network.NeuralNetwork;

public interface NeuralNetworkPainter {

	public void paint(Graphics g, NeuralNetwork network, int x, int y, int w, int h);

}
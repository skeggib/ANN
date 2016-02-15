package com.skeggib.ANN.NetworkViewer;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Toolkit;

import com.skeggib.ObserverPattern.Observer;
import com.skeggib.ANN.Core.Network.NeuralNetwork;
import com.skeggib.Tools.StopWatch;

public class NetworkViewerView extends JFrame implements INetworkViewerView, Observer {

	private INetworkViewerModelObservable model;
	private NeuralNetworkPanel panel;
	private StopWatch stop_watch;
	private long last_update_time;

	public NetworkViewerView(INetworkViewerModelObservable model) {
		super("Neural Network Viewer");

		this.model = model;
		this.model.registerObserver(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(1200, 600);
		this.setVisible(true);

		this.panel = new NeuralNetworkPanel(this.model.getNeuralNetwork());
		this.setContentPane(panel);

		this.stop_watch = new StopWatch();
		this.stop_watch.start();
		this.last_update_time = 0;
	}

	public void update() {
		// long elapsed_time = 0;
		
		// while (elapsed_time < 33) {
		// 	elapsed_time = this.stop_watch.getElapsedTime() - last_update_time;
		// 	try{
		// 		if (elapsed_time < 33)
		// 			Thread.sleep(33 - elapsed_time);
		// 	} catch(InterruptedException e) {
				
		// 	}
		// }

		// long elapsed_time = this.stop_watch.getElapsedTime() - last_update_time;
		// if (elapsed_time > 33) {
			this.panel.setNeuralNetwork(this.model.getNeuralNetwork());
			
			this.panel.repaint();
			// Flush the graphic buffer which some systems like Linux use
			Toolkit.getDefaultToolkit().sync();

		// 	this.last_update_time = this.stop_watch.getElapsedTime();
		// }

		// this.last_update_time = this.stop_watch.getElapsedTime();
	}

}
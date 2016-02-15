package com.skeggib.ANN;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.skeggib.Tools.TerminalMsg;

import com.skeggib.ANN.Core.Neuron.Activation.ActivationHeavisideTest;
import com.skeggib.ANN.Core.Neuron.Activation.ActivationSigmoidTest;
import com.skeggib.ANN.Core.Neuron.NeuronInputTest;
import com.skeggib.ANN.Core.Neuron.NeuronLinearTest;

import com.skeggib.ANN.Core.Network.NeuralNetworkLayerTest;
import com.skeggib.ANN.Core.Network.NeuralNetworkInputTest;

public class TestRunner {
    public static void main(String[] args) {

        // ANN.Core.Neuron
        TestRunner.runTest(ActivationHeavisideTest.class);
        TestRunner.runTest(ActivationSigmoidTest.class);
        TestRunner.runTest(NeuronInputTest.class);
        TestRunner.runTest(NeuronLinearTest.class);

        // Ann.Core.Network
        TestRunner.runTest(NeuralNetworkLayerTest.class);
        TestRunner.runTest(NeuralNetworkInputTest.class);
    }

    private static void runTest(Class classes) {
        Result result = JUnitCore.runClasses(classes);
        for (Failure failure : result.getFailures())
             TerminalMsg.message(failure.toString());
        if (result.wasSuccessful())
             TerminalMsg.success(classes.getName() + " : Success");
        else
             TerminalMsg.failure(classes.getName() + " : Error");
    }

}

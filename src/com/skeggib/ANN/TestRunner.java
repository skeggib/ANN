package com.skeggib.ANN;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.skeggib.Tools.TerminalMsg;

import com.skeggib.ANN.Core.Neuron.ActivationHeavisideTest;
import com.skeggib.ANN.Core.Neuron.ActivationSigmoidTest;
import com.skeggib.ANN.Core.Neuron.InputTest;
import com.skeggib.ANN.Core.Neuron.NeuronTest;

import com.skeggib.ANN.Core.Network.NeuralNetworkLayerTest;

public class TestRunner {
    public static void main(String[] args) {

        // ANN.Core.Neuron
        TestRunner.runTest(ActivationHeavisideTest.class);
        TestRunner.runTest(ActivationSigmoidTest.class);
        TestRunner.runTest(InputTest.class);
        TestRunner.runTest(NeuronTest.class);

        // Ann.Core.Network
        TestRunner.runTest(NeuralNetworkLayerTest.class);
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

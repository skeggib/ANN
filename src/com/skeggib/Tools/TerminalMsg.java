package com.skeggib.Tools;

public class TerminalMsg {

	public static void info(Object message) {
		System.out.println("\033[0;34m" + message.toString() + "\033[0;0m");
	}

	public static void message(Object message) {
		System.out.println("\033[0;37m" + message.toString() + "\033[0;0m");
	}

	public static void error(Object message) {
		System.out.println("\033[0;31m" + message.toString() + "\033[0;0m");
	}

	public static void success(Object message) {
		System.out.println("\033[1;32m" + message.toString() + "\033[0;0m");
	}

	public static void failure(Object message) {
		System.out.println("\033[1;31m" + message.toString() + "\033[0;0m");
	}

	public static void newline() {
		System.out.println("");
	}

}

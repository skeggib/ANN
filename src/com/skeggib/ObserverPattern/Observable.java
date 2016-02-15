package com.skeggib.ObserverPattern;

public interface Observable {

	public void registerObserver(Observer o);
	public void unregisterObserver(Observer o);
	public void notifyObservers();

}
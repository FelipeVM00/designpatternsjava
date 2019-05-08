package isw.observer.impl;

public interface IObservable {
	public void addObserver(IObserver observer);
	public void removeObserver(IObserver observer);
	public void notifyAllObservers(String command, Object source);
}

package isw.memento.impl;

import java.util.LinkedList;
import java.util.List;

public class EmployeeCareTaker {
	 private int currentIndex = -1;
	 private final List<EmployeeMemento> states = new LinkedList<>();

	 public void addNewMemento(EmployeeMemento m) {
		 states.add(m);
		 currentIndex++;
	 }
	 public EmployeeMemento getCurrentMemento() {
		 return states.get(currentIndex);
	 }

	 public EmployeeMemento getNextMemento() {
		 int newIndex = currentIndex +1;
		 if( newIndex >= states.size()){
			 return null;
		 }
		 currentIndex = newIndex;
		 return states.get(currentIndex);
	 }

	 public EmployeeMemento getPreviousMemento() {
		 int newIndex = currentIndex-1;

		 if(newIndex <= -1 || newIndex >= states.size()-1){
			 return null;
		 }
		 currentIndex= newIndex;
		 return states.get(currentIndex);
	 }
}

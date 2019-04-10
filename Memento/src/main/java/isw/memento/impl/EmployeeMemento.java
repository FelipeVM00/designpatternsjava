	package isw.memento.impl;

import isw.memento.entity.Employee;

public class EmployeeMemento {
	private Employee employee;
	
	public EmployeeMemento(Employee employee) {
		this.employee = employee;
	}
	
	public Employee getMemento(){
		return employee;
	}

}

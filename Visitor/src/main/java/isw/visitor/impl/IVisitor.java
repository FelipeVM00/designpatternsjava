package isw.visitor.impl;

import isw.visitor.domain.Activitie;
import isw.visitor.domain.Employee;
import isw.visitor.domain.Project;

public interface IVisitor<T> {
    public void project(Project project);
    public void activitie(Activitie activitie);
    public void employee(Employee employee);
    public T getResult();
}
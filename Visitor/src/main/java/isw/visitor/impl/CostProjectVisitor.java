package isw.visitor.impl;

import isw.visitor.domain.*;

public class CostProjectVisitor implements IVisitor<Number> {

    private double totalCost;

    @Override
    public void project(Project project) {
        for (Activitie act : project.getActivities()) {
            act.accept(this);
        }
    }

    @Override
    public void activitie(isw.visitor.domain.Activitie activitie) {
        activitie.getResponsible().accept(this);
        for (Activitie act : activitie.getActivities()) {
            act.accept(this);
        }
    }

    @Override
    public void employee(Employee employee) {
        totalCost += employee.getPrice();
    }

    @Override
    public Number getResult() {
        return totalCost;
    }
}
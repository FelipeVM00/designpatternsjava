package isw.visitor.impl;

import isw.visitor.domain.*;

public class PriceProjectVisitor implements IVisitor<Number> {

    private double totalPrice;

    @Override
    public void project(Project project) {
        for (Activitie act : project.getActivities()) {
            act.accept(this);
        }
    }

    @Override
    public void activitie(Activitie activitie) {
        totalPrice += activitie.getPrice();
        for (Activitie act : activitie.getActivities()) {
            act.accept(this);
        }
    }

    @Override
    public void employee(Employee employee) {
        // Not Interesting for this Visitor  
    }

    @Override
    public Number getResult() {
        return totalPrice;
    }
}

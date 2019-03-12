package isw.abstractfactory.ws;

import isw.abstractfactory.service.IEmployeeService;

public class EmployeeServiceWSImpl implements IEmployeeService {

    private static final String[] EMPLOYEES = new String[]{"Maria", "Rebeca", "Liliana"};

    @Override
    public String[] getEmployee() {
        System.out.println("WebServices");
        return EMPLOYEES;
    }

}

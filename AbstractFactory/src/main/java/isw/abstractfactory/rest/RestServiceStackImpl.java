package isw.abstractfactory.rest;

import isw.abstractfactory.impl.IServiceStackAbstractFactory;
import isw.abstractfactory.service.IEmployeeService;
import isw.abstractfactory.service.IProductsService;

public class RestServiceStackImpl implements IServiceStackAbstractFactory{

    @Override
    public IEmployeeService getEmployeeService() {
        return new EmployeeServiceRestImpl();
    }

    @Override
    public IProductsService getProductsService() {
        return new ProductServiceRestImpl();
    }
}
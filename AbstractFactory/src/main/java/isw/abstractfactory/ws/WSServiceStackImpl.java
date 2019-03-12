package isw.abstractfactory.ws;

import isw.abstractfactory.impl.IServiceStackAbstractFactory;
import isw.abstractfactory.service.IEmployeeService;
import isw.abstractfactory.service.IProductsService;

public class WSServiceStackImpl implements IServiceStackAbstractFactory{

    @Override
    public IEmployeeService getEmployeeService() {
        return new EmployeeServiceWSImpl();
    }

    @Override
    public IProductsService getProductsService() {
        return new ProductServiceWSImpl();
    }
}
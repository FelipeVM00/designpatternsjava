package isw.abstractfactory.impl;

import isw.abstractfactory.service.IEmployeeService;
import isw.abstractfactory.service.IProductsService;

public interface IServiceStackAbstractFactory {
    public IEmployeeService getEmployeeService();
    public IProductsService getProductsService();
}

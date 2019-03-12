package isw.abstractfactory;

import java.util.Arrays;
import isw.abstractfactory.impl.IServiceStackAbstractFactory;
import isw.abstractfactory.impl.ServiceStackAbstractFactory;
import isw.abstractfactory.service.IEmployeeService;
import isw.abstractfactory.service.IProductsService;

public class AbstractFactoryMain {

    public static void main(String[] args) {
        IServiceStackAbstractFactory factory = 
                ServiceStackAbstractFactory.createServiceFactory();
        IEmployeeService employeeService = factory.getEmployeeService();
        IProductsService productService = factory.getProductsService();
        
        System.out.println("EmployeeService class > " 
                + employeeService.getClass().getCanonicalName());
        System.out.println("ProductService class  > " 
                + productService.getClass().getCanonicalName());
        
        System.out.println("getEmployee > " 
                + Arrays.toString(employeeService.getEmployee()));
        System.out.println("getProduct  > " 
                + Arrays.toString(productService.getProducts()));
    }
}
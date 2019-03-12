package isw.abstractfactory.rest;

import isw.abstractfactory.service.IProductsService;

public class ProductServiceRestImpl implements IProductsService{
    private static final String[] PRODUCTS = new String[]{"Teclado","Mouse","Monitor"};

    @Override
    public String[] getProducts() {
        System.out.println("RestFul");
        return PRODUCTS;
    }
}
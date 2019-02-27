package isw.factorymethod;

import java.sql.SQLException;
import java.util.List;

import isw.factorymethod.dao.ProductDAO;
import isw.factorymethod.entity.Product;

public class FactoryMain {
	public static void main(String[] args) throws SQLException {
		
        //Creamos los nuevos productos a registrar
        Product productA = new Product(1L, "Product A", 100);
        Product productB = new Product(2L, "Product B", 100);
        
        //Creamos una instancia del DAO 
        ProductDAO productDAO = new ProductDAO();
        
        //Persistimos los productos
        productDAO.saveProduct(productA);
        productDAO.saveProduct(productB);
        
        //Consultamos nuevamente los productos 
        List<Product> products = productDAO.findAllProducts();
        System.out.println("Product size ==> " + products.size());
        for(Product product : products){
            System.out.println(product);
        }
    }
}

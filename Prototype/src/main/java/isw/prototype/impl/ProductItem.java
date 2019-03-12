package isw.prototype.impl;

public class ProductItem implements IPrototype<ProductItem> {
    private String name;
    private double price;
    private Product product;
    
    public ProductItem(){
    }

    public ProductItem(Product product) {
    	this();
    	this.product = product;
    	this.name = product.getName();
    	this.price = product.getPrice();
    }
    
    public ProductItem(String name, double price) {
        this();
        this.product = new Product(name, price);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.product.setName(name);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {       
        this.price = price;
        this.product.setPrice(price);
    }
    
    public Product getProduct() {
    	return product;
    }
    
    @Override
    public ProductItem clone() {
        return new ProductItem(this.name,this.price);
    }

    @Override
    public ProductItem deepClone() {
    	return new ProductItem(this.product);
    }

    @Override
    public String toString() {
        return product.toString();
    }
}
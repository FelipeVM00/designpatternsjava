package isw.chainofresponsability.domain.order;

import isw.chainofresponsability.domain.Product;

public class OrderItem {

    private Product product;
    private double price;
    private float quantity;

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getTotal(){
        return price*quantity;
    }
}

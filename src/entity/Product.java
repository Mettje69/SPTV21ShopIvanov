
package entity;


import java.util.Arrays;

public class Product {
    private String productName;
    private Customer[] customers;
    private int quantity;
    private int price;

    public Product() {
    }
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "productName=" + productName + ", customers=" + customers + ", quantity=" + quantity + ", price=" + price + '}';
    }
    
    public void setCustomer(Customer[] createCustomers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
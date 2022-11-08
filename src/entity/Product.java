
package entity;


import java.util.Arrays;

public class Product {
    private String productName;
    private Customer[] customers;
    private String quantity;
    private int price;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName= productName;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer){
        Customer[] newCustomer = Arrays.copyOf(customers, customers.length+1);
        newCustomer[newCustomer.length-1] = customer;
        this.customers = newCustomer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", customers=" + Arrays.toString(customers) +
                ", quantity='" + quantity + '\'' +
                ", price=" + price +
                '}';
    }

    public void setCustomer(Customer[] createCustomers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
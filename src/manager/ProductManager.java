
package manager;

import entity.Product;
import java.util.Scanner;


public class ProductManager {
    private Scanner scanner;

    public ProductManager() {
        this.scanner = new Scanner(System.in);
    }

    public Product addProduct() {
        Product product = new Product();
        System.out.println("Введите название продукта: ");
        product.setProductName(scanner.nextLine());
        System.out.println("Введите цену продукта: ");
        product.setPrice(scanner.nextInt());scanner.nextLine();
        System.out.println("Введите количество товара: ");
        product.setPrice(scanner.nextInt());
        scanner.nextLine();
        return product;
    }

    public void printListProducts(Product[] products){
        System.out.println("Продукты: ");
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            System.out.println(i+1+". "+product.getProductName()+" "+product.getPrice()+"€");
        }
        System.out.println();
    }

}
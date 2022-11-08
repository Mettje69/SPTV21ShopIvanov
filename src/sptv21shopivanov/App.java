

package sptv21shopivanov;

import entity.Customer;
import entity.Product;
import java.util.Arrays;
import java.util.Scanner;
import manager.CustomerManager;
import manager.ProductManager;


public class App {
    private Product[] products;
    private Customer[] customers;
    private final CustomerManager customerManager;
    private final ProductManager productManager;

    public App() {
        this.products = new Product[0];
        this.customers = new Customer[0];
        customerManager = new CustomerManager();
        productManager = new ProductManager();
    }

    public void run(){
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Список задач: ");
            System.out.println("1. Выход из программы");
            System.out.println("2. Добавить продукт");
            System.out.println("3. Список продаваемых продуктов");
            System.out.println("4. Добавить покупателя");
            System.out.println("5. Список зарегистрированных покупателей");
            System.out.println("6. Покупка покупателем продукта");
            System.out.println("7. Добавить денег покупателю");
            int task = scanner.nextInt();scanner.nextLine();
            System.out.println("⇕");
            switch (task) {
                case 1:
                    repeat = false;
                    System.out.println("1. Выход из программы");
                    break;
                case 2:
                    System.out.println("2. Добавить продукт");
                    this.products = Arrays.copyOf(this.products, this.products.length+1);
                    this.products[this.products.length-1] = productManager.addProduct();
                    break;
                case 3:
                    System.out.println("3. Список продаваемых продуктов");
                    productManager.printListProducts(products);
                    break;
                case 4:
                    System.out.println("4. Добавить покупателя");
                    this.customers =  Arrays.copyOf(this.customers, this.customers.length+1);
                    this.customers[this.customers.length-1] = customerManager.createCustomer();
                case 5:
                    System.out.println("5. Список зарегистрированных покупателей");
                    System.out.println("Список покупателей: ");
                    customerManager.printListCustomers(customers);
                    break;
                case 6:
                    System.out.println("6. Покупка покупателем продукта");
                    System.out.println("Список покупателей: ");
                    customerManager.printListCustomers(customers);
                    int buy1 = scanner.nextInt();
                    System.out.println("Список продуктов: ");
                    for(int j = 0; j<products.length; j++){
                        System.out.println(j+1);
                    }
                    productManager.printListProducts(products);
                    int buy2 = scanner.nextInt();
                    int pur = customers[buy1-1].getCash() - products[buy2-1].getPrice();
                    customers[buy1-1].setCash(pur);
                    System.out.println("Остаток на счету: "+pur+"€");

                    break;
                case 7:
                    System.out.println("8. Добавить денег покупателю");
                    System.out.println("Выберите покупателя: ");
                    System.out.println("Список покупателей: ");
                    customerManager.printListCustomers(customers);
                    int turn = scanner.nextInt(); scanner.nextLine();
                    System.out.println("Сколько денег добавить: ");
                    int addMoney = scanner.nextInt(); scanner.nextLine();
                    int TotalMoney = customers[turn -1].getCash()+ addMoney;
                    customers[turn -1].setCash(TotalMoney);
                    break;
            }
            System.out.println("⇕");
        }while(repeat);
        System.out.println("Program Ended...");
    }

}
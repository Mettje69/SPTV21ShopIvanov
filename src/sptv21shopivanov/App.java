

package sptv21shopivanov;

import entity.Customer;
import entity.Product;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import manager.CustomerManager;
import manager.ProductManager;


public class App {
    private Product[] products;
    private Customer[] customers;
    private final CustomerManager customerManager;
    private final ProductManager productManager;
    int history[];

    public App() {
        this.products = new Product[0];
        this.customers = new Customer[0];
        customerManager = new CustomerManager();
        productManager = new ProductManager();
        this.history = new int[0];
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
            System.out.println("7. Оборот магазина за все время работы");
            System.out.println("8. Добавить денег покупателю");
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
                    System.out.println("6. Покупка продукта");
                    for (int i = 0; i<products.length;i++){
                        Product product = products[i];
                        System.out.println("");
                        System.out.println(i+1+". \n"+"Название продукта: "+product.getProductName());
                        System.out.println("Цена продукта: "+product.getPrice()+"€");
                    }
                    for (int i = 0; i<customers.length;i++){
                        Customer customer = customers[i];
                        System.out.println("");
                        System.out.println(i+1+". \n"+"Имя покуателя: "+customer.getFirstname());
                        System.out.println("Фамлиля покуателя: "+customer.getLastname());
                        System.out.println("Балланс покуателя: "+customer.getCash()+"€");
                        System.out.println("");
                        System.out.print("Выберите продукт: ");
                        int product_a = scanner.nextInt();
                        System.out.print("Выберите покупателя: ");
                        int customer_a = scanner.nextInt();
                        int purchase = customers[customer_a-1].getCash()- products[product_a-1].getPrice();
                        customers[product_a-1].setCash(purchase);
                        this.history = Arrays.copyOf(this.history, this.history.length+1);
                        this.history[this.history.length-1] = products[product_a-1].getPrice();
                        System.out.println("После покупки: "+customer.getFirstname()+" "+customer.getLastname()+" "+customer.getCash()+"€");
                    }
                    break;
                case 7:
                    System.out.println("7. Оборот магазина за все время работы");
                    int sum = IntStream.of(history).sum();
                    System.out.println("Оборот магазина = "+sum+"€");
                    break;
                case 8:
                    System.out.println("8. Добавить денег покупателю");
                    System.out.println("Выберите покупателя: ");
                    System.out.println("Список покупателей: ");
                    customerManager.printListCustomers(customers);
                    int turn = scanner.nextInt(); scanner.nextLine();
                    System.out.println("Сколько денег добавить: ");
                    int addMoney = scanner.nextInt(); scanner.nextLine();
                    int TotalMoney = customers[turn-1].getCash()+ addMoney;
                    customers[turn-1].setCash(TotalMoney);
                    break;
            }
            System.out.println("⇕");
        }while(repeat);
        System.out.println("Program Ended...");
    }

}
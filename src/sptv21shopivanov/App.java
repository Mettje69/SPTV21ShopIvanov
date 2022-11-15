

package sptv21shopivanov;

import entity.Customer;
import entity.History;
import entity.Product;
import java.util.Arrays;
import java.util.Scanner;
import manager.CustomerManager;
import manager.ProductManager;
import manager.HistoryManager;


public class App {
    private Product[] products;
    private Customer[] customers;
    private History[] histories;
    private final CustomerManager customerManager;
    private final ProductManager productManager;
    private final HistoryManager historyManager;

    public App() {
        products = new Product[0];
        customers = new Customer[0];
        histories = new History[0];
        customerManager = new CustomerManager();
        productManager = new ProductManager();
        historyManager = new HistoryManager();
        
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
                    addHistory(historyManager.takeOnProduct(products, customers));
                    break;
                case 7:
                    System.out.println("7. Оборот магазина за все время работы");
                    historyManager.printListPurchases(histories);
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
    
    private void addHistory(History histories) {
        this.histories = Arrays.copyOf(this.histories, this.histories.length+1);
        this.histories[this.histories.length - 1] = histories;   
    }
}

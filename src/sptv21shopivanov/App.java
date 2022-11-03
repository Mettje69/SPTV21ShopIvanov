/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptv21shopivanov;

import entity.Money;
import entity.Customer;
import entity.History;
import entity.Product;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Anatoli
 */
public class App {
    private Product[] products;
    private Customer[] customers;
    private History[] histories;
    private Money[] moneys;

    public App() {
        products = new Product[0];
        customers = new Customer[0];
        histories = new History[0];
        moneys = new Money[0];
    }
   
    
    public void run(){
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
        History history = null;
        int AllMoney = 1;
        do{
            System.out.println("Задачи: ");
            System.out.println("1. Выход из программы");
            System.out.println("2. Добавить продукт");
            System.out.println("3. Список продаваемых продуктов");
            System.out.println("4. Добавить покупателя");
            System.out.println("5. Список зарегистрированных покупателей");
            System.out.println("6. Покупка покупателем продукта");
            System.out.println("7. Оборот магазина за все время работы");
            System.out.println("8. Добавить денег покупателю");
            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 1:
                    repeat = false;
                    break;
                case 2:
                    System.out.println("2. Добавить продукт");
                    Product product = new Product();
                    System.out.print("Введите название продукта: ");
                    product.setProductName(scanner.nextLine());
                    System.out.print("Введите цену продукта: ");
                    product.setProductPrice(scanner.nextInt());
                    System.out.print("Введите количесто продукта: ");
                    product.setQuantity(scanner.nextInt());
                    this.products = Arrays.copyOf(this.products, this.products.length+1);
                    this.products[this.products.length - 1] = product;
                    break;
                case 3:
                    System.out.println("3. Список продаваемых продуктов");
                    for (int i = 0; i < products.length; i++) {
                        System.out.println(i+1+". "+products[i].getProductName()+". "+products[i].getProductPrice()+"$ "+products[i].getQuantity()+"шт. ");
                    }
                    break;
                case 4:
                    System.out.println("4. Добавить покупателя");
                    Customer customer = new Customer();
                    System.out.print("Введите имя покупателя: ");
                    customer.setFirstname(scanner.nextLine());
                    System.out.print("Введите фамилию покупателя: ");
                    customer.setLastname(scanner.nextLine());
                    System.out.print("Введите телефон покупателя: ");
                    customer.setPhone(scanner.nextInt());
                    System.out.print("Введите деньги покупателя: ");
                    customer.setPersonalmoney(scanner.nextInt());
                    this.customers = Arrays.copyOf(this.customers, this.customers.length+1);
                    this.customers[this.customers.length - 1] = customer;
                    break;
                case 5:
                    System.out.println("5. Список зарегистрированных покупателей");
                    for (int i = 0; i < customers.length; i++) {
                        System.out.println(i+1+". "+customers[i].getFirstname()+" "+customers[i].getLastname()+". "+customers[i].getPhone()+" "+customers[i].getPersonalmoney()+"$");
                    }
                    break;
                case 6:
                    System.out.println("Список продуктов: ");
                    for (int i = 0; i < products.length; i++) {
                        System.out.println(i+1+". "+products[i].getProductName()+". "+products[i].getProductPrice()+"$ "+products[i].getQuantity());
                    }
                    System.out.println("Список покупателей: ");
                    for (int i = 0; i < customers.length; i++) {
                        System.out.println(i+1+". "+customers[i].getFirstname()+" "+customers[i].getLastname()+". "+customers[i].getPhone()+" "+customers[i].getPersonalmoney()+"$");
                    }
                    System.out.println();
                    System.out.print("Выбери номер продукта: ");
                    int numberProduct = scanner.nextInt();scanner.nextLine();
                    history = new History();
                    history.setProduct(products[numberProduct - 1]);
                    this.histories = Arrays.copyOf(this.histories, this.histories.length+1);
                    this.histories[this.histories.length - 1] = history;
                    System.out.println(history);
                    
                    System.out.print("Выбери номер покупателя: ");
                    int numberCustomer = scanner.nextInt();scanner.nextLine();
                    history = new History();
                    history.setCustomer(customers[numberCustomer - 1]);
                    this.histories = Arrays.copyOf(this.histories, this.histories.length+1);
                    this.histories[this.histories.length - 1] = history;
                    System.out.println(history);
                    if (numberProduct==1){
                        for (int i = 0; i < customers.length; i++) {
                        System.out.println(customers[i].getPersonalmoney()+"$ ");
                        }
                        System.out.println(" -");
                        for (int i = 0; i < products.length; i++) {
                        System.out.println(products[i].getProductPrice()+"$ ");
                        }
                    }
                    break;
                case 7:
                    System.out.println("7. Оборот магазина за все время работы");
                    System.out.println("Оборот магазина за все время работы: "+AllMoney+"$");
                    break;
                case 8:
                    System.out.print("Добавить денег покупателю: ");
                    System.out.println("Список покупателей: ");
                    for (int i = 0; i < customers.length; i++) {
                        System.out.println(i+1+". "+customers[i].getFirstname()+" "+customers[i].getLastname()+". "+customers[i].getPhone()+" "+customers[i].getPersonalmoney()+"$");
                    }
                    System.out.print("Выбери номер покупателя: ");
                    numberCustomer = scanner.nextInt();
                    history = new History();
                    history.setCustomer(customers[numberCustomer - 1]);
                    System.out.print("Введите сумму: ");
                    history.setMoney(scanner.nextInt());
                    this.histories = Arrays.copyOf(this.histories, this.histories.length+1);
                    this.histories[this.histories.length - 1] = history;
                    System.out.println(history);
                    break;
                default:
                    System.out.println("Выберите задачу из списка!");;
            }
            
        }while(repeat);
        System.out.println("Закрытие программы, досвидания!");
    }
    public Product createProduct(String productName,int productPrice,int quantity){
        Product product = new Product();
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setQuantity(quantity);
        return product;
    }
    public Customer createCustomer(String firstname, String lastname, int phone,int pesonalmoney){
        Customer customer = new Customer();
        customer.setPhone(phone);
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setPersonalmoney(pesonalmoney);
        return customer;
    }
    public Money createMoney(int amount){
        Money money = new Money();
        money.setAmount(amount);
        return money;
    }
    
}

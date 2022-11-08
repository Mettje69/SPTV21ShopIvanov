

package manager;

import entity.Customer;
import java.util.Scanner;

public class CustomerManager{
    private final Scanner scanner = new Scanner(System.in);
    public Customer createCustomer(){
        Customer customer = new Customer();
        System.out.print("Введите имя покупателя: ");
        customer.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию покупателя: ");
        customer.setLastname(scanner.nextLine());
        return customer;
    }

    public void printListCustomers(Customer[] customers) {
        for (int i = 0; i < customers.length; i++) {
            Customer customer = customers[i];
            System.out.println(i+1+". "+customer.getFirstname()+" "+customer.getLastname()+" Cash:"+customer.getCash());
        }
    }
}
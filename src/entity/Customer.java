/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Anatoli
 */
public class Customer {
    private String firstname;
    private String lastname;
    private int phone;
    private int personalmoney;

    public Customer() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPersonalmoney() {
        return personalmoney;
    }

    public void setPersonalmoney(int personalmoney) {
        this.personalmoney = personalmoney;
    }

    @Override
    public String toString() {
        return "Customer{" + "firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone + ", personalmoney=" + personalmoney + '}';
    }

    
    
}
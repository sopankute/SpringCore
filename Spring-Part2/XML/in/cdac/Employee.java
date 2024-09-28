/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.cdac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author CDAC
 */
@Component
public class Employee {

    private int id;
    private String name;
    private String email;
    @Autowired
    private Address address;
    private Address address1;
   
    Employee(){}  
    
    // Constructor based injection
    public Employee(int id, String name, String email, Address ads){
        System.out.println("----- constructor");
        this.id = id;
        this.name = name;
        this.email = email;        
        address = ads;
    }
    
    // Setter based injection
    public void setAddress(Address address) {
        this.address = address;
    }
      
    public Address getAddress() {
        return address;
    }         
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
}

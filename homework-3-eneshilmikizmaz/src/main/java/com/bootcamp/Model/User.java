package com.bootcamp.Model;

import com.bootcamp.Model.Enums.FirmType;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Data
public class User {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private FirmType firmType;
    private Address address;
    private List<Customer> customerList = new ArrayList<>(10);

    public User(int id, String name, String surname, String email, String password, FirmType firmType, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.firmType = firmType;
        this.address = address;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public FirmType getFirmType() {
        return firmType;
    }

    public void setFirmType(FirmType firmType) {
        this.firmType = firmType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}

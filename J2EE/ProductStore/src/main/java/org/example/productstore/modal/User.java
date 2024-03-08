package org.example.productstore.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String fName;
    private String lName;
    private String phone;
    private String email;
    private String password;
    private int addressId;

    public User() {}

    public User(Long id, String fName, String lName, String phone, String email, String password, int addressId) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.addressId = addressId;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getfName() {return fName;}

    public void setfName(String fName) {this.fName = fName;}

    public String getlName() {return lName;}

    public void setlName(String lName) {this.lName = lName;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public int getAddressId() {return addressId;}

    public void setAddressId(int addressId) {this.addressId = addressId;}
}

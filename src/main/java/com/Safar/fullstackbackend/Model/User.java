package com.Safar.fullstackbackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id //booking id
    @GeneratedValue//will automatically generate unique id
    private Long id;
    private String address;
    private String name;
    private String email;
    private Long userPhone;
    private String userDestination;
    private Long userCount;
    private String userName;
    private String userLeavingDate;


    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Long getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }
    public String getUserDestination() {
        return userDestination;
    }
    public void setUserDestination(String userDestination) {
        this.userDestination = userDestination;
    }
    public Long getUserCount() {
        return userCount;
    }
    public void setUserCount(Long userCount) {
        this.userCount = userCount;
    }
    public String getuserName() {
        return userName;
    }
    public void setuserName(String userName) {
        this.userName = userName;
    }
    public String getUserLeavingDate() {
        return userLeavingDate;
    }
    public void setUserLeavingDate(String userLeavingDate) {
        this.userLeavingDate = userLeavingDate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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

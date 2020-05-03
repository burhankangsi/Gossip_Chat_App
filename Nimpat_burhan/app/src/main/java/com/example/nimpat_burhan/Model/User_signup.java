package com.example.nimpat_burhan.Model;

public class User_signup {
    String user_Name;
    String user_Email;
    String user_Phone;
    String user_City;
    String user_Pass;
    long createdAt;

    public User_signup(String displayName, String userEmail, String userPhone, String userCity, String userPass, long time) {

        this.user_Name=displayName;
        this.user_Email=userEmail;
        this.user_Phone = userPhone;
        this.user_City = userCity;
        this.user_Pass = userPass;
        this.createdAt=time;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Email() {
        return user_Email;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    public String getUser_Phone() {
        return user_Phone;
    }

    public void setUser_Phone(String user_Phone) {
        this.user_Phone = user_Phone;
    }

    public String getUser_City() {
        return user_City;
    }

    public void setUser_City(String user_City) {
        this.user_City = user_City;
    }

    public String getUser_Pass() {
        return user_Pass;
    }

    public void setUser_Pass(String user_Pass) {
        this.user_Pass = user_Pass;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }




}

package com.kapasiya.indoremetro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_data")
public class UserData
{
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String name;

    @Id
    @Column(nullable = false,length = 10)
    private String number;
    @Column(nullable = false)
    private String password;

    @Column
    private String confirm;

    public UserData(String email, String name, String number, String password,String confirm) {
        this.email = email;
        this.name = name;
        this.number = number;
        this.password = password;
        this.confirm = confirm;
    }

    public UserData()
    {

    }

    public String getCpassword() {
        return confirm;
    }

    public void setCpassword(String cpassword) {
        this.confirm = cpassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", confirm='" + confirm + '\'' +
                '}';
    }
}

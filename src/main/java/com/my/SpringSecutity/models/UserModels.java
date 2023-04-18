package com.my.SpringSecutity.models;


//import jakarta.persistence.*;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Size;
//import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "users")
public class UserModels {

    @Id
    @Column(name = "id_users")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    @Column(name = "username")
    @Size(max = 25, message = "Мах символ 25 и не больше")
    private String userName;

    @Column(name = "yearsofbirth")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateOfBirth;

    @Column(name = "password")
    @Size(min = 2, message = "min=2  символов")
    private String password;

    @Column(name = "role")
    private String role;

    public UserModels() {

    }

    public UserModels(String log, Date date) {
        this.userName = log;
        this.dateOfBirth = date;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Id="+id_user+", name="+userName+
                ", birth="+dateOfBirth+", password="+password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

package com.ncpc.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String nic;
    private String email;
    private String address;
    private String phoneNumber;

    public Customer(String states) {
        this.states = states;
    }

    private String states = "pending";



    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="invoice",referencedColumnName = "id")
    private List<Product> products;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_time")
    private Time createdTime;

    @PrePersist
    public void prePersist() {
        java.util.Date currentDate = new java.util.Date();
        createdDate = new Date(currentDate.getTime());
        createdTime = new Time(currentDate.getTime());
    }



    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }
}

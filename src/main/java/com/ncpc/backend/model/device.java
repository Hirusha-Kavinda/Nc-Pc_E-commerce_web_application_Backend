package com.ncpc.backend.model;

import javax.persistence.*;

@Entity
@Table( name = "Device")
public class device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DeviceId")
    private long id;

    @Column( name ="name")
    private String name;

    @Column( name ="price")
    private Double price;

    @Column( name ="image")
    private String imageUrl;

    @Column( name ="details")
    private String details;

    @Column( name = "categoryID")
    private Integer categoryID ;

    @Column( name = "counter")
    private Integer qnt = 1;

    public device() {
    }

    public device(String name, Double price, String imageUrl, String details, Integer categoryID , Integer qnt) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.details = details;
        this.categoryID =categoryID;
        this.qnt = qnt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getQnt() {
        return qnt;
    }

    public void setQnt(Integer qnt) {
        this.qnt = qnt;
    }
}

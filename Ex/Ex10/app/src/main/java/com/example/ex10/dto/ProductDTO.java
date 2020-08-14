package com.example.ex10.dto;

import java.io.Serializable;

// 전달할 데이터가 객체일 경우에는 객체직렬화를 해주어야 한다
public class ProductDTO implements Serializable {

    private int id;
    private String name;
    private int price;
    private int amount;

    public ProductDTO() {}

    public ProductDTO(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public ProductDTO(int id, String name, int price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

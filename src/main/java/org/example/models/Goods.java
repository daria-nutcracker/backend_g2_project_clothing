package org.example.models;

import java.text.DecimalFormat;

/**
 Класс - реализация сущности товаров
 */
public class Goods {
    private int id;
    private String name;
    private double price;
    private int count;

    public Goods(int id, String name, double price, int count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        String formattedPrice = new DecimalFormat("#0.00").format(price);
        return "Товар: " + name + " id = " + id + " стоимостью " + formattedPrice + " в количестве " + count;
    }
}

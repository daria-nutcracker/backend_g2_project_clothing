package org.example.models;

import java.util.ArrayList;

/**
 Класс - реализация сущности каталогов
 */
public class Catalogs {
    int id;
    String name;
    ArrayList<Goods> goods;

    public Catalogs(int id, String name, ArrayList<Goods> goods) {
        this.id = id;
        this.name = name;
        this.goods = goods;
    }

    public Catalogs() {
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

    public ArrayList<Goods> getGoods() {
        return goods;
    }

    public void setGoods(ArrayList<Goods> goods) {
        this.goods = goods;
    }
}

package org.example.models;

import java.util.ArrayList;

/**
 Класс - реализация сущности каталогов
 */
public class Catalogs {
    int id;
    String name;
    ArrayList<Goods> goods;

    public Catalogs(int id, String name) {
        this.id = id;
        this.name = name;
        this.goods = new ArrayList<Goods>();
    }

    public void addGoods(Goods goods){
        this.goods.add(goods);
    }
    public void deleteGoods(Goods goods){
        if(this.goods.contains(goods)){
            this.goods.remove(goods);
        };
    }

    @Override
    public String toString() {
        return "Каталог " + name + " {\n"
                 + "id: " + id + "\n"
                + "goods: " + goods.toString() + " }\n";
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

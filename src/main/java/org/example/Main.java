package org.example;

import org.example.models.Catalogs;
import org.example.models.Goods;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Привет! Я - интернет-магазин.");
        Catalogs childrenClothes = new Catalogs(1, "Детская одежда");
        Catalogs womenClothes = new Catalogs(2, "Женская одежда");
        Catalogs menClothes = new Catalogs(3, "Мужская одежда");
        Catalogs shoes = new Catalogs(4, "Обувь");
        Catalogs accessoires = new Catalogs(5, "Аксессуары");

        try{
            File file = new File("C:\\Users\\AlyaZagatskaya\\IdeaProjects\\backend3_g2_project_clothing\\src", "goods.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int index = 1;

            while (line != null) {
                String[] goodsDetails = line.split("_");
                Goods newStuff = new Goods(index, goodsDetails[0], Integer.parseInt(goodsDetails[1]), Integer.parseInt(goodsDetails[2]));
                if(index <= 5) {
                    childrenClothes.addGoods(newStuff);
                }
                else if(index <= 10) {
                    womenClothes.addGoods(newStuff);
                }
                else if(index <= 15) {
                    menClothes.addGoods(newStuff);
                }
                else if(index <= 20) {
                    shoes.addGoods(newStuff);
                }
                else if(index <= 25) {
                    accessoires.addGoods(newStuff);
                }
                line = br.readLine();
                index++;
            }
            System.out.println(childrenClothes.toString());
            System.out.println(womenClothes.toString());
            System.out.println(menClothes.toString());
            System.out.println(shoes.toString());
            System.out.println(accessoires.toString());

        }catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Goods testGoods = new Goods(26, "Рубашка женская оверсайз", 3800, 12);
        womenClothes.addGoods(testGoods);
        System.out.println(womenClothes.toString());
        womenClothes.deleteGoods(testGoods);
        System.out.println(womenClothes.toString());

        // Детская одежда
        Goods girlDressGoods = new Goods(1, "Платье для девочки", 2000, 7);
        Goods boypantsGoods = new Goods(2, "Штанишки для мальчика", 1500, 12);
        Goods girlcoatGoods = new Goods(3, "Пальто детское демисезонное для девочки", 3500, 5);
        Goods boyt_shirtGoods = new Goods(4, "Футболка детская для мальчика", 800, 10);
        Goods boyjacketGoods = new Goods(5, "Куртка детская утепленная для мальчика", 4500, 3);

    }

    public void createGoods (Catalogs catalogName, int id, String name, double price, int count) {
        Goods newGood = new Goods(id, name, price, count);
        catalogName.addGoods(newGood);
    }

    public void readGoods (ArrayList<Goods> goods, int id) {
        for (Goods good : goods)
            if (good.getId() == id) {
                System.out.println(good.toString());
                break;
            }
    }

    public void updateGoods (ArrayList<Goods> goods, int id) {

    }
}
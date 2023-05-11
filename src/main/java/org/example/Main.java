package org.example;

import org.example.models.Catalogs;
import org.example.models.Goods;

import java.io.*;

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

    }
}
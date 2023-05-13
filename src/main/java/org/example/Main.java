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

        // Женская одежда
        Goods eveningDressGoods = new Goods(6, "Платье женское вечернее", 7000, 4);
        Goods cocktailDressGoods = new Goods(7, "Платье женское коктейльное", 5000, 6);
        Goods officeDressGoods = new Goods(8, "Платье женское офисное", 3500, 8);
        Goods blouseGoods = new Goods(9, "Блузка женская", 2500, 10);
        Goods skirtGoods = new Goods(10, "Юбка женская", 3000, 7);

        // Мужская одежда
        Goods t_shirtGoods = new Goods(11, "Футболка мужская", 1200, 15);
        Goods shirtGoods = new Goods(12, "Рубашка мужская", 3500, 8);
        Goods jeansGoods = new Goods(13, "Джинсы мужские", 4000, 5);
        Goods costumeGoods = new Goods(14, "Костюм мужской", 8500, 2);
        Goods wintercoatGoods = new Goods(15, "Куртка мужская зимняя", 7000, 4);

        // Обувь
        Goods womenshoesGoods = new Goods(16, "Туфли женские", 4500, 9);
        Goods mensneakersGoods = new Goods(17, "Кроссовки мужские", 3500, 12);
        Goods womenbootsGoods = new Goods(18, "Ботинки женские осенние", 6000, 5);
        Goods winterbootsGoods = new Goods(19, "Сапоги женские зимние", 9000, 3);
        Goods menbootsGoods = new Goods(20, "Кеды мужские", 2500, 15);

        // Аксессуары
        Goods enbeltGoods = new Goods(21, "Ремень мужской", 1000, 20);
        Goods womenhatGoods = new Goods(22, "Шапка женская", 1500, 10);
        Goods womenscarfGoods = new Goods(23, "Шарф женский", 1200, 15);
        Goods glovesGoods = new Goods(24, "Перчатки женские", 1500, 8);
        Goods jewelryGoods = new Goods(25, "Бижутерия", 500, 30);
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
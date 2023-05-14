package org.example;

import org.example.models.Catalogs;
import org.example.models.Goods;
import org.example.models.Users;

import java.io.*;
import java.util.*;


import java.time.LocalDate;

public class Main {
    // Вспомогательный метод для получения полного имени пользователя (имя + фамилия)
    private static String getUserFullName(int userId) {
        switch (userId) {
            case 1:
                return "Митя Фомин";
            case 2:
                return "Катя Иванова";
            case 3:
                return "Дима Алексеев";
            case 4:
                return "Лилия Шварц";
            case 5:
                return "Миша Ли";
            default:
                return "";
        }
    }
    public static void createGoods (Catalogs catalogName, int id, String name, double price, int count) {
        Goods newGood = new Goods(id, name, price, count);
        catalogName.addGoods(newGood);
        System.out.println("Товар: " + newGood.toString() + " был создан.");

    }

    public static void readGoods (ArrayList<Goods> goods, int id) {
        for (Goods good : goods)
            if (good.getId() == id) {
                System.out.println("Товар: " + good.toString() + " был найден.");
                break;
            }
    }

    public static void updateCountGoods (ArrayList<Goods> goods, int id, int count) {
        for (Goods good : goods)
            if (good.getId() == id) {
                good.setCount(count);
                System.out.println("Количество товара: " + good.toString() + " был изменено.");
                break;
            }
    }

    public static void updatePriceGoods (ArrayList<Goods> goods, int id, double price) {
        for (Goods good : goods)
            if (good.getId() == id) {
                good.setPrice(price);
                System.out.println("Цена товара: " + good.toString() + " был изменена.");
                break;
            }
    }
    public static void deleteGoods (Catalogs catalog, int id) {
        for (Goods good : catalog.getGoods())
            if (good.getId() == id) {
                System.out.println("Удаляем товар: " + good.toString());
                catalog.deleteGoods(good);
                break;
            }
    }

    public static Catalogs createCatalog (int id, String name) {
        Catalogs catalog = new Catalogs(id, name);
        System.out.println("Каталог: " + catalog.toString() + " был создан.");
        return catalog;
    }

    public static void readCatalog (ArrayList<Catalogs> catalogs, int id) {
        for (Catalogs catalog : catalogs)
            if (catalog.getId() == id) {
                System.out.println("Каталог: " + catalog.toString() + " был найден.");
                break;
            }
    }

    public static void updateCatalogs (ArrayList<Catalogs> catalogs, int id, String newName) {
        for (Catalogs catalog : catalogs)
            if (catalog.getId() == id) {
                catalog.setName(newName);
                System.out.println("Каталог: " + catalog.toString() + " был изменен.");
                break;
            }
    }
    public static void deleteCatalogs (ArrayList<Catalogs> catalogs, int id) {
        for (int i = 0; i < catalogs.size();i++)
            if (catalogs.get(i).getId() == id) {
                System.out.println("Удаляем каталог: " + catalogs.get(i).toString());
                catalogs.remove(i);
                break;
            }
    }

    public static ArrayList <Users> userList = new ArrayList<Users>();
    public static void createUser(Users user) {
        userList.add(user);
        System.out.println("Пользователь " + user.getFirstName() + " " + user.getLastName() + " id=" + user.getId() + " создан в базе данных");
    }

    public static void findUserById(int id) {
        for (Users user : userList) {
            if (user.getId() == id) {
                System.out.println("Пользователь " + user.getFirstName() + " " + user.getLastName() + " id=" + user.getId() + " был найден");
                return;
            }
        }
        System.out.println("Пользователь с id=" + id + " не найден");
    }

    public static void updateUser(Users user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == user.getId()) {
                userList.set(i, user);
                System.out.println("Пользователь " + user.getFirstName() + " " + user.getLastName() + " id=" + user.getId() + " изменена дата рождения");
                return;
            }
        }
        System.out.println("Пользователь с id=" + user.getId() + " не найден");
    }

    public static void deleteUser(int id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                Users deletedUser = userList.remove(i);
                System.out.println("Пользователь " + deletedUser.getFirstName() + " " + deletedUser.getLastName() + " id=" + deletedUser.getId() + " удален из базы данных");
                return;
            }
        }
        System.out.println("Пользователь с id=" + id + " не найден");
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Привет! Я - интернет-магазин.");

        //Создать 5 каталогов
        ArrayList <Catalogs> categories = new ArrayList<Catalogs>();
         Catalogs childrenClothes = new Catalogs(1, "Детская одежда");
        categories.add(childrenClothes);
        Catalogs womenClothes = new Catalogs(2, "Женская одежда");
        categories.add(womenClothes);
        Catalogs menClothes = new Catalogs(3, "Мужская одежда");
        categories.add(menClothes);
        Catalogs shoes = new Catalogs(4, "Обувь");
        categories.add(shoes);
        Catalogs accessoires = new Catalogs(5, "Аксессуары");
        categories.add(accessoires);

        //crud операции для каталогов
        categories.add( createCatalog ( 6, "Белье"));
        readCatalog (categories, 6);
        updateCatalogs (categories, 6, "Нижнее белье");
        readCatalog (categories, 6);
        deleteCatalogs(categories, 6);

        //дополнительная задача - чтение из файла
        try{
            File file = new File( "goods.txt");
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
/*
        Goods testGoods = new Goods(26, "Рубашка женская оверсайз", 3800, 12);
        womenClothes.addGoods(testGoods);
        System.out.println(womenClothes.toString());
        womenClothes.deleteGoods(testGoods);
        System.out.println(womenClothes.toString());
*/

        //Добавление всех товаров в каталоги. Вывод на экран
        int i = 0;
        // Детская одежда
        Goods girlDressGoods = new Goods(1, "Платье для девочки", 2000, 7);
        categories.get(i).addGoods(girlDressGoods);
        Goods boypantsGoods = new Goods(2, "Штанишки для мальчика", 1500, 12);
        categories.get(i).addGoods(boypantsGoods);
        Goods girlcoatGoods = new Goods(3, "Пальто детское демисезонное для девочки", 3500, 5);
        categories.get(i).addGoods(girlcoatGoods);
        Goods boyt_shirtGoods = new Goods(4, "Футболка детская для мальчика", 800, 10);
        categories.get(i).addGoods(boyt_shirtGoods);
        Goods boyjacketGoods = new Goods(5, "Куртка детская утепленная для мальчика", 4500, 3);
        categories.get(i).addGoods(boyjacketGoods);

        System.out.println(categories.get(i).toString());
        i++;

        // Женская одежда
        Goods eveningDressGoods = new Goods(6, "Платье женское вечернее", 7000, 4);
        categories.get(i).addGoods(eveningDressGoods);
        Goods cocktailDressGoods = new Goods(7, "Платье женское коктейльное", 5000, 6);
        categories.get(i).addGoods(cocktailDressGoods);
        Goods officeDressGoods = new Goods(8, "Платье женское офисное", 3500, 8);
        categories.get(i).addGoods(officeDressGoods);
        Goods blouseGoods = new Goods(9, "Блузка женская", 2500, 10);
        categories.get(i).addGoods(blouseGoods);
        Goods skirtGoods = new Goods(10, "Юбка женская", 3000, 7);
        categories.get(i).addGoods(skirtGoods);

        System.out.println(categories.get(i).toString());
        i++;

        // Мужская одежда
        Goods t_shirtGoods = new Goods(11, "Футболка мужская", 1200, 15);
        categories.get(i).addGoods(t_shirtGoods);
        Goods shirtGoods = new Goods(12, "Рубашка мужская", 3500, 8);
        categories.get(i).addGoods(shirtGoods);
        Goods jeansGoods = new Goods(13, "Джинсы мужские", 4000, 5);
        categories.get(i).addGoods(jeansGoods);
        Goods costumeGoods = new Goods(14, "Костюм мужской", 8500, 2);
        categories.get(i).addGoods(costumeGoods);
        Goods wintercoatGoods = new Goods(15, "Куртка мужская зимняя", 7000, 4);
        categories.get(i).addGoods(wintercoatGoods);

        System.out.println(categories.get(i).toString());
        i++;
        // Обувь
        Goods womenshoesGoods = new Goods(16, "Туфли женские", 4500, 9);
        categories.get(i).addGoods(womenshoesGoods);
        Goods mensneakersGoods = new Goods(17, "Кроссовки мужские", 3500, 12);
        categories.get(i).addGoods(mensneakersGoods);
        Goods womenbootsGoods = new Goods(18, "Ботинки женские осенние", 6000, 5);
        categories.get(i).addGoods(womenbootsGoods);
        Goods winterbootsGoods = new Goods(19, "Сапоги женские зимние", 9000, 3);
        categories.get(i).addGoods(winterbootsGoods);
        Goods menbootsGoods = new Goods(20, "Кеды мужские", 2500, 15);
        categories.get(i).addGoods(menbootsGoods);

        System.out.println(categories.get(i).toString());
        i++;

        // Аксессуары
        Goods enbeltGoods = new Goods(21, "Ремень мужской", 1000, 20);
        categories.get(i).addGoods(enbeltGoods);
        Goods womenhatGoods = new Goods(22, "Шапка женская", 1500, 10);
        categories.get(i).addGoods(womenhatGoods);
        Goods womenscarfGoods = new Goods(23, "Шарф женский", 1200, 15);
        categories.get(i).addGoods(womenscarfGoods);
        Goods glovesGoods = new Goods(24, "Перчатки женские", 1500, 8);
        categories.get(i).addGoods(glovesGoods);
        Goods jewelryGoods = new Goods(25, "Бижутерия", 500, 30);
        categories.get(i).addGoods(jewelryGoods);

        System.out.println(categories.get(i).toString());

        //crud операции для Товаров
        createGoods(categories.get(i), 26, "Шляпка женская", 1340, 5);
        readGoods(categories.get(i).getGoods(), 26);
        updateCountGoods(categories.get(i).getGoods(), 26, 4);
         deleteGoods(categories.get(i), 26);





         //Создание юзеров
        userList.add(new Users(1, "Митя", "Фомин", "fomin@mail.com", 'M', LocalDate.of(1990, 5, 15)));
        userList.add(new Users(2, "Катя", "Иванова", "kate@mail.com", 'F', LocalDate.of(1995, 9, 22)));
        userList.add(new Users(3, "Дима", "Алексеев", "dimitry@mail.com", 'M', LocalDate.of(1988, 2, 7)));
        userList.add(new Users(4, "Лилия", "Шварц", "Schwarz@mail.com", 'F', LocalDate.of(1998, 12, 30)));
        userList.add(new Users(5, "Миша", "Ли", "machaellee@mail.com", 'M', LocalDate.of(1992, 4, 2)));


        //crud операции над юзерами
        createUser(new Users(6, "Аня", "Козлова", LocalDate.of(1999, 8, 10))); // создание пользователя
        findUserById(2); // поиск пользователя по id
        updateUser(new Users(2, "Катя", "Иванова", LocalDate.of(1995, 9, 22).plusYears(1))); // обновление информации о пользователе
        deleteUser(3); // удаление пользователя по id

        //вывод юзеров на экран
        for (int j = 0; j < userList.size(); j++)
            System.out.println("User : " + userList.get(j).toString());


        //задача вывода информации при добавлении в корзину
        Random random = new Random();
        for (int j = 0; j < 5; j++) {
            int userId = random.nextInt(5) + 1; // генерируем случайный id юзера от 1 до 5
            int categoryId = random.nextInt(5) + 1; // генерируем случайный id категории от 1 до 5
            int productId = productId = random.nextInt(4); // генерируем случайный id товара от 0 до 4


            System.out.println("User " + userList.get(userId-1).getId() + " " + userList.get(userId-1).getFirstName() + " " + userList.get(userId-1).getLastName()
                    + " положил из раздела каталога id = " + categoryId + ", '" + categories.get(categoryId-1).getName()
                    + "' товар id = " + categories.get(categoryId-1).getGoods().get(productId).getId() + " '" + categories.get(categoryId-1).getGoods().get(productId).getName() + "'");

        }


        //дополнительная задача на добавление юзеров в файл
        HashMap<Integer, Users> tabPasswordUsers = new HashMap<>();
        for (Users user : userList) {
            tabPasswordUsers.put(9020456 + user.getId(), user);
        }

        try (FileWriter fileWriter = new FileWriter("users.txt")) {
           for (Map.Entry<Integer,Users> element : tabPasswordUsers.entrySet()){
                System.out.println(element);
                fileWriter.write(element.toString()+"\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
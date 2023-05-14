package org.example.models;

import java.time.LocalDate;
import java.util.Random;

/**
 Класс - реализация сущности пользователей
 */
public class Users {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private char gender;
    private LocalDate birthDate;


    @Override
    public String toString() {
        return String.format("User[id=%d, firstName='%s', lastName='%s', email='%s', gender='%c', birthDate='%s']",
                id, firstName, lastName, email, gender, birthDate);
    }
    public Users() {
    }

    public Users(int id, String firstName, String lastName, String email, char gender, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}

/*public class Main {
    public static void main(String[] args) {

        User user1 = new User(1, "Митя", "Фомин", "fomin@mail.com", 'M', LocalDate.of(1990, 5, 15));
        User user2 = new User(2, "Катя", "Иванова", "kate@mail.com", 'F', LocalDate.of(1995, 9, 22));
        User user3 = new User(3, "Дима", "Алексеев", "dimitry@mail.com", 'M', LocalDate.of(1988, 2, 7));
        User user4 = new User(4, "Лилия", "Шварц", "Schwarz@mail.com", 'F', LocalDate.of(1998, 12, 30));
        User user5 = new User(5, "Миша", "Ли", "machaellee@mail.com", 'M', LocalDate.of(1992, 4, 2));

        System.out.println("User 1: " + user1.getFirstName() + " " + user1.getLastName() + ", email: " + user1.getEmail() + ", gender: " + user1.getGender() + ", birth date: " + user1.getBirthDate());
        System.out.println("User 2: " + user2.getFirstName() + " " + user2.getLastName() + ", email: " + user2.getEmail() + ", gender: " + user2.getGender() + ", birth date: " + user2.getBirthDate());
        System.out.println("User 3: " + user3.getFirstName() + " " + user3.getLastName() + ", email: " + user3.getEmail() + ", gender: " + user3.getGender() + ", birth date: " + user3.getBirthDate());
        System.out.println("User 4: " + user4.getFirstName() + " " + user4.getLastName() + ", email: " + user4.getEmail() + ", gender: " + user4.getGender() + ", birth date: " + user4.getBirthDate());
        System.out.println("User 5: " + user5.getFirstName() + " " + user5.getLastName() + ", email: " + user5.getEmail() + ", gender: " + user5.getGender() + ", birth date: " + user5.getBirthDate());

        // кодирование позиций из корзины и разделов каталога для демонстрации
        int[] cartItems = {3, 6, 8, 11, 14, 17, 20, 23, 26, 29};
        int[] catalogSections = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        for (int i = 0; i < cartItems.length; i++) {
            int userId = i + 1;
            int itemId = cartItems[i];
            int sectionId = catalogSections[i];

            System.out.println("User " + userId + " " + getUserFullName(userId) + " added item with id=" + itemId + " from catalog section with id=" + sectionId);
        }
    }

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
}

public class Main {
    public static void main(String[] args) {
        String[] users = {"Митя Фомин", "Катя Иванова", "Дима Алексеев", "Лилия Шварц", "Миша Ли"};
        String[] categories = {"Мужская одежда", "Женская одежда", "Детская одежда", "Обувь", "Аксессуары"};
        String[] products = {"Футболка мужская”; “Рубашка мужская”; Джинсы мужские", "Костюм мужской",
        "Куртка мужская зимняя", "Платье женское вечернее", "Платье женское коктейльное",
        "Платье женское офисное", "Блузка женская", "Юбка женская", "Платье для девочки",
        "Штанишки для мальчика", " Пальто детское демисезонное для девочки", "Футболка детская для мальчика",
        "Куртка детская утепленная для мальчика", "Туфли женские", "Кроссовки мужские",
        "Ботинки женские осенние", "Сапоги женские зимние", "Шапка женская",
        "Шарф женский", "Перчатки женские", "Бижутерия"};


        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int userId = random.nextInt(5) + 1; // генерируем случайный id юзера от 1 до 5
            int categoryId = random.nextInt(5) + 1; // генерируем случайный id категории от 1 до 5
            int productId = random.nextInt(25) + 1; // генерируем случайный id товара от 1 до 25

            System.out.println("User " + userId + " " + users[userId-1] + " положил в корзину товар с id=" + productId + ", '" + products[productId-1] + "' из раздела каталога id=" + categoryId + " '" + categories[categoryId-1] + "'");

        }
    }
}
*/
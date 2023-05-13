package org.example.models;

/**
 Класс - реализация сущности пользователей
 */
public class Users {
    public static void main(String[] args) {
        // создаем пользователей
        User user1 = new User("Митя");
        User user2 = new User("Катя");
        User user3 = new User("Дима");
        User user4 = new User("Лилия");
        User user5 = new User("Миша");
    }
}
class User {
    private String name;
    public User(String name) {
        this.name = name;
    }
}

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

    public Users(int id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }


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


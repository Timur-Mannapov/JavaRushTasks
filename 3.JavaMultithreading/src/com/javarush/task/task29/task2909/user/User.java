package com.javarush.task.task29.task2909.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private String surname;
    private int age;
    private boolean man;
    @Setter(AccessLevel.PRIVATE)
    private Address address;
    private Work work;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getCountry() {
        return address.getCountry();
    }

    public String getCity() {
        return address.getCity();
    }

    public String getHouse() {
        return address.getHouse();
    }

    public void setCountry(String country) {
        address.setCountry(country);
    }

    public void setCity(String city) {
        address.setCity(city);
    }

    public void setHouse(String house) {
        address.setHouse(house);
    }

    public String getAddress() {
        return getCountry() + " " + getCity() + " " + getHouse();
    }

    public void printInfo() {
        System.out.println("Имя: " + getName());
        System.out.println("Фамилия: " + getSurname());
    }

    public void printAdditionalInfo() {
        if (age < 16)
            System.out.println("Пользователь моложе 16 лет");
        else
            System.out.println("Пользователь старше 16 лет");
    }

    public String getBoss() {
        return work.getBoss();
    }
}
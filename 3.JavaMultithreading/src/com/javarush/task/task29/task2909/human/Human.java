package com.javarush.task.task29.task2909.human;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    private static int nextId = 0;
    @Getter
    private int id;
    @Setter
    @Getter
    protected int age;
    @Setter
    @Getter
    protected String name;
    @Setter
    @Getter
    private BloodGroup bloodGroup;



    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }
    private List<Human> children = new ArrayList<>();


    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human human) {
        children.add(human);
    }

    public void removeChild(Human human){
        children.remove(human);
    }
    public class Size{
         public int height;
         public int weight;
     }
    protected Size size;


    public String getPosition() {
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    @Override
    public void live() {
        
    }
}
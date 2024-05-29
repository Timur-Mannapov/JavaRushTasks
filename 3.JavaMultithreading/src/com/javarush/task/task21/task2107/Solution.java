package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone;
        try {
            clone = (Solution) solution.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(solution);
        System.out.println(clone);

        System.out.println(solution.users);
        System.out.println(clone.users);

    }
    public Object clone() throws CloneNotSupportedException {
        Solution clone = (Solution) super.clone();
        clone.users = new LinkedHashMap<>();
        for (Map.Entry<String, User> entry : users.entrySet()) {
            clone.users.put(entry.getKey(), entry.getValue().clone());
        }
        return clone;
    }

    protected Map<String, User> users = new LinkedHashMap<>();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public User clone() throws CloneNotSupportedException {
            User user = (User) super.clone();
            user.age = this.age;
            user.name = this.name;
            return user;
        }
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = new User(age, name);
            if (age == user.age) return true;
            return (Objects.equals(name,user.name));
        }

        public int hashCode() {
            return Objects.hash(age,name);
        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solution solution = (Solution) o;

        return users == solution.users || users != null && users.equals(solution.users);
    }

    @Override
    public int hashCode() {
        return users != null ? users.hashCode() : 0;
    }
}

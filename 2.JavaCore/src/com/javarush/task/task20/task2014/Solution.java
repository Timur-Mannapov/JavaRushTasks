package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution(4));
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\xargron\\IdeaProjects\\MyProject\\JavaRushTasks\\" +
                "2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\test");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileInputStream fis = new FileInputStream("C:\\Users\\xargron\\IdeaProjects\\MyProject\\JavaRushTasks\\" +
                     "2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\test");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Solution savedObject = new Solution(1);
            oos.writeObject(savedObject);
            Solution solution2 = new Solution(1);
            Solution loadedObject = (Solution) ois.readObject();
            System.out.println(savedObject.equals(loadedObject));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}

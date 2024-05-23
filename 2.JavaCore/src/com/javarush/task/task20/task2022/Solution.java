package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }




    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("C:\\Users\\xargron\\IdeaProjects\\MyProject\\JavaRushTasks\\" +
                "2.JavaCore\\src\\com\\javarush\\task\\task20\\task2022\\test");
                solution.writeObject("Запись");
                String file = "C:/1/save.bin";
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(solution);
                solution.close();
                out.close();

                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                Solution solution2 = (Solution) in.readObject();
                solution2.close();
                in.close();


    }
}

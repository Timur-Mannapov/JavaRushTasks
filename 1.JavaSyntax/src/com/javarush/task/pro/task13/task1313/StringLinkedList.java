package com.javarush.task.pro.task13.task1313;

public class StringLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        if (first.next == null) {
            Node element = new Node();
            element.value = value;
            first.next = element;
        }
        if (last.prev == null) {
            last.prev = first.next;
            return;
        }
        Node element = new Node();
        element.value = value;

        Node lastNode = last.prev;
        lastNode.next = element;
        element.prev = lastNode;
        last.prev = element;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}

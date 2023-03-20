package ru.bor;

public class MyLinkedList<T> {
    private Node head;
    private int size = 0;

    public MyLinkedList(){
        this.head = null;
    }
//Размер
    int size(){
        return size;
    }
//Простое добавление
    void add(T data) {
        Node<T> dataNode = new Node<>(data);

        if(this.head == null){
            head = dataNode;
        }else{
            Node<T> tempNode = head;
            while (tempNode.next != null){
                tempNode = tempNode.next;
            }
            tempNode.next = dataNode;
        }
        size++;

    }
//Вставка на позицию
    void add(int position, T data) {
        if(position > size + 1){
            System.out.println("Превышение размера MyLinkedList");
            throw new ArrayIndexOutOfBoundsException("Превышение размера!!!");
        }
        if (position == 1){
            Node<T> temp = head;
            head = new Node<>(data);
            head.next = temp;
        }

        Node<T> temp = head;

        Node<T> prev = new Node<T>(null);
        //Находим позицию
        while (position - 1 > 0) {
            prev = temp;
            temp = temp.next;
            position--;
        }
        prev.next = new Node<T>(data);
        prev.next.next = temp;

        size++;//???
    }
//Удаление
    void remove(T key){
        Node<T> prev = new Node<>(null);
        prev.next = head;
        Node<T> next = head.next;
        Node<T> temp = head;

        boolean exists = false;

        if (head.data == key) {
            head = head.next;
            exists = true;
        }
        while (temp.next != null) {
            if (String.valueOf(temp.data).equals(
                    String.valueOf(key))) {
                prev.next = next;
                exists = true;
                break;
            }
            prev = temp;
            temp = temp.next;
            next = temp.next;
        }
        if (exists == false
                && String.valueOf(temp.data).equals(
                String.valueOf(key))) {
            prev.next = null;
            exists = true;
        }

        if (exists) {
            size--;
        }

        else {
            System.out.println(
                    "Значение в списке не найдено!");
        }

    }

    void clear()
    {
        head = null;
        size = 0;
    }

    boolean isEmpty()
    {
        if (head == null) {
            return true;
        }
        return false;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E element) {
            this.data = element;
            this.next = null;

        }
    }
    @Override
    public String toString()
    {

        String S = "{ ";

        Node<T> X = head;

        if (X == null)
            return S + " }";

        while (X.next != null) {
            S += String.valueOf(X.data) + " | ";
            X = X.next;
        }

        S += String.valueOf(X.data);
        return S + " }";
    }

}

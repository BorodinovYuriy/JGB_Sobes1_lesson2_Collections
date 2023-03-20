package ru.bor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> testAL = new ArrayList <>();
        List<String> testLL = new LinkedList<>();


        MyArrayList<String> myTest = new MyArrayList<>();
        myTest.add("test");
        myTest.add(String.valueOf(123));
        System.out.println(myTest.get(0));
        System.out.println(myTest.get(1));

        testLL.add("hello world");

        MyLinkedList<String> myTestStringLinkedList = new MyLinkedList<>();
        myTestStringLinkedList.add("test1");
        myTestStringLinkedList.add("test2");
        myTestStringLinkedList.add("test3");
        myTestStringLinkedList.add("test4");
        myTestStringLinkedList.remove("test3");
        System.out.println(myTestStringLinkedList.toString());
        }
}

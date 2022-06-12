package com.company;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.remove(5);
        System.out.println(list.toString());
        list.reverse();
        System.out.println(list.toString());

    }
}
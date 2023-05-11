package kz.CandyStore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CandyList candList = new CandyList();
        candList.addToList();

        String login = new String(),password = new String();
        Person person = new Person(login,password);
        Candy candy1 = new Candy("snickers","mars",150);

        person.func();
    }
}
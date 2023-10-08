package com.barokah.java.belajar.p22.java.io;


import java.util.Scanner;

public class ScannerApp {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in);) {
            System.out.print("Please type your name : ");
            String name = scanner.nextLine();
            System.out.println("Hello " + name);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

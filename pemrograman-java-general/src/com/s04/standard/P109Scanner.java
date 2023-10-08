package com.s04.standard;

// Scanner is to read from input. the input can be any file, console, etc

import java.util.Scanner;

public class P109Scanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // set input to console

        System.out.print("Enter your name : ");
        String name = scanner.nextLine();
        System.out.println(name);

    }
}

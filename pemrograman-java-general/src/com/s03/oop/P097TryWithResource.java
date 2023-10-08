package com.s03.oop;

import java.io.BufferedReader;
import java.io.FileReader;

// AutoCloseable
public class P097TryWithResource {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("readme.md"))) {

            while (true){
                String line = reader.readLine();
                if (line == null){
                    break;
                }

                System.out.println(line);
            }

        }catch (Throwable throwable){
            System.out.println(throwable.getMessage());
        }
    }
}

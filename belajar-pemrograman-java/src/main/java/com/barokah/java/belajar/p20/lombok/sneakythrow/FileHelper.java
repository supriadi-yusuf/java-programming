package com.barokah.java.belajar.p20.lombok.sneakythrow;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.util.Scanner;

public class FileHelper {
    @SneakyThrows
    public static String loadFile(String file) {
        @Cleanup FileReader fileReader = new FileReader("pom.xml");
        @Cleanup Scanner scanner = new Scanner(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
            stringBuilder.append("\n");
        }


        return stringBuilder.toString();
    }
}

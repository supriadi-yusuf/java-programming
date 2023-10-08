package com.barokah.java.belajar.p20.lombok.log;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.util.Scanner;

@Slf4j
public class FileHelper {
    @SneakyThrows
    public static String loadFile(String file) {

        log.info("open file pom.xml");

        @Cleanup FileReader fileReader = new FileReader("pom.xml");
        @Cleanup Scanner scanner = new Scanner(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {

            log.info("read file content");

            stringBuilder.append(scanner.nextLine());
            stringBuilder.append("\n");
        }

log.info("close file pom.xml");

        return stringBuilder.toString();
    }
}

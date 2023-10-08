package com.barokah.java.belajar.p24.java.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

// https://commons.apache.org/proper/commons-csv/
// https://commons.apache.org/proper/commons-csv/apidocs/index.html

public class P01CreateCsvTest {
    @Test
    void testCreateCsvToString() {
        StringWriter writer = new StringWriter();

        try (CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);) {
            printer.printRecord("Supriadi", "Yusuf", 30);
            printer.printRecord("Muhammad", "Yunus", 60);

            printer.printRecord("David", "Lalala", 22);

            String content = writer.getBuffer().toString();
            System.out.println(content);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void testCrateCsvToFile() {
        Path path = Path.of("my-data.csv");
        try (BufferedWriter writer = Files.newBufferedWriter(path);
             CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT)
        ) {
            printer.printRecord("Supriadi", "Yusuf", 30);
            printer.printRecord("Muhammad", "Yunus", 60);
            printer.printRecord("David", "Lalala", 22);

            printer.flush();
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}

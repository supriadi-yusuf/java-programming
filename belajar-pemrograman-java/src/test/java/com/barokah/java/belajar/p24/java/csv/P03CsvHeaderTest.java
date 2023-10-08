package com.barokah.java.belajar.p24.java.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvFormat;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P03CsvHeaderTest {
    @Test
    void testCreateCsvWithHeader() {
        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader("First Name", "Last Name", "Age") // specify header to create
                .build();

        Path path = Path.of("my-data-with-header.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(path);
             CSVPrinter printer = new CSVPrinter(writer, format)){
            printer.printRecord("Supriadi","Yusuf",30);
            printer.printRecord("Muhammad","Yunus",65);
            printer.printRecord("David","Lalala",22);

            printer.flush();
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testReadCsvWithHeader(){
        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader() // indicate that csv has header
                .build();

        Path path = Path.of("my-data-with-header.csv");

        try (BufferedReader reader = Files.newBufferedReader(path);
             CSVParser csvRecords = CSVParser.parse(reader,format)){

            for (var record : csvRecords){
                String firstName = record.get("First Name"); // we can use header name to retrieve data
                String lastName = record.get("Last Name");
                String age = record.get("Age");

                System.out.println("First Name : " + firstName);
                System.out.println("Last Name : " + lastName);
                System.out.println("Age : " + age);
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}

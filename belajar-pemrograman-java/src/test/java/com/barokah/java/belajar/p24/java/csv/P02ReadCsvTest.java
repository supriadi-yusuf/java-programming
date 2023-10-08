package com.barokah.java.belajar.p24.java.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P02ReadCsvTest {
    @Test
    void testReadCsv(){
        Path path = Path.of("my-data.csv");
        try (BufferedReader reader = Files.newBufferedReader(path);
             CSVParser csvRecords = CSVParser.parse(reader, CSVFormat.DEFAULT)){
            for (var record:csvRecords){
                String firstName = record.get(0); // use colum index (start from 0) to get data
                String lastName = record.get(1);
                String age = record.get(2);

                System.out.println("First name : " + firstName);
                System.out.println("Last name : " + lastName);
                System.out.println("Age : " + age);
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}

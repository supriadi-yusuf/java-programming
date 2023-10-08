package com.barokah.java.belajar.p24.java.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

public class P04CsvFormatTest {
    @Test
    void testCsvWithTab(){

        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.TDF; // Tab Delimiter Format
        try (CSVPrinter printer = new CSVPrinter(writer, format);){
            printer.printRecord("Supriadi","Yusuf",30);
            printer.printRecord("Ali","Imran",25);
            printer.printRecord("Muhammad","Yusuf",45);

            printer.flush();

            String data = writer.getBuffer().toString();
            System.out.println(data);
        } catch (IOException e) {
            Assertions.fail(e);
        }


    }
}

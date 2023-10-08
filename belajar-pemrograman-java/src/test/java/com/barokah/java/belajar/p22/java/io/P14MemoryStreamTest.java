package com.barokah.java.belajar.p22.java.io;

// IO whore resource target is in memory not in file
// ByteArrayInputStream is child of InputStream
// ByteArrayOutputStream is child of OutputStream
// StringReader is child of Reader
// StringWriter is child of Writer

import org.junit.jupiter.api.Test;

import java.io.StringWriter;

public class P14MemoryStreamTest {
    @Test
    void testStringWriter(){
        StringWriter writer = new StringWriter();

        writer.write("Hello World\n");
        writer.write("Hello World\n");
        writer.write("Hello World\n");

        String data = writer.getBuffer().toString();
        System.out.println(data);
    }
}

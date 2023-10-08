package com.barokah.java.belajar.p20.lombok;

import com.barokah.java.belajar.p20.lombok.cleanup.FileHelper;
import org.junit.jupiter.api.Test;

//@Cleanup is to make  a resource automatically closed. So we do not need to close resource manually.
public class P10CleanUpTest {
    @Test
    void testCleanUp() throws Exception {
        System.out.println(FileHelper.loadFile("pom.xml"));
    }


}

package com.barokah.software;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RegisterDriverTest {

    @Test
    void testRegister(){
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);

            System.out.println("Drive registration succeed");
        } catch (SQLException e) {
            Assertions.fail(e);
        }

    }
}

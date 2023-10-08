package com.barokah.software;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_database");
        config.setUsername("root");
        config.setPassword("root");

        // pool connection
        config.setMaximumPoolSize(10); // maximum connection in pool
        config.setMinimumIdle(5); // minimum connection in idle ( no connection / no transaction in DB )
        config.setIdleTimeout(60_000); // max idle to close connection
        config.setMaxLifetime(10 * 60_000); // max time to re-create connection

        dataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getDataSource(){
        return dataSource;
    }

    private static void registerDriver() throws SQLException {
        Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(mysqlDriver);
    }

    public static Connection getConnection() throws SQLException {
        registerDriver();

        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        return connection;
    }

}

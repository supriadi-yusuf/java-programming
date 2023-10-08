package com.barokah.software;


import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.Arrays;

public class App {

    private static void insertData() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql1 = """
                INSERT INTO customers(  id, name, email) VALUES
                (3, 'rahma', 'rahma@gmail.com');
                """;

        // executeUpdate (if we do not need response data from DBMS)
        // executeQuery (if we need response data from DBMS)
        int result = statement.executeUpdate(sql1); // return number of rows affected by execution
        System.out.println(result);

        statement.close();
        connection.close();
        dataSource.close();
    }

    private static void getData() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                SELECT * FROM customers;
                """;

        // executeQuery (if we need response data from DBMS)
        //int result = statement.executeUpdate(sql); // executeUpdate (if we do not need response data from DBMS).
        // it returns number of rows affected by execution

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String data = String.join(", ", String.valueOf(resultSet.getInt("id")),
                    resultSet.getString("name"), resultSet.getString("email"));
            System.out.println(data);
        }

        resultSet.close();
        statement.close();
        connection.close();
        dataSource.close();
    }

    private static void updateData() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql1 = """
                UPDATE customers SET name='rahman'
                WHERE id=3;
                """;

        // executeUpdate (if we do not need response data from DBMS)
        // executeQuery (if we need response data from DBMS)
        int result = statement.executeUpdate(sql1); // return number of rows affected by execution
        System.out.println(result);

        statement.close();
        connection.close();
        dataSource.close();
    }

    private static void deleteData() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql1 = """
                DELETE FROM customers WHERE id=3;
                """;

        // executeUpdate (if we do not need response data from DBMS)
        // executeQuery (if we need response data from DBMS)
        int result = statement.executeUpdate(sql1); // return number of rows affected by execution
        System.out.println(result);

        statement.close();
        connection.close();
        dataSource.close();
    }

    private static void login() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();

        String username = "admin";
        String password = "password";

        String sql = """
                SELECT * FROM users WHERE 
                username=? AND password=?;
                """;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);

        // executeQuery (if we need response data from DBMS)
        //int result = statement.executeUpdate(sql); // executeUpdate (if we do not need response data from DBMS).
        // it returns number of rows affected by execution

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            System.out.println("sukses login");
        } else {
            System.out.println("gagal login");
        }

        resultSet.close();
        statement.close();
        connection.close();
        dataSource.close();
    }

    private static void insertBatchDataStatement() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String[] sqls = {
                """
                INSERT INTO comments( email, comment) VALUES
                ('rahma@gmail.com','hi');
                """,
                """
                INSERT INTO comments( email, comment) VALUES
                ('anto@gmail.com','hello');
                """,
                """
                INSERT INTO comments( email, comment) VALUES
                ('indra@gmail.com','hore');
                """
        };

        for (String sql : sqls) {
            statement.addBatch(sql);
        }

        int[] results = statement.executeBatch();

        System.out.println(Arrays.toString(results));

        statement.close();
        connection.close();
        dataSource.close();
    }

    private static void insertBatchDataPreparedStatement() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();

        String sql = "INSERT INTO comments( email, comment) VALUES( ?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);

        String[][] sqls = {
                {"ananda@yahoo.com", "suka"},
                {"nano@yahoo.com", "ok"},
                {"yoyo@gmail.com", "oh"}
        };

        for (String[] sqlData : sqls) {
            statement.clearParameters();
            statement.setString(1, sqlData[0]);
            statement.setString(2, sqlData[1]);
            statement.addBatch();
        }

        int[] results = statement.executeBatch();

        System.out.println(Arrays.toString(results));

        statement.close();
        connection.close();
        dataSource.close();
    }

    private static void getAutoIncrement() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                INSERT INTO comments(  email, comment) VALUES
                ( 'rahma@gmail.com', 'halo');
                """;

        int result = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        System.out.println(result);

        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int id = generatedKeys.getInt(1);
            System.out.println("id : " + id);
        }

        statement.close();
        connection.close();
        dataSource.close();
    }

    private static void getAutoIncrementWithPreparedStatement() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();

        String email = "test123@gmail.com";
        String comment = "halo";
        String sql = """
                INSERT INTO comments(  email, comment) VALUES (?,?);
                """;

        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, email);
        statement.setString(2, comment);

        int result = statement.executeUpdate();
        System.out.println(result);

        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int id = generatedKeys.getInt(1);
            System.out.println("id : " + id);
        }

        statement.close();
        connection.close();
        dataSource.close();
    }

    private static void insertDate() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();

        String sql = """
                INSERT INTO sample_time(  sample_date, sample_time, sample_timestamp) VALUES (?,?,?);
                """;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, new Date(System.currentTimeMillis()));
        statement.setTime(2, new Time(System.currentTimeMillis()));
        statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

        int result = statement.executeUpdate();
        System.out.println(result);

        statement.close();
        connection.close();
        dataSource.close();
    }

    private static void queryDate() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                SELECT * FROM sample_time;
                """;

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Date sampleDate = resultSet.getDate("sample_date");
            Time sampleTime = resultSet.getTime("sample_time");
            Timestamp sampleTimestamp = resultSet.getTimestamp("sample_timestamp");

            System.out.println(String.join(", ", sampleDate.toString(), sampleTime.toString(),
                    sampleTimestamp.toString()));
        }

        statement.close();
        connection.close();
        dataSource.close();
    }

    private static void transactionCommit() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();

        // auto commit is active by default. we have to deactivate it.
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();

        String sql = """
                INSERT INTO comments(  email, comment) VALUES
                ('test_transaction_commit@gmail.com','test_transaction_commit');
                """;

        statement.executeUpdate(sql);

        connection.commit(); // save to db

        statement.close();
        connection.close();
        dataSource.close();
    }

    private static void transactionRollback() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();

        // auto commit is active by default. we have to deactivate it.
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();

        String sql = """
                INSERT INTO comments(  email, comment) VALUES
                ('test_transaction_rollback@gmail.com','test_transaction_rollback');
                """;

        statement.executeUpdate(sql);

        connection.rollback(); // cancel

        statement.close();
        connection.close();
        dataSource.close();
    }

    private static void databaseMetadata() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();

        DatabaseMetaData databaseMetaData = connection.getMetaData();

        System.out.println(databaseMetaData.getDatabaseProductName());
        System.out.println(databaseMetaData.getDatabaseProductVersion());

        ResultSet resultSet = databaseMetaData.getTables("belajar_java_database", null, null, null);
        while (resultSet.next()) {
            String tableName = resultSet.getString("TABLE_NAME");
            System.out.println(tableName);
        }

        resultSet.close();
        connection.close();
        dataSource.close();
    }

    private static void parameterMetadata() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();

        String sql = "INSERT INTO comments(  email, comment) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        ParameterMetaData parameterMetaData = statement.getParameterMetaData();

        int parameterCount = parameterMetaData.getParameterCount();
        System.out.println(parameterCount);

        statement.close();
        connection.close();
        dataSource.close();
    }

    private static void resultSetMetadata() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM comments";

        ResultSet resultSet = statement.executeQuery(sql);

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        for (int i=1;i<=resultSetMetaData.getColumnCount();i++){
            System.out.println("Name : " + resultSetMetaData.getColumnName(i));
            System.out.println("Type : " + resultSetMetaData.getColumnType(i));
            System.out.println("Type Name : " + resultSetMetaData.getColumnTypeName(i));

            if (Types.INTEGER==resultSetMetaData.getColumnType(i)){
                System.out.println("INTEGER type");
            }
        }

        statement.close();
        connection.close();
        dataSource.close();
    }

    public static void main(String[] args) {

        try {
//            insertData();
//            getData();
//            updateData();
//            deleteData();
//            login();
//            insertBatchDataStatement();
//            insertBatchDataPreparedStatement();
//            getAutoIncrement();
//            getAutoIncrementWithPreparedStatement();
//            insertDate();
//            queryDate();
//            transactionCommit();
//            transactionRollback();
//            databaseMetadata();
//            parameterMetadata();
            resultSetMetadata();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

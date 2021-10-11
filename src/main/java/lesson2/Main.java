package lesson2;

import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psInsert;

    public static void main(String[] args) {
        try {
            connect();
            prepareStatements();
            clearTable();
            rollBackEx();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void rollBackEx() throws SQLException {
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob1', 80);");
        Savepoint sp1 = connection.setSavepoint();
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob2', 80);");
        connection.rollback(sp1);
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 80);");
        connection.commit();
    }

    public static void fillBatchTable() throws SQLException {
        long begin = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 1; i <= 1000; i++) {
            psInsert.setString(1, "Bob" + i);
            psInsert.setInt(2, 15 * i % 100);
            psInsert.addBatch();
        }
        psInsert.executeBatch();
        connection.commit();
        long end = System.currentTimeMillis();
        System.out.printf("Time: %d ms", end - begin);
    }


    public static void fillTable() throws SQLException {
        long begin = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 1; i <= 1000; i++) {
            psInsert.setString(1, "Bob" + i);
            psInsert.setInt(2, 15 * i % 100);
            psInsert.executeUpdate();
        }
        connection.commit();
        long end = System.currentTimeMillis();
        System.out.printf("Time: %d ms", end - begin);
    }

    private static void prepareStatements() throws SQLException {
        psInsert = connection.prepareStatement("INSERT INTO students (name, score) VALUES ( ? , ?);");
    }

    //CRUD create read update delete
    private static void selectEx() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT name, score FROM students WHERE score < 50;");
        while (rs.next()) {
            System.out.println(rs.getString("name") + " " + rs.getInt("score"));
        }
        rs.close();
    }

    private static void clearTable() throws SQLException {
        stmt.executeUpdate("DELETE FROM students;");
    }

    private static void deleteEx() throws SQLException {
        stmt.executeUpdate("DELETE FROM students WHERE score == 90;");
    }

    private static void updateEx() throws SQLException {
        stmt.executeUpdate("UPDATE students SET score = 90 WHERE score == 100;");
    }

    private static void insertEx() throws SQLException {
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 80);");
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

package ru.job4j.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqliteSandBox {
    public static void main(String[] args) {
        Connection connection;
        PreparedStatement st;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:sqlite:c:\\sqlite\\entries.db", "user", "password");
            st = connection.prepareStatement("INSERT into entry (field) VALUES (?)");
            st.setInt(1, (10));
            st.execute();
            System.out.println(String.format("Field %d has been inserted in DB", 10));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

package ru.job4j.tracker;

import java.sql.*;

public class TrackerSQLDebugUtil {
    Connection connection;

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/items";
        String username = "postgres";
        String password = "password";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT item_name FROM items where id=1 ");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

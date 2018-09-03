package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {

    @Test
    public void dbFiller() {
        TrackerSQL tracker = new TrackerSQL(new ConfigReader());
        Item item;
        int totalItems = 3;
        for (int i = 0; i < totalItems; i++) {
            item = new Item();
            item.setName(String.format("Test item %d", i));
            item.setDesc("Test Item");
            tracker.add(item);
        }
    }

    @Test
    public void whenAddItemWithCommentsThenAdded() {
        TrackerSQL tracker = new TrackerSQL(new ConfigReader());
        Item item;
        item = new Item();
        item.setName("Test item with comments");
        item.setDesc("This item has three comments");
        ArrayList<String> comments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            comments.add(String.format("This is comment %d", i));
        }
        item.setComments(comments);
        tracker.add(item);
    }

    @Test
    public void whenSendQuertThenGetConnection() {
        String url = "jdbc:postgresql://localhost:5432/items";
        String username = "postgres";
        String password = "password";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT item_name FROM items where id=1 ");
            while (rs.next()) {
                assertThat(rs.getString(1), is("FirstItem"));
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

    @Test
    public void whenAddElementThenAdded() {
        TrackerSQL tracker = new TrackerSQL(new ConfigReader());
        String url = "jdbc:postgresql://localhost:5432/items";
        String username = "postgres";
        String password = "password";
        int currentItemId = -1;
        Item item = new Item();
        item.setName("TestAddItem");
        item.setDesc("This Item added automatically during the test");
        tracker.add(item);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(id) FROM items ");
            currentItemId = Integer.parseInt(String.valueOf(rs.next()));
            System.out.println(String.format("Current item is %d", currentItemId));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT item_name FROM items where id=1 ");
            while (rs.next()) {
                assertThat(rs.getString(1), is("FirstItem"));
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
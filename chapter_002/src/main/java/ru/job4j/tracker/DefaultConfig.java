package ru.job4j.tracker;

import java.util.HashMap;

public class DefaultConfig {
    private static DefaultConfig defaultConfig = new DefaultConfig();
    HashMap<String, String> config = new HashMap<>();
    String commentsDB = new StringBuilder()
            .append("create table comments_table(")
            .append("id serial primary key,")
            .append("comment_field varchar(1000),")
            .append("item_id int references item_table(id));")
            .toString();
    String mainDB = "create database items;";
    String mainTable = new StringBuilder()
            .append("create table item_table (")
            .append("id serial primary key,")
            .append("item_name varchar(100),")
            .append("description varchar(500),")
            .append("date_field timestamp);") //find out how to do it correct
            .toString();

    public static DefaultConfig getInstance() {
        return defaultConfig;
    }

    public HashMap<String, String> getConfig() {
        return this.config;
    }
}

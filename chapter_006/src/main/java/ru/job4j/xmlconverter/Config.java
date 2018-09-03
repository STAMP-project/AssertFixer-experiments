package ru.job4j.xmlconverter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Config class
 */
public class Config {

    private String path;
    private String url;
    private String urlToCreateNewDb;

    private String user;
    private String password;
    private String dBCreateScript;

    private  String createTableScript;

    public Config(String path) {
        this.path = path;
        loadProperties();
    }

    public String getUrlToCreateNewDb() {
        return urlToCreateNewDb;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getdBCreateScript() {
        return dBCreateScript;
    }

    public String getCreateTableScript() {
        return createTableScript;
    }


    public void loadProperties() {
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
            fileInputStream = new FileInputStream(path);
            prop.load(fileInputStream);
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            urlToCreateNewDb = prop.getProperty("urlToCreateNewDb");
            dBCreateScript = prop.getProperty("DBCreateScript");
            createTableScript = prop.getProperty("createTableScript");
            System.out.println("Config data loaded.");
        } catch (IOException e) {
            System.out.println("Config loading error.");
            e.printStackTrace();
        }
    }
}


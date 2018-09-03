package ru.job4j.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ConfigReader {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigReader.class);
    private static final String CONFIG_FILE = "config.txt";
    private String urlDb;
    private final TreeMap<String, String> config = new TreeMap<>();
    private String url;
    private String user;
    private String password;

    public ConfigReader() {
        if (isConfigExist()) {
            readConfig();
        } else {
            createDefaultConfig();
            readConfig();
        }
        url = config.get("url");
        user = config.get("user");
        password = config.get("password");
        urlDb = config.get("urlDb");
    }

    public TreeMap<String, String> getConfig() {
        return config;
    }


    private boolean isConfigExist() {
        if (Files.exists(Paths.get(CONFIG_FILE))) {
            try {
                new File(CONFIG_FILE).createNewFile();
                return true;
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return false;
    }

    private static void createDefaultConfig() {
        BufferedWriter writer = null;
        HashMap<String, String> script = new HashMap<>(DefaultConfig.getInstance().config);

        try {
            new File(CONFIG_FILE).createNewFile();
            writer = Files.newBufferedWriter(Paths.get(CONFIG_FILE), StandardCharsets.UTF_8);
            for (Map.Entry<String, String> entry : script.entrySet()) {
                writer.write(entry.getKey() + System.lineSeparator());
                writer.write(entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        try {
            writer.close();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public void readConfig() {
        String key;
        String value;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(CONFIG_FILE));
            key = reader.readLine();
            value = reader.readLine();
            while (key != null && value != null) {
                config.put(key, value);
                key = reader.readLine();
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage(), e);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }


    public String getUrl() {
        return this.url;
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUrlDb() {
        return this.urlDb;
    }
}

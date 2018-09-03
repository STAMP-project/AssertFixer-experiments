package ru.job4j.tracker;

import org.junit.Test;

public class ConfigReaderTest {
    @Test
    public void whenUseConfigReaderThenJustDebugIt() {
    ConfigReader configReader = new ConfigReader();
        System.out.println(configReader.getUrl());
        System.out.println(configReader.getUser());
        System.out.println(configReader.getPassword());
    }
}
package com.bonjourcs.java.common.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @author Liang Chenghao
 * Description: property util class
 * Date: 2018/4/17
 */
public class PropertyUtils {

    /**
     * property file name
     */
    private static String PROPERTY_NAME = "common.properties";
    /**
     * properties configuration file
     */
    private static PropertiesConfiguration properties = null;

    // initialize PropertiesConfiguration
    static {
        try {
            properties = new PropertiesConfiguration(PROPERTY_NAME);
        } catch (ConfigurationException e) {
            throw new RuntimeException("load configuration file: " + PROPERTY_NAME + " failed.");
        }
    }

    /**
     * get string property
     *
     * @param key property key
     * @return property value
     */
    public static String getProperty(String key) {
        return properties.getString(key);
    }

}

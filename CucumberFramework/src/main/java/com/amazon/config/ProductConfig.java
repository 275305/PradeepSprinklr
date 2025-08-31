package com.amazon.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProductConfig {
	
	private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config/ProductConfig.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load ProductConfig.properties file!");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}



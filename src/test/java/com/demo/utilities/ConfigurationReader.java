package com.demo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.text.MessageFormat;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();
    static {
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key){
        if(properties.getProperty(key) == null) {
            throw new InvalidParameterException(MessageFormat.format("Missing value for key {0}! OR key does not exist", key));
        }
        //properties object have getProperty method
        return properties.getProperty(key);
    }
}
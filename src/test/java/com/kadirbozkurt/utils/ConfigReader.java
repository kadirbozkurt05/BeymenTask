package com.kadirbozkurt.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static FileInputStream file;
    private static Properties properties;
    private static Properties tokenProperties;

    static {

        try {

            file = new FileInputStream("config.properties");
            properties = new Properties();
            properties.load(file);
            file.close();
            tokenProperties = new Properties();
            file = new FileInputStream("token.properties");
            tokenProperties.load(file);
            file.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getToken(){
        return tokenProperties.getProperty("token");
    }
    public static String getKey(){
      return   tokenProperties.getProperty("key");
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}

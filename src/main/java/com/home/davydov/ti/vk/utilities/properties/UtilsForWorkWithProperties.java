package com.home.davydov.ti.vk.utilities.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilsForWorkWithProperties {
    private static final String DEFAULT_PATH_TO_PROPERTIES = "production";
    private static final String ENVIRONMENT = System.getProperty("vk.env",
            DEFAULT_PATH_TO_PROPERTIES);

    public static final String PATH_TO_PROPERTIES = String.format(
            "src/test/resources/environments/%s.properties", ENVIRONMENT);
    private static final String INCORRECT_PATH_TO_PROPERTIES =
            "[AUT-ERROR] The next file %s - not found.";

    private static final Properties PROPERTIES = initProperties();

    private static Properties initProperties() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(String.format(
                    INCORRECT_PATH_TO_PROPERTIES, PATH_TO_PROPERTIES, e.getMessage()), e);
        }
        return properties;
    }

    public static String getPropertyValue(String key) {
        return PROPERTIES.getProperty(key);
    }
}


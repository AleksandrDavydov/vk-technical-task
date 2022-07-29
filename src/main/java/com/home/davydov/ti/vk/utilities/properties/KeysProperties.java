package com.home.davydov.ti.vk.utilities.properties;

/**
 * Enumeration with properties keys
 */
public enum KeysProperties {
    USER_ID("userId"),
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    BASE_API_URL("baseApiUrl");

    private String value;

    KeysProperties(String values) {
        this.value = values;
    }

    public String getValue() {
        return value;
    }
}

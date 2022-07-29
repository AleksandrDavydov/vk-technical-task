package com.home.davydov.ti.vk.model;

import static com.home.davydov.ti.vk.utilities.properties.KeysProperties.FIRST_NAME;
import static com.home.davydov.ti.vk.utilities.properties.KeysProperties.LAST_NAME;
import static com.home.davydov.ti.vk.utilities.properties.UtilsForWorkWithProperties.getPropertyValue;

public class User {
    private String login;
    private String password;
    private final String firstName = getPropertyValue(FIRST_NAME.getValue());
    private final String lastName = getPropertyValue(LAST_NAME.getValue());

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullUserName() {
        return String.format("%s  %s", firstName, lastName);
    }
}

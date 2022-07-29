package com.home.davydov.ti.vk.utilities.localstoreg;

public enum LocalStorageKeys {
    ACCESS_TOKEN("web_token:login");

    private String value;

    LocalStorageKeys(String values) {
        this.value = values;
    }

    public String getValue() {
        return value;
    }
}

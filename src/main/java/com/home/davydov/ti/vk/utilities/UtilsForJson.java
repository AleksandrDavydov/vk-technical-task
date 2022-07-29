package com.home.davydov.ti.vk.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class UtilsForJson {
    private final ObjectMapper MAPPER = new ObjectMapper();

    private static final String READ_DATA_ERROR = "[AUT-ERROR] Error reading the next string: %s. See details: %s";

    public <T> T convertStringToObject(String string, Class<T> productTypeClass) {
        try {
            return MAPPER.readValue(string, productTypeClass);
        } catch (IOException e) {
            throw new RuntimeException(String.format(READ_DATA_ERROR, string, e.getMessage()), e);
        }
    }
}

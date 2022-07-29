package com.home.davydov.ti.vk.utilities.localstoreg;

import com.home.davydov.ti.vk.model.dto.localstoreg.web_token.WebTokenDTO;
import com.home.davydov.ti.vk.utilities.UtilsForJson;

import java.util.Map;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.home.davydov.ti.vk.utilities.localstoreg.LocalStorageKeys.ACCESS_TOKEN;

public class UtilsForLocalStorage {
    private static UtilsForJson parser = new UtilsForJson();

    public static String getAccessToken() {
        Map<String, String> localStorageItems = localStorage().getItems();
        final String[] value = {null};
        localStorageItems.forEach((k, v) -> {
            if (k.contains(ACCESS_TOKEN.getValue())) {
                value[0] = v;
            }
        });
        WebTokenDTO result = parser.convertStringToObject(value[0], WebTokenDTO.class);
        return result.access_token;
    }
}

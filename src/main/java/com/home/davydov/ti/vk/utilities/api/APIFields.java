package com.home.davydov.ti.vk.utilities.api;


public enum APIFields {
    VERSION("v", "5.131"),
    ACCESS_TOKEN("access_token"),
    PEER_ID("peer_id"),
    TITLE("title"),
    ALBUM_ID("album_id"),
    SERVER("server"),
    PHOTO_LIST("photos_list"),
    HASH("hash"),
    PHOTO("photo"),
    VIDEO("video"),
    NAME("name"),
    VIDEO_ID("video_id");

    private String key;
    private String value;

    APIFields(String key, String value) {
        this.key = key;
        this.value = value;
    }

    APIFields(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

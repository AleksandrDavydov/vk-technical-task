package com.home.davydov.ti.vk.utilities.api;


import com.home.davydov.ti.vk.utilities.properties.KeysProperties;
import com.home.davydov.ti.vk.utilities.properties.UtilsForWorkWithProperties;


public class RestApiHelper {
    private static final String BASE_URL = UtilsForWorkWithProperties.getPropertyValue(KeysProperties.BASE_API_URL.getValue());

    private static final String GET_MESSAGES = "/messages.getConversations";
    private static final String DELETE_MESSAGES = "/messages.deleteConversation";
    private static final String CREATE_CHAT = "/messages.createChat";
    private static final String CREATE_ALBUM = "/photos.createAlbum";
    private static final String UPLOAD_SERVER = "/photos.getUploadServer";
    private static final String SAVE_PHOTOS = "/photos.save";
    private static final String DELETE_ALBUM = "/photos.deleteAlbum";
    private static final String VIDEO_SAVE = "/video.save";
    private static final String VIDEO_DELETE = "/video.delete";


    public static String getMessengerGetUrl() {
        return BASE_URL + GET_MESSAGES;
    }

    public static String getDeleteMessengerUrl() {
        return BASE_URL + DELETE_MESSAGES;
    }

    public static String getCreateChatUrl() {
        return BASE_URL + CREATE_CHAT;
    }

    public static String getCreateAlbumUrl() {
        return BASE_URL + CREATE_ALBUM;
    }

    public static String getUploadServerUrl() {
        return BASE_URL + UPLOAD_SERVER;
    }

    public static String getPhotoSaveUrl() {
        return BASE_URL + SAVE_PHOTOS;
    }

    public static String getDeleteAlbumUrl() {
        return BASE_URL + DELETE_ALBUM;
    }

    public static String getVideoSaveUrl() {
        return BASE_URL + VIDEO_SAVE;
    }

    public static String getVideoDeleteUrl() {
        return BASE_URL + VIDEO_DELETE;
    }

}

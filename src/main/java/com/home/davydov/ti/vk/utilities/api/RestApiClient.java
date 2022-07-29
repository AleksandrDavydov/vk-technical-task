package com.home.davydov.ti.vk.utilities.api;

import kong.unirest.Unirest;

import java.io.File;
import java.util.Collections;

import static com.home.davydov.ti.vk.utilities.Constants.BASE_PATH_TO_ATTACHMENT;
import static com.home.davydov.ti.vk.utilities.api.APIFields.*;

public class RestApiClient {

    public static <T> T postForGetMessages(String url, String accessToken, Class<T> classToParse) {
        return Unirest.post(url)
                .field(ACCESS_TOKEN.getKey(), accessToken)
                .field(VERSION.getKey(), VERSION.getValue())
                .asObject(classToParse)
                .getBody();
    }

    public static void postForDeleteChat(String url, String accessToken, int peerID) {
        Unirest.post(url)
                .field(PEER_ID.getKey(), peerID)
                .field(ACCESS_TOKEN.getKey(), accessToken)
                .field(VERSION.getKey(), VERSION.getValue())
                .asEmpty();
    }


    public static <T> T postForCreateChat(String url, String accessToken, String title, Class<T> classToParse) {
        return Unirest.post(url)
                .field(TITLE.getKey(), title)
                .field(ACCESS_TOKEN.getKey(), accessToken)
                .field(VERSION.getKey(), VERSION.getValue())
                .asObject(classToParse)
                .getBody();
    }

    public static <T> T postForCreateAlbumForPhoto(String url, String accessToken, String title, Class<T> classToParse) {
        return Unirest.post(url)
                .field(TITLE.getKey(), title)
                .field(ACCESS_TOKEN.getKey(), accessToken)
                .field(VERSION.getKey(), VERSION.getValue())
                .asObject(classToParse)
                .getBody();
    }

    public static <T> T postForGetUploadServer(String url, String accessToken, int albumId, Class<T> classToParse) {
        return Unirest.post(url)
                .field(ALBUM_ID.getKey(), albumId)
                .field(ACCESS_TOKEN.getKey(), accessToken)
                .field(VERSION.getKey(), VERSION.getValue())
                .asObject(classToParse)
                .getBody();
    }

    public static <T> T postForSavePhoto(String url, String accessToken, int albumId, int server, String photoList,
                                         String hash, Class<T> classToParse) {
        return Unirest.post(url)
                .field(ALBUM_ID.getKey(), albumId)
                .field(ACCESS_TOKEN.getKey(), accessToken)
                .field(VERSION.getKey(), VERSION.getValue())
                .field(SERVER.getKey(), Collections.singleton(server))
                .field(PHOTO_LIST.getKey(), photoList)
                .field(HASH.getKey(), hash)
                .asObject(classToParse)
                .getBody();
    }

    public static <T> T postForGetUploadServer(String url, String fileName, Class<T> classToParse) {
        return Unirest.post(url)
                .field(PHOTO.getKey(), new File(BASE_PATH_TO_ATTACHMENT + fileName))
                .asObject(classToParse)
                .getBody();
    }

    public static <T> T postForUploadVideo(String url, String fileName, Class<T> classToParse) {
        return Unirest.post(url)
                .field(VIDEO.getKey(), new File(BASE_PATH_TO_ATTACHMENT + fileName))
                .asObject(classToParse)
                .getBody();
    }

    public static void postForDeleteAlbum(String url, String accessToken, int albumId) {
        Unirest.post(url)
                .field(ALBUM_ID.getKey(), albumId)
                .field(ACCESS_TOKEN.getKey(), accessToken)
                .field(VERSION.getKey(), VERSION.getValue())
                .asEmpty();
    }

    public static <T> T postForSaveVideo(String url, String accessToken, String nameOfVideo, Class<T> classToParse) {
        return Unirest.post(url)
                .field(NAME.getKey(), nameOfVideo)
                .field(ACCESS_TOKEN.getKey(), accessToken)
                .field(VERSION.getKey(), VERSION.getValue())
                .asObject(classToParse)
                .getBody();
    }

    public static void postForDeleteVideo(String url, String accessToken, int videoId) {
        Unirest.post(url)
                .field(VIDEO_ID.getKey(), videoId)
                .field(ACCESS_TOKEN.getKey(), accessToken)
                .field(VERSION.getKey(), VERSION.getValue())
                .asEmpty();
    }
}

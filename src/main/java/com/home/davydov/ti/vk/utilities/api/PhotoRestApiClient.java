package com.home.davydov.ti.vk.utilities.api;

import com.home.davydov.ti.vk.model.dto.photo.album.CreateAlbumDTO;
import com.home.davydov.ti.vk.model.dto.photo.save_photo.SavePhotoDTO;
import com.home.davydov.ti.vk.model.dto.upload_server.AddPhotoDTO;
import com.home.davydov.ti.vk.model.dto.upload_server.UploadServerDTO;

import static com.home.davydov.ti.vk.utilities.api.RestApiClient.*;
import static com.home.davydov.ti.vk.utilities.api.RestApiHelper.*;

public class PhotoRestApiClient {

    public static CreateAlbumDTO createAlbumForPhotosViaAPI(String accessToken, String title) {
        var url = getCreateAlbumUrl();
        return postForCreateAlbumForPhoto(url, accessToken, title, CreateAlbumDTO.class);
    }

    public static UploadServerDTO getUploadServer(String accessToken, int albumId) {
        var url = getUploadServerUrl();
        return postForGetUploadServer(url, accessToken, albumId, UploadServerDTO.class);
    }

    public static AddPhotoDTO addPhotoToAlbum(String url, String fileName) {
        return postForGetUploadServer(url, fileName, AddPhotoDTO.class);
    }

    public static SavePhotoDTO savePhoto(String accessToken, int albumId, int server, String photoList, String hash) {
        var url = getPhotoSaveUrl();
        return postForSavePhoto(url, accessToken, albumId, server, photoList, hash, SavePhotoDTO.class);
    }

    public static void deleteAlbumById(String accessToken, int albumId) {
        var url = getDeleteAlbumUrl();
        postForDeleteAlbum(url, accessToken, albumId);
    }
}

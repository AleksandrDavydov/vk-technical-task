package com.home.davydov.ti.vk.utilities;

import com.home.davydov.ti.vk.model.dto.photo.save_photo.SavePhotoDTO;
import com.home.davydov.ti.vk.model.dto.upload_server.AddPhotoDTO;
import com.home.davydov.ti.vk.model.dto.upload_server.UploadServerDTO;

import static com.home.davydov.ti.vk.utilities.api.PhotoRestApiClient.*;
import static com.home.davydov.ti.vk.utilities.localstoreg.UtilsForLocalStorage.getAccessToken;

public class UtilsForWorkWithAttachmentViaAPI {

    public static int createAlbumAndGetId(String accessToken, String titleOfAlbum) {
        return createAlbumForPhotosViaAPI(accessToken, titleOfAlbum).response.id;
    }

    public static SavePhotoDTO addAndSavePhotoToAlbumViaAPI(int albumId, String nameOfPhoto) {
        String accessToken = getAccessToken();
        UploadServerDTO uploadServer = getUploadServer(accessToken, albumId);
        AddPhotoDTO addPhoto = addPhotoToAlbum(uploadServer.response.upload_url, nameOfPhoto);
        return savePhoto(accessToken, albumId, addPhoto.server, addPhoto.photos_list, addPhoto.hash);
    }
}

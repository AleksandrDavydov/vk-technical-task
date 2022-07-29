package com.home.davydov.ti.vk.utilities.api;

import com.home.davydov.ti.vk.model.dto.video.SaveVideDTO;
import com.home.davydov.ti.vk.model.dto.video.UploadVideoDTO;

import static com.home.davydov.ti.vk.utilities.api.RestApiClient.*;
import static com.home.davydov.ti.vk.utilities.api.RestApiHelper.getVideoDeleteUrl;
import static com.home.davydov.ti.vk.utilities.api.RestApiHelper.getVideoSaveUrl;

public class VideoRestApiClient {

    public static SaveVideDTO saveVideo(String accessToken, String nameOfVideo) {
        var url = getVideoSaveUrl();
        return postForSaveVideo(url, accessToken, nameOfVideo, SaveVideDTO.class);
    }

    public static UploadVideoDTO uploadVideo(String url, String fileName) {
        return postForUploadVideo(url, fileName, UploadVideoDTO.class);
    }

    public static void deleteVideoById(String accessToken, int videoID) {
        var url = getVideoDeleteUrl();
        postForDeleteVideo(url, accessToken, videoID);
    }
}

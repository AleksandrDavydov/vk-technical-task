package com.home.davydov.ti.vk.page.modal;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.home.davydov.ti.vk.utilities.Constants.BASE_PATH_TO_ATTACHMENT;

public class AddVideoToChatModalWindow {
    public final SelenideElement videoChooseBox = $("#video_choose_box");
    public final SelenideElement addVideoInput = $("div#video_choose_box input[type='file']");
    public final SelenideElement videoPreview = $(".VideoPreview__thumbWrap");

    public SelenideElement getVideoForAdd(String id) {
        return $x(String.format("//div[@id = 'video_all_list']/div[contains(@id, '%s')]", id));
    }

    public void addVideo(String photoName) {
        File image = new File(BASE_PATH_TO_ATTACHMENT + photoName);
        addVideoInput.uploadFile(image);
    }
}

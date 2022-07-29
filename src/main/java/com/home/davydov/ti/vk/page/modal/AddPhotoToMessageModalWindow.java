package com.home.davydov.ti.vk.page.modal;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.home.davydov.ti.vk.utilities.Constants.BASE_PATH_TO_ATTACHMENT;

public class AddPhotoToMessageModalWindow {
    public final SelenideElement addPhotoArea = $("#photos_choose_upload_area_cont");
    public final SelenideElement addPhotoInput = $("div#photos_choose_upload_area_cont input[type='file']");

    public SelenideElement getPhotoForAdd(String id) {
        return $x(String.format("//div[@id='photos_choose_rows']/a[contains(@id, '%s')]", id));
    }

    public void addPhoto(String photoName) {
        File image = new File(BASE_PATH_TO_ATTACHMENT + photoName);
        addPhotoInput.uploadFile(image);
    }
}

package com.home.davydov.ti.vk.page.modal;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AddImageToChatModalWindow {
    public final SelenideElement addImageForChatInput = $("#owner_photo_input > input");
    public final SelenideElement saveImageForChatButton = $("#owner_photo_done_edit");
    public final SelenideElement frameForChatEditDiv = $("[class='tag_frame']");
}

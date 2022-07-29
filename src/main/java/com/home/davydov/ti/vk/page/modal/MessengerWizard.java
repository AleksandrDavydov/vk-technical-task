package com.home.davydov.ti.vk.page.modal;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MessengerWizard {
    public final SelenideElement messengerWizardSection = $("main.FCWindow__content");
    public final SelenideElement previewAttachPhoto = $("div.ComposerAttachPhoto");
    public final SelenideElement previewAttachVideo = $("div.ComposerAttachVideo");
    public final SelenideElement sentPhotoInChatWizard = $("div.AttachPhotos");
    public final SelenideElement sentVideoInChatWizard = $("div.AttachVideos__item");
    public final SelenideElement sendInput = $(".FCComposer__input");
    public final SelenideElement addAttachmentIconInWizard = $("div.FCComposer span.ms_item_more_label");
    public final SelenideElement addPhotoIconInWizard = $("div.FCComposer a.ms_item_photo");
    public final SelenideElement addVideoIconInWizard = $("div.FCComposer a.ms_item_video");
    public final SelenideElement closeMessengerWizard = $(".FCWindow__close");


    public SelenideElement getChatFromMessengerWizardByTitle(String title) {
        return $(String.format("button[aria-label='%s']", title));
    }

    public void openAddPhotoModalWindowViaMessengerWizard() {
        addAttachmentIconInWizard
                .shouldBe(visible)
                .hover();
        addPhotoIconInWizard
                .shouldBe(visible)
                .click();
    }

    public void openAddVideoModalWindowViaMessengerWizard() {
        addAttachmentIconInWizard
                .shouldBe(visible)
                .hover();
        addVideoIconInWizard
                .shouldBe(visible)
                .click();
    }
}

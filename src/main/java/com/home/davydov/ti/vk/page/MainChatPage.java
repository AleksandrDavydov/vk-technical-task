package com.home.davydov.ti.vk.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainChatPage {
    public final SelenideElement topNameOfChat = $("._im_page_peer_name");
    public final SelenideElement nameOfChatInBody = $(".im-mess--text>b");
    public final SelenideElement ownerNameOfChatInBody = $(".im-mess--text>a");
    public final SelenideElement userAddImageNameInChat = $("._im_log_body>a");
    public final SelenideElement imageAddedToChat = $(".im_chat_photo_upd");
    public final SelenideElement addAttachmentIcon = $(".ms_item_more_label");
    public final SelenideElement addPhotoIcon = $("a.ms_item_photo");
    public final SelenideElement addVideoIcon = $("a.ms_item_video");
    public final SelenideElement imagePreview = $("img._preview");
    public final SelenideElement sendButton = $("button._im_send");

    //TODO Change locators
    public final SelenideElement sentPhotoInChat = $("[aria-label='фотография']");
    public final SelenideElement sentVideoInChat =
            $x("//div[contains(@class, 'page_post_sized_thumbs')]/a[contains(@aria-label, 'Видео')]");

    public void openAddPhotoModalWindow() {
        addAttachmentIcon
                .shouldBe(visible)
                .hover();
        addPhotoIcon
                .shouldBe(visible)
                .click();
    }

    public void openAddVideoModalWindow() {
        addAttachmentIcon
                .shouldBe(visible)
                .hover();
        addVideoIcon
                .shouldBe(visible)
                .click();
    }
}

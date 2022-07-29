package com.home.davydov.ti.vk.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.home.davydov.ti.vk.model.User;
import com.home.davydov.ti.vk.page.modal.AddImageToChatModalWindow;
import com.home.davydov.ti.vk.page.modal.AddPhotoToMessageModalWindow;
import com.home.davydov.ti.vk.page.modal.AddVideoToChatModalWindow;
import com.home.davydov.ti.vk.page.modal.MessengerWizard;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.home.davydov.ti.vk.utilities.Constants.BASE_PATH_TO_ATTACHMENT;
import static com.home.davydov.ti.vk.utilities.Constants.BASE_URL;

public class MessengerPage {
    public MainChatPage mainChatPage = new MainChatPage();
    public AddImageToChatModalWindow addImageToChatModalWindow = new AddImageToChatModalWindow();
    public AddPhotoToMessageModalWindow addPhotoToMessageModalWindow = new AddPhotoToMessageModalWindow();
    public AddVideoToChatModalWindow addVideoToChatModalWindow = new AddVideoToChatModalWindow();
    public MessengerWizard messengerWizard = new MessengerWizard();

    public final SelenideElement allMessagesItem = $("#ui_rmenu_all");
    public final SelenideElement createNewConversationButton = $("._im_create_convo");
    public final SelenideElement createConversationButton = $("button._im_confirm_creation");
    public final SelenideElement nameOfChatInput = $("#im_dialogs_creation_name");
    public final SelenideElement iconOfChatInput = $("._im_create_avatar");
    public final SelenideElement removeIconForChatButton = $("._im_create_remove_avatar");
    public final ElementsCollection listOfConversations = $$("._im_dialog_link");


    public void openMessengerPage() {
        open(BASE_URL + "/im");
    }

    public void openUniqueMessengerPageById(int id) {
        open(BASE_URL + "/im?sel=c" + id);
    }

    public void createNewConversationWithoutImage(String nameOfConversation) {
        createNewConversationButton.click();
        nameOfChatInput.sendKeys(nameOfConversation);
        createConversationButton
                .shouldBe(enabled)
                .click();
    }

    public void createNewConversationWithImage(String nameOfConversation, String imageName) {
        createNewConversationButton.click();
        iconOfChatInput.click();
        File image = new File(BASE_PATH_TO_ATTACHMENT + imageName);
        addImageToChatModalWindow.addImageForChatInput.uploadFile(image);
        addImageToChatModalWindow.frameForChatEditDiv.shouldBe(visible);
        addImageToChatModalWindow.saveImageForChatButton.click();
        removeIconForChatButton.shouldBe(visible);
        nameOfChatInput.sendKeys(nameOfConversation);
        createConversationButton
                .shouldBe(enabled)
                .click();
    }

    public void checkNewCreatedConversation(String nameOfConversation, User user) {
        mainChatPage.topNameOfChat.has(text(nameOfConversation));
        mainChatPage.nameOfChatInBody.has(text(nameOfConversation));
        mainChatPage.ownerNameOfChatInBody.has(text(user.getFullUserName()));
    }

    public void checkNewCreateConversationWithImage(String nameOfConversation, User user) {
        checkNewCreatedConversation(nameOfConversation, user);
        mainChatPage.userAddImageNameInChat.has(text(user.getFullUserName()));
        mainChatPage.imageAddedToChat.shouldBe(visible);
    }

    public void checkNewChatInListOfConversation(String nameOfConversation) {
        listOfConversations.get(0).has(text(nameOfConversation));
    }

}

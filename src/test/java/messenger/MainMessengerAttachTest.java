package messenger;

import base.BaseMessengerTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.home.davydov.ti.vk.utilities.UtilsForWorkWithMessengerViaAPI.createNewChatViaAPI;
import static com.home.davydov.ti.vk.utilities.UtilsForWorkWithMessengerViaAPI.deleteChatById;
import static io.qameta.allure.Allure.step;
import static java.time.Duration.ofSeconds;

public class MainMessengerAttachTest extends BaseMessengerTest {
    protected int idOfConversation;

    @AfterMethod
    public void tearDownTest() {
        deleteChatById(idOfConversation);
    }

    @Test
    @Epic("Regression tests")
    @Feature("Attache email")
    @Description("Check that user has opportunity attache image to chat from his local storage " +
            "via main messenger")
    public void attacheImageFromLocalStorage() {
        step("1. Create new chat via API and open it", () -> {
            idOfConversation = createNewChatViaAPI(titleOfConversation).response;
            messengerPage.openUniqueMessengerPageById(idOfConversation);
        });
        step("2. Open modal window for adding photo and add photo from local storage", () -> {
            messengerPage.mainChatPage.openAddPhotoModalWindow();
            messengerPage.addPhotoToMessageModalWindow.addPhotoArea.shouldBe(visible);
            messengerPage.addPhotoToMessageModalWindow.addPhoto(nameOfPhoto);
            messengerPage.mainChatPage.imagePreview.shouldBe(visible, ofSeconds(20));
        });
        step("3. Send photo and verify that photo was sent", () -> {
            messengerPage.mainChatPage.sendButton.click();
            messengerPage.mainChatPage.sentPhotoInChat.shouldBe(visible, ofSeconds(20));
        });
    }

    @Test
    @Epic("Regression tests")
    @Feature("Attache video")
    @Description("Check that user has opportunity attache video with correct format to chat from his local storage " +
            "via main messenger")
    public void attacheVideoFromLocalStorage() {
        step("1. Create new chat via API and open it", () -> {
            idOfConversation = createNewChatViaAPI(titleOfConversation).response;
            messengerPage.openUniqueMessengerPageById(idOfConversation);
        });
        step("2. Open modal window for adding video and add video from local storage", () -> {
            messengerPage.mainChatPage.openAddVideoModalWindow();
            messengerPage.addVideoToChatModalWindow.videoChooseBox.shouldBe(visible);
            messengerPage.addVideoToChatModalWindow.addVideo(nameOfVideo);
            messengerPage.addVideoToChatModalWindow.videoPreview.shouldBe(visible, ofSeconds(40));
        });
        step("3. Send video and verify that video was sent", () -> {
            messengerPage.mainChatPage.sendButton.click();
            messengerPage.mainChatPage.sentVideoInChat.shouldBe(visible, ofSeconds(30));
        });

    }

    @Test(groups = {"PhotoFromAlbum"})
    @Epic("Regression tests")
    @Feature("Attache photo")
    @Description("Check that user has opportunity attache image to chat from his album in 'vk' web site " +
            "via main messenger")
    public void attachePhotoFromAlbum() {
        step("1. Create new chat via API and open it", () -> {
            idOfConversation = createNewChatViaAPI(titleOfConversation).response;
            messengerPage.openUniqueMessengerPageById(idOfConversation);
        });
        step("2. Open modal window for adding photo and add photo from album of user", () -> {
            messengerPage.mainChatPage.openAddPhotoModalWindow();
            messengerPage.addPhotoToMessageModalWindow.addPhotoArea.shouldBe(visible);
            messengerPage.addPhotoToMessageModalWindow.getPhotoForAdd(String.valueOf(idOfImage)).click();
            messengerPage.mainChatPage.imagePreview.shouldBe(visible);
        });
        step("3. Send photo and verify that photo was sent", () -> {
            messengerPage.mainChatPage.sendButton.click();
            messengerPage.mainChatPage.sentPhotoInChat.shouldBe(visible, ofSeconds(20));
        });
    }

    @Test(groups = {"VideoFromUserLibrary"})
    @Epic("Regression tests")
    @Feature("Attache video")
    @Description("Check that user has opportunity attache video with correct format to chat from " +
            "his album in 'vk' web site via main messenger")
    public void attacheVideoFromUserVideoCatalog() {
        step("1. Create new chat via API and open it", () -> {
            idOfConversation = createNewChatViaAPI(titleOfConversation).response;
            messengerPage.openUniqueMessengerPageById(idOfConversation);
        });
        step("2. Open modal window for adding video and add video from user's videos", () -> {
            messengerPage.mainChatPage.openAddVideoModalWindow();
            messengerPage.addVideoToChatModalWindow.videoChooseBox.shouldBe(visible);
            messengerPage.addVideoToChatModalWindow.getVideoForAdd(String.valueOf(idOfVideo)).click();
            messengerPage.addVideoToChatModalWindow.videoPreview.shouldBe(visible, ofSeconds(40));
        });
        step("3. Send video and verify that video was sent", () -> {
            messengerPage.mainChatPage.sendButton.click();
            messengerPage.mainChatPage.sentVideoInChat.shouldBe(visible, ofSeconds(30));
        });
    }
}

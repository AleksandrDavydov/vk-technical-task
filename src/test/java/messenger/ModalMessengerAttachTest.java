package messenger;

import base.BaseMessengerTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.home.davydov.ti.vk.utilities.UtilsForWorkWithMessengerViaAPI.createNewChatViaAPI;
import static com.home.davydov.ti.vk.utilities.UtilsForWorkWithMessengerViaAPI.deleteChatById;
import static io.qameta.allure.Allure.step;
import static java.time.Duration.ofSeconds;

public class ModalMessengerAttachTest extends BaseMessengerTest {
    private int idOfConversation;

    @AfterMethod
    public void tearDownTest() {
        deleteChatById(idOfConversation);
    }

    @Test
    @Epic("Regression tests")
    @Feature("Attache photo")
    @Description("Check that user has opportunity attache image to chat from his local storage " +
            "via modal messenger wizard")
    public void attacheImageFromLocalStorage() {
        step("1. Open main page create new conversation via api", () -> {
            mainPage.openMainPage();
            idOfConversation = createNewChatViaAPI(titleOfConversation).response;
        });
        step("2. Unwrap modal messenger wizard, and open chat", () -> {
            mainPage.unwrapModalMessengerButton.click();
            messengerPage.messengerWizard.messengerWizardSection.shouldBe(visible);
            messengerPage.messengerWizard.getChatFromMessengerWizardByTitle(titleOfConversation).click();
        });
        step("3. Open modal window for adding photo via messenger wizard " +
                "and add photo from local storage", () -> {
            messengerPage.messengerWizard.openAddPhotoModalWindowViaMessengerWizard();
            messengerPage.addPhotoToMessageModalWindow.addPhotoArea.shouldBe(visible);
            messengerPage.addPhotoToMessageModalWindow.addPhoto(nameOfPhoto);
            messengerPage.messengerWizard.previewAttachPhoto.shouldBe(visible, ofSeconds(20));
        });

        step("4. Send photo and verify that photo was sent", () -> {
            messengerPage.messengerWizard.sendInput.sendKeys(Keys.ENTER);
            messengerPage.messengerWizard.sentPhotoInChatWizard.shouldBe(visible, ofSeconds(20));
        });

        step("5. Close messenger wizard", () ->
                messengerPage.messengerWizard.closeMessengerWizard.click()
        );
    }

    @Test(groups = {"PhotoFromAlbum"})
    @Epic("Regression tests")
    @Feature("Attache photo")
    @Description("Check that user has opportunity attache image to chat from his album in 'vk' web site " +
            "via modal messenger wizard")
    public void attachePhotoFromAlbum() {
        step("1. Open main page create new conversation via api", () -> {
            mainPage.openMainPage();
            idOfConversation = createNewChatViaAPI(titleOfConversation).response;
        });
        step("2. Unwrap modal messenger wizard, and open chat", () -> {
            mainPage.unwrapModalMessengerButton.click();
            messengerPage.messengerWizard.messengerWizardSection.shouldBe(visible);
            messengerPage.messengerWizard.getChatFromMessengerWizardByTitle(titleOfConversation).click();
        });
        step("3. Open modal window for adding photo via messenger wizard " +
                "and add photo from album of user", () -> {
            messengerPage.messengerWizard.openAddPhotoModalWindowViaMessengerWizard();
            messengerPage.addPhotoToMessageModalWindow.addPhotoArea.shouldBe(visible);
            messengerPage.addPhotoToMessageModalWindow.getPhotoForAdd(String.valueOf(idOfImage)).click();
            messengerPage.messengerWizard.previewAttachPhoto.shouldBe(visible, ofSeconds(20));
        });
        step("4. Send photo and verify that photo was sent", () -> {
            messengerPage.messengerWizard.sendInput.sendKeys(Keys.ENTER);
            messengerPage.messengerWizard.sentPhotoInChatWizard.shouldBe(visible, ofSeconds(20));
        });
        step("5. Close messenger wizard", () ->
                messengerPage.messengerWizard.closeMessengerWizard.click()
        );
    }

    @Test
    @Epic("Regression tests")
    @Feature("Attache video")
    @Description("Check that user has opportunity attache video with correct format to chat from his local storage" +
            "via modal messenger wizard")
    public void attacheVideoFromLocalStorage() {
        step("1. Open main page create new conversation via api", () -> {
            mainPage.openMainPage();
            idOfConversation = createNewChatViaAPI(titleOfConversation).response;
        });
        step("2. Unwrap modal messenger wizard, and open chat", () -> {
            mainPage.unwrapModalMessengerButton.click();
            messengerPage.messengerWizard.messengerWizardSection.shouldBe(visible);
            messengerPage.messengerWizard.getChatFromMessengerWizardByTitle(titleOfConversation).click();
        });
        step("3. Open modal window for adding video via messenger wizard " +
                "and add video from local storage", () -> {
            messengerPage.messengerWizard.openAddVideoModalWindowViaMessengerWizard();
            messengerPage.addVideoToChatModalWindow.videoChooseBox.shouldBe(visible);
            messengerPage.addVideoToChatModalWindow.addVideo(nameOfVideo);
            messengerPage.messengerWizard.previewAttachVideo.shouldBe(visible, ofSeconds(30));
        });
        step("4. Send video and verify that video was sent", () -> {
            messengerPage.messengerWizard.sendInput.sendKeys(Keys.ENTER);
            messengerPage.messengerWizard.sentVideoInChatWizard.shouldBe(visible, ofSeconds(20));
        });
        step("5. Close messenger wizard", () ->
                messengerPage.messengerWizard.closeMessengerWizard.click()
        );
    }

    @Test(groups = {"VideoFromUserLibrary"})
    @Epic("Regression tests")
    @Feature("Attache video")
    @Description("Check that user has opportunity attache video with correct format to chat from " +
            "his album in 'vk' web site via modal messenger wizard")
    public void attacheVideoFromUserVideoCatalog() {
        step("1. Open main page create new conversation via api", () -> {
            mainPage.openMainPage();
            idOfConversation = createNewChatViaAPI(titleOfConversation).response;
        });
        step("2. Unwrap modal messenger wizard, and open chat", () -> {
            mainPage.unwrapModalMessengerButton.click();
            messengerPage.messengerWizard.messengerWizardSection.shouldBe(visible);
            messengerPage.messengerWizard.getChatFromMessengerWizardByTitle(titleOfConversation).click();
        });
        step("3. Open modal window for adding video via messenger wizard " +
                "and add video from user's videos", () -> {
            messengerPage.messengerWizard.openAddVideoModalWindowViaMessengerWizard();
            messengerPage.addVideoToChatModalWindow.videoChooseBox.shouldBe(visible);
            messengerPage.addVideoToChatModalWindow.getVideoForAdd(String.valueOf(idOfVideo)).click();
            messengerPage.messengerWizard.previewAttachVideo.shouldBe(visible, ofSeconds(30));
        });
        step("4. Send video and verify that video was sent", () -> {
            messengerPage.messengerWizard.sendInput.sendKeys(Keys.ENTER);
            messengerPage.messengerWizard.sentVideoInChatWizard.shouldBe(visible, ofSeconds(20));
        });
        step("5. Close messenger wizard", () ->
                messengerPage.messengerWizard.closeMessengerWizard.click()
        );
    }
}

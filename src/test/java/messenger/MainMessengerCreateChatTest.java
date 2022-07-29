package messenger;

import base.BaseMessengerTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.home.davydov.ti.vk.utilities.UtilsForWorkWithMessengerViaAPI.deleteChatById;
import static com.home.davydov.ti.vk.utilities.UtilsForWorkWithMessengerViaAPI.getIdOfChatByTitle;
import static io.qameta.allure.Allure.step;

public class MainMessengerCreateChatTest extends BaseMessengerTest {
    private final String nameOfConversationWithoutImage = "New chat without image";
    private final String nameOfConversationWithImage = "New chat with image";
    private final String nameOfImage = "vk_image.png";
    private int chatId;

    @AfterMethod
    public void tearDownTest() {
        deleteChatById(chatId);
    }

    @Test
    @Epic("Regression tests")
    @Feature("Create chat")
    @Description("Check that user has opportunity create new chat without image")
    public void createNewChatWithoutImageTest() {
        step("1. Open main messenger page", () -> {
            messengerPage.openMessengerPage();
            messengerPage.allMessagesItem.shouldBe(visible);
        });
        step("2. Create new conversation without image, verify that chat has correct title " +
                "and name of user who created it. Get id of conversation", () -> {
            messengerPage.createNewConversationWithoutImage(nameOfConversationWithoutImage);
            messengerPage.checkNewCreatedConversation(nameOfConversationWithoutImage, user);
            chatId = getIdOfChatByTitle(nameOfConversationWithoutImage);
        });
        step("3. Open main messenger page and verify that list of chats has new conversation", () -> {
            messengerPage.openMessengerPage();
            messengerPage.checkNewChatInListOfConversation(nameOfConversationWithoutImage);
        });
    }

    @Test
    @Epic("Regression tests")
    @Feature("Create chat")
    @Description("Check that user has opportunity create new chat with image")
    public void createNewChatWithImageTest() {
        step("1. Open main paige, go to messenger page", () -> {
            mainPage.openMainPage();
            messengerPage.openMessengerPage();
            messengerPage.allMessagesItem.shouldBe(visible);
        });
        step("2. Create new conversation with image, verify that chat has correct title " +
                "and name of user who created it. Get id of conversation", () -> {
            messengerPage.createNewConversationWithImage(nameOfConversationWithImage, nameOfImage);
            messengerPage.checkNewCreateConversationWithImage(nameOfConversationWithImage, user);
            chatId = getIdOfChatByTitle(nameOfConversationWithImage);
        });
        step("3. Open main messenger page and verify that list of chats has new conversation", () -> {
            messengerPage.openMessengerPage();
            messengerPage.checkNewChatInListOfConversation(nameOfConversationWithoutImage);
        });
    }
}

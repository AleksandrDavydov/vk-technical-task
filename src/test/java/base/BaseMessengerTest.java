package base;

import com.home.davydov.ti.vk.model.dto.video.SaveVideDTO;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Condition.visible;
import static com.home.davydov.ti.vk.utilities.UtilsForWorkWithAttachmentViaAPI.addAndSavePhotoToAlbumViaAPI;
import static com.home.davydov.ti.vk.utilities.UtilsForWorkWithAttachmentViaAPI.createAlbumAndGetId;
import static com.home.davydov.ti.vk.utilities.api.PhotoRestApiClient.deleteAlbumById;
import static com.home.davydov.ti.vk.utilities.api.VideoRestApiClient.*;
import static com.home.davydov.ti.vk.utilities.localstoreg.UtilsForLocalStorage.getAccessToken;
import static java.lang.Thread.sleep;

public abstract class BaseMessengerTest extends BaseTest {

    protected int albumId = 0;
    protected int idOfImage = 0;
    protected int idOfVideo = 0;
    protected final String titleOfConversation = "New Conversation";
    protected final String albumTitle = "New Album for test";
    protected final String nameOfPhoto = "vk_image.png";
    protected final String nameOfVideo = "vk_video.mov";
    protected final String titleOfVideo = "New test video";

    @BeforeTest
    public void openMainPageAndLogin() {
        mainPage.openMainPage();
        loginPage.loginAsUser(user.getLogin(), user.getPassword());
        mainPage.topProfileIcon.shouldBe(visible);
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeGroups(groups = "PhotoFromAlbum")
    public void addImageToAlbum() {
        albumId = createAlbumAndGetId(getAccessToken(), albumTitle);
        idOfImage = addAndSavePhotoToAlbumViaAPI(albumId, nameOfPhoto).response.get(0).id;
    }

    @BeforeGroups("VideoFromUserLibrary")
    public void addVideoToLibrary() {
        SaveVideDTO new_video = saveVideo(getAccessToken(), titleOfVideo);
        idOfVideo = uploadVideo(new_video.response.upload_url, nameOfVideo).video_id;
    }

    @AfterTest
    public void logOutAfterTests() {
        if (albumId != 0) {
            deleteAlbumById(getAccessToken(), albumId);
        }
        if (idOfVideo != 0) {
            deleteVideoById(getAccessToken(), idOfVideo);
        }
        mainPage.logOut();
    }

}

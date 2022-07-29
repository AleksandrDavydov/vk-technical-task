package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.home.davydov.ti.vk.model.User;
import com.home.davydov.ti.vk.page.LoginPage;
import com.home.davydov.ti.vk.page.MainPage;
import com.home.davydov.ti.vk.page.MessengerPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.home.davydov.ti.vk.utilities.Constants.LOGIN;
import static com.home.davydov.ti.vk.utilities.Constants.PASSWORD;

public abstract class BaseTest {
    protected MainPage mainPage = new MainPage();
    protected LoginPage loginPage = new LoginPage();
    protected MessengerPage messengerPage = new MessengerPage();
    protected User user = new User(LOGIN, PASSWORD);

    @BeforeTest
    public void setUpBaseTestAll() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true).savePageSource(false));
    }

    @AfterTest(alwaysRun = true)
    public void runNewDriver() {
        closeWebDriver();
        SelenideLogger.removeListener("allure");
    }
}

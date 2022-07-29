package com.home.davydov.ti.vk.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.home.davydov.ti.vk.utilities.Constants.BASE_URL;

public class MainPage {
    public final SelenideElement topProfileIcon = $("#top_profile_link");
    public final SelenideElement logOutButton = $("#top_logout_link");

    public final SelenideElement unwrapModalMessengerButton = $("button.FCPanel__add");

    public void openMainPage() {
        open(BASE_URL);
    }

    public void logOut() {
        topProfileIcon.click();
        logOutButton.click();
    }
}

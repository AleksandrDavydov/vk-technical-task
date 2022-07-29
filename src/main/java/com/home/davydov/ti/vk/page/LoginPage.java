package com.home.davydov.ti.vk.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public final SelenideElement loginInput = $("#index_email");
    public final SelenideElement otpCodeInput = $("#otp");
    public final SelenideElement passwordInput = $("[name='password']");

    public final SelenideElement signInButton = $("button.VkIdForm__signInButton");
    public final SelenideElement switchToPasswordButton = $("button.vkc__Bottom__switchToPassword");
    //TODO Change name
    public final SelenideElement proceedButton = $("button.vkc__Button__fluid");

    public void loginAsUser(String login, String password) {
        loginInput.sendKeys(login);
        signInButton.click();
        if (otpCodeInput.isDisplayed()) {
            switchToPasswordButton.click();
        }
        passwordInput.sendKeys(password);
        proceedButton.click();
    }
}

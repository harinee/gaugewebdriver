package com.tests.pages;

import com.tests.domains.User;
import com.tests.helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    @FindBy(id="user_email")
    public WebElement usernameField;

    @FindBy(id="user_password")
    public WebElement passwordField;

    @FindBy(name="commit")
    public WebElement loginBtn;

    @FindBy(linkText = "Sign up")
    public WebElement signUp;

    public LoginPage() {
        initElements(this);
    }

    public boolean isReady() throws InterruptedException {
        waitForPageLoad();
        return isElementDisplayed(loginBtn, "Login button");
    }

    public boolean login(User user) throws InterruptedException {
        fill(usernameField, "Username").with(user.getEmail());
        fill(passwordField, "Password").with(user.getPassword());
        click(loginBtn, "Login button");
        return isElementNotDisplayed(loginBtn, "Login button");
    }

    public RegistrationPage signUp() throws InterruptedException {
        click(signUp, "Sign up button");
        return new RegistrationPage();
    }
}

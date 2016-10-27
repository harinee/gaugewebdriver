package com.tests.pages;

import com.tests.helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    @FindBy(className="belowHeader")
    private WebElement header;

    @FindBy(linkText = "CLIENTS")
    private WebElement clients;

    @FindBy(className = "glyphicon-log-out")
    public WebElement logout;

    @FindBy(className = "glyphicon-home")
    public WebElement homeIcon;

    public HomePage() {
        initElements(this);
    }

    public boolean isReady() throws InterruptedException {
        waitForPageLoad();
        return isElementDisplayed(header, "Header");
    }

    public ClientPage openClients() throws InterruptedException {
        click(clients, "Clients");
        return new ClientPage();
    }

    public LoginPage logout() throws InterruptedException {
        click(logout, "Logout icon");
        return new LoginPage();
    }

    public void navigate() throws InterruptedException {
        click(homeIcon, "Home icon");
    }
}

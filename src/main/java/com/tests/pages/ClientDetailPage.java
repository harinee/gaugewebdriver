package com.tests.pages;

import com.tests.helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientDetailPage extends Page {

    @FindBy(className = "edit")
    private WebElement editClient;

    public ClientDetailPage() {
        initElements(this);
    }

    public boolean isReady() throws InterruptedException {
        return isElementDisplayed(editClient, "Edit client details");
    }
}

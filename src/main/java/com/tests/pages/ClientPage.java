package com.tests.pages;

import com.tests.helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientPage extends Page{

    @FindBy(id="search")
    private WebElement searchField;

    @FindBy(className="searchBtn")
    private WebElement searchBtn;

    @FindBy(css=".table tbody tr")
    private WebElement tableBody;

    @FindBy(className="info")
    private WebElement selectClientBtn;

    public ClientPage() {
        initElements(this);
    }

    public boolean isReady() throws InterruptedException {
        return isElementDisplayed(searchBtn, "Search button");
    }

    public void search(String searchTerm) throws InterruptedException {
        isReady();
        fill(searchField, "Search field text box").with(searchTerm);
        click(searchBtn, "Search button");
    }

    public boolean isTableContains(String text) {
        return isTextContained(tableBody, text);
    }

    public void selectClient() throws InterruptedException {
        click(selectClientBtn, "Select client button");
    }
}

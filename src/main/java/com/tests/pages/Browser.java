package com.tests.pages;

import com.tests.helpers.ui.Page;
import org.openqa.selenium.WebDriver;

public class Browser extends Page {
    public static String browserName = System.getenv("browser_name") == null ? "internetexplorer" : System.getenv("browser_name");
    public static boolean clear_cache = System.getenv("clearCache") != null && Boolean.parseBoolean(System.getenv("clearCache"));

    public Browser() {
        initElements(this);
    }

    public Browser(WebDriver windowDriver) {
        super(windowDriver);
        initElements(this);
    }

    public void navigateBrowserBack(){
        browserBack();
    }

    public void navigateTo(String baseUrl){
        visit(baseUrl);
        maximizeWindow();
    }

    public void close(){
        closeBrowser();
    }

    public void closeCurrentWindow(){
        closeWindow();
    }

    public void openNewTab(String baseUrl) throws InterruptedException {
        openANewWindow(baseUrl);
    }

    public int countNumberOfWindows(){
        return numberOfOpenWindows();
    }
}

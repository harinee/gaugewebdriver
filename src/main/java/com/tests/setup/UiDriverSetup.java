package com.tests.setup;

import com.tests.domains.Application;
import com.tests.domains.User;
import com.tests.pages.Browser;
import com.tests.pages.HomePage;
import com.tests.pages.LoginPage;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UiDriverSetup {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite()
    public void suiteSetup() {
        startBrowser();
    }

    @BeforeScenario(tags = {"WithLogin"})
    public void setup() throws InterruptedException {
        new LoginPage().login(User.getUser());
        assertThat("User should be logged in", new HomePage().isReady(), is(true));
    }


    public void startBrowser() {
        getBrowserDriver(true);
        String baseUrl = new Application().getUrl();
        new Browser().navigateTo(baseUrl);
    }

    private void getBrowserDriver(Boolean isRemoteServer) {
        System.out.println("====>>>> clear cache value: " + Browser.clear_cache);
        if (isRemoteServer){
            driver = DriverFactory.getDriver();
        }
        else {
            driver = DriverFactory.createDriver(Browser.browserName, Browser.clear_cache);
        }
        if (Browser.clear_cache) {
            driver.manage().deleteAllCookies();
        }
    }

    @BeforeScenario(tags="Registration")
    public void logout() throws InterruptedException {
        boolean onLoginPage = new LoginPage().isReady();
        if (!onLoginPage) {
            new HomePage().logout();
            assertThat("On login page", new LoginPage().isReady(), is(true));
        }
    }

    @AfterScenario(tags="WithLogin")
    public void navigateToHome() throws InterruptedException {
        new HomePage().navigate();
        assertThat("Home page is loaded", new HomePage().isReady(), is(true));
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
        driver.quit();
        driver = null;
    }
}

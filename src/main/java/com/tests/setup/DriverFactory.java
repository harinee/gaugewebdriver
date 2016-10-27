package com.tests.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    private static final String FIREFOX = "firefox";

    private static final String CHROME = "chrome";

    private static final String INTERNET_EXPLORER = "internetexplorer";

    public static WebDriver createDriver(String browserName, boolean cleanCache) {
        if (browserName.equalsIgnoreCase(CHROME)) {
            return createChromeDriver(cleanCache);
        }
        else if (browserName.equalsIgnoreCase(INTERNET_EXPLORER)) {
            return createInternetExplorerDriver(cleanCache);
        }
        else if(browserName.equalsIgnoreCase(FIREFOX)){
            return createFirefoxDriver(cleanCache);
        }
        throw new RuntimeException("Unknown WebDriver browser: " + browserName);
    }

    private static WebDriver createChromeDriver(boolean clearCache) {
        System.setProperty("webdriver.chrome.driver", System.getenv("webdriver_chrome_driver"));
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        if (clearCache) {
            ChromeOptions opts = new ChromeOptions();
            opts.addArguments("--disable-application-cache");
            capabilities.setCapability(ChromeOptions.CAPABILITY, opts);
        }
        return new ChromeDriver(capabilities);
    }

    private static WebDriver createInternetExplorerDriver(boolean clearCache) {
        System.setProperty("webdriver.ie.driver", System.getenv("webdriver_ie_driver"));
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, clearCache);
        return new InternetExplorerDriver(capabilities);
    }

    private static WebDriver createFirefoxDriver(boolean clearCache) {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.cache.disk.enable", !clearCache);
        profile.setPreference("browser.cache.memory.enable", !clearCache);
        return new FirefoxDriver(profile);
    }
}

package com.tests.helpers.ui;

import com.tests.setup.UiDriverSetup;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CustomScreenshotFactory implements ICustomScreenshotGrabber {

    public byte[] takeScreenshot() {
        WebDriver driver = UiDriverSetup.getDriver();
        if (driver != null) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } else {
            showError("Skipping screenshot as UI driver doesn't exist");
            return null;
        }
    }

    private void showError(String format, String... args){
        Gauge.writeMessage(format, args);
        System.err.printf(format, args);
        System.err.println();
    }
}

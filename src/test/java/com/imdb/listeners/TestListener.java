package com.imdb.listeners;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

        System.out.println("❌ Test failed: " + testName);
        System.out.println("📸 Taking screenshot...");

        try {
            byte[] screenshot = Selenide.screenshot(OutputType.BYTES);

            if (screenshot != null) {
                String attachmentName = "Screenshot - " + testName + " - " + timestamp;
                Allure.addAttachment(attachmentName,
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        ".png");

                if (WebDriverRunner.hasWebDriverStarted()) {
                    String pageSource = WebDriverRunner.getWebDriver().getPageSource();
                    Allure.addAttachment("Page Source", "text/html", pageSource, ".html");

                    System.out.println("✅ Page Source attached to Allure report");
                }

                System.out.println("✅ Screenshot attached to Allure report");
            }
        } catch (Exception e) {
            System.err.println("⚠️ Failed to take screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test passed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⏭️ Test skipped: " + result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("▶️ Test started: " + result.getName());
    }
}
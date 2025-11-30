package com.imdb.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;

import java.util.logging.Level;

public class ConfigManager {

    private ConfigManager() {}

    public static void setupSelenide() {
        setupSelenideLogger();
        setupBrowserProperties();
    }

    private static void setupSelenideLogger() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .enableLogs(LogType.BROWSER, Level.ALL)
        );
    }

    private static void setupBrowserProperties() {
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
    }
}
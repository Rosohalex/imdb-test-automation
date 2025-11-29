package com.imdb.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePage {
    private static final String BASE_URL = "https://www.imdb.com";

    private final SelenideElement acceptCookiesBtn = $("[data-testid = accept-button]");
    private final SelenideElement searchInput = $("#suggestion-search");
    private final ElementsCollection dropdownSearchResults = $$("[id*='react-autowhatever-navSuggestionSearch--item-']");

    @Step("Open IMDB homepage")
    public HomePage open() {
        com.codeborne.selenide.Selenide.open(BASE_URL);
        getWebDriver().manage().window().maximize();
        return this;
    }

    @Step("Accept Cookies")
    public HomePage acceptCookies() {
        acceptCookiesBtn.click();
        return this;
    }

    @Step("Search for '{query}'")
    public HomePage search(String query) {
        searchInput.setValue(query);
        return this;
    }

    @Step("Get first result title from search dropdown")
    public String getFirstResultTitle() {
        return dropdownSearchResults.first().$(".searchResult__constTitle").getText();
    }

    @Step("Click on first result from search dropdown")
    public FilmPage clickFirstResult() {
        dropdownSearchResults.first().click();
        return new FilmPage();
    }
}

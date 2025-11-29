package com.imdb.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ActorPage {

    private final SelenideElement actorName = $("[data-testid = hero__primary-text]");

    @Step("Get actor name from profile page")
    public String getActorName() {
        return actorName.getText();
    }
}

package com.imdb.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FilmPage {
    private final SelenideElement title = $("[data-testid='hero__primary-text']");
    private final ElementsCollection topCastMembers = $$("[data-testid='title-cast-item']");

    @Step("Get film title")
    public String getTitle() {
        return title.getText();
    }

    @Step("Get top cast members count")
    public int getTopCastMembersCount() {
        topCastMembers.first().scrollIntoView(true);
        return topCastMembers.size();
    }

    @Step("Get cast member name at position {position}")
    public String getCastMemberName(int position) {
        return getTopCastMemberName(position).getText();
    }

    @Step("Click on cast member name at position {position}")
    public ActorPage clickCastMemberName(int position) {
        getTopCastMemberName(position).click();
        return new ActorPage();
    }

    private SelenideElement getTopCastMemberName(int position) {
        return topCastMembers.get(position - 1).$("[data-testid='title-cast-item__actor']");
    }
}

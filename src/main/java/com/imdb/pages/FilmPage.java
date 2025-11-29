package com.imdb.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TitlePage {
    private final SelenideElement pageTitle = $("[data-testid='hero__primary-text']");
    private final ElementsCollection topCastMembers = $$("[data-testid='title-cast-item']");

    @Step("Get page title")
    public String getPageTitle() {
        return pageTitle.getText();
    }

    @Step("Get top cast count")
    public int getTopCastCount() {
        return topCastMembers.size();
    }

    @Step("Get cast member name at position {position}")
    public String getCastMemberName(int position) {
          SelenideElement topCastMember = topCastMembers.get(position - 1);
          topCastMember.scrollIntoView(false);

        return topCastMember.$("[data-testid='title-cast-item__actor']").getText();
    }

    @Step("Click on cast member name at position {position}")
    public ActorPage clickCastMemberName(int position) {
        topCastMembers.get(position - 1).$("[data-testid='title-cast-item__actor']").click();
        return new ActorPage();
    }
}

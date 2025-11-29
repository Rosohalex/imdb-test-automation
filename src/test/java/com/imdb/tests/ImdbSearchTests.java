package com.imdb.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.imdb.pages.ActorPage;
import com.imdb.pages.HomePage;
import com.imdb.pages.FilmPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Feature("Search and Cast Verification")
public class ImdbSearchTests {

    private HomePage homePage;

    @BeforeMethod
    @Step("BeforeTest: Setup test configuration")
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;

        homePage = new HomePage();
    }

    @Test
    @Description("IMBD search, navigation and title verifications test ")
    @Severity(SeverityLevel.NORMAL)
    public void searchNavigateAndCheckTitlesTest() {


        homePage.open()
                .acceptCookies()
                .search("QA");

        String firstSearchResultTitle = homePage.getFirstResultTitle();
        assertFalse(firstSearchResultTitle.isEmpty(), "First search result title should not be empty");

        FilmPage filmPage = homePage.clickFirstResult();
        String actualPageTitle = filmPage.getTitle();
        assertEquals(actualPageTitle, firstSearchResultTitle, "Page title should match the saved title from dropdown.");


        int castCount = filmPage.getTopCastMembersCount();
        assertTrue(castCount > 3,
                "Top cast should have more than 3 members. Actual count: " + castCount);

        String thirdCastMemberName = filmPage.getCastMemberName(3);
        ActorPage actorPage = filmPage.clickCastMemberName(3);

        String actualActorName = actorPage.getActorName();

        assertEquals(actualActorName, thirdCastMemberName,
                "Actor profile name should match the clicked cast member name");
    }

    @AfterMethod
    @Step("AfterTest: Close browser")
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
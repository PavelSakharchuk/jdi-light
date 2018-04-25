package io.github.epam.tests;

import io.github.epam.SimpleTestsInit;
import org.apache.commons.lang3.time.StopWatch;
import org.testng.annotations.Test;

import static io.github.epam.EpamGithubSite.*;
import static io.github.epam.entities.Users.DEFAULT_USER;
import static io.github.epam.entities.Users.USER_WITH_CONTACTS;
import static io.github.epam.steps.Preconditions.shouldBeLoggedIn;
import static io.github.epam.steps.Preconditions.shouldBeLoggedOut;

public class FormsTests extends SimpleTestsInit {

    @Test
    public void loginTest() {
        shouldBeLoggedOut();
        StopWatch s = StopWatch.createStarted();
        header.userIcon.click();
        System.out.println("TIME: " + s.getTime());
        header.loginForm.submit(DEFAULT_USER, "enter");
        homePage.checkOpened();
    }
    @Test
    public void fillContactFormTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        contactFormPage.main.contactForm.submit(USER_WITH_CONTACTS);
        contactFormPage.main.contactForm.check(USER_WITH_CONTACTS);
    }
}
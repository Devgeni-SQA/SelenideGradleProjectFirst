package docuSketch.GmailTitle;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static docuSketch.GmailTitle.GmailTitleSteps.*;

public class GmailTitleTest {

    @BeforeEach
    public void configurations() {
        Configuration.headless = true;
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://www.google.com/";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open("/");
    }
    @Test
    public void testGmailTitle() {
        loginToGoogleAccount();
        pushButtonGmail();
        checkTitleOfGmailPage();
    }
    @AfterEach
    public void afterMethod() {
        addScreenshot();
        closeWebDriver();
    }
}

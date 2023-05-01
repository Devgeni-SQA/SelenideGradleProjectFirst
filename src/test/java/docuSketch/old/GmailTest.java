package docuSketch.old;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

//import static docuSketch.authentication.ConfProperties.GMAILPASSWORD;
import static docuSketch.authentication.ConfProperties.GMAILUSERNAME;

public class GmailTest {

    @BeforeEach
    public void beforeMethod() {
        Configuration.headless = true;
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://www.google.com/";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        open("/");
    }
    @Test
    public void testGmailTitle() {
        login();
        SelenideElement buttonGmail = $x("//a[@aria-label='Почта (откроется новая вкладка)']")
                .shouldBe(visible);
        buttonGmail.click();
        SelenideElement titleOfEmailPage = $("meta+title")
                .shouldBe(Condition.innerText(GMAILUSERNAME));
    }
    @AfterEach
    public void afterMethod() {
//        Allure.addAttachment("screenshot", "image/png", "png");
        closeWebDriver();
    }
    protected static void login() {
        SelenideElement buttonEnter = $x("//*[@id='gb']//div[2]/a/span");
        buttonEnter.click();

        SelenideElement inputEmail = $x("//input[@type='email']");
        inputEmail.shouldBe(visible).setValue(GMAILUSERNAME).pressEnter();
        SelenideElement inputPassword = $("div>input[type='password']");
//        inputPassword.should(editable).setValue(GMAILPASSWORD).pressEnter();
    }
}


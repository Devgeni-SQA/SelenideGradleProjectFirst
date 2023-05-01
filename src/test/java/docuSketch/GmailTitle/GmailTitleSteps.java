package docuSketch.GmailTitle;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static docuSketch.GmailTitle.GmailTitleLocators.buttonGmail;
import static docuSketch.GmailTitle.GmailTitleLocators.titleOfGmailPage;
import static docuSketch.authentication.Aythentication.login;
import static docuSketch.authentication.ConfProperties.GMAILUSERNAME;


public class GmailTitleSteps {

    @Step
    public static void clickButtonEnterGoogleAccount() {
        GmailTitleLocators.buttonEnterToGoogleAccount.click();
    }
    @Step
    public static void loginToGoogleAccount() {
        login();
    }

    @Step
    public static void pushButtonGmail() {
        buttonGmail.click();
    }
    @Step
    public static void checkTitleOfGmailPage() {
        titleOfGmailPage.shouldBe(Condition.innerText(GMAILUSERNAME));
    }
    public static void addScreenshot() {
        Allure.getLifecycle().addAttachment(
                "finalPageScreenshot", "image/png", "png",
                ((TakesScreenshot) WebDriverRunner.getWebDriver())
                        .getScreenshotAs(OutputType.BYTES)
        );
    }

}

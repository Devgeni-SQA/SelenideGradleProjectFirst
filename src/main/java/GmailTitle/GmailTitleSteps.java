package GmailTitle;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static GmailTitle.GmailTitleLocators.buttonGmail;
import static GmailTitle.GmailTitleLocators.titleOfGmailPage;

public class GmailTitleSteps {

    @Step
    public static void clickButtonEnterGoogleAccount() {
        GmailTitleLocators.buttonEnterToGoogleAccount.click();
    }
    @Step
    public static void pushButtonGmail() {
        buttonGmail.click();
    }
    @Step
    public static void checkTitleOfGmailPage() {
        titleOfGmailPage.shouldBe(Condition.innerText(System.getProperty("gmailusername")));
    }
    public static void addScreenshot() {
        Allure.getLifecycle().addAttachment(
                "finalPageScreenshot", "image/png", "png",
                ((TakesScreenshot) WebDriverRunner.getWebDriver())
                        .getScreenshotAs(OutputType.BYTES)
        );
    }

}

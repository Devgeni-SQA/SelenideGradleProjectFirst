package immoviewer;

import com.codeborne.selenide.*;
import immoviewer.confProperties.ConfPropertiesProject;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static immoviewer.OrdersTestLocators.*;
public class OrdersTestSteps {

    @Step
    public static void openBaseUrl() {
        Selenide.open(ConfPropertiesProject.getURL());
    }
    @Step
    public static void goToListOfStatus() { panelOfStatus.click(); }
    @Step
    public static void chooseStatus() {
        buttonOfStatusDone.click(); }
    @Step
    public static void checkStatusOfResult() {
        statusOfSelectedRow.shouldHave(Condition.text("DONE"));
    }
    @Attachment
    public static void addScreenshot() {
        Allure.getLifecycle().addAttachment(
                "finalPageScreenshot", "image/png", "png",
                ((TakesScreenshot) WebDriverRunner.getWebDriver())
                        .getScreenshotAs(OutputType.BYTES)
        );
    }
}

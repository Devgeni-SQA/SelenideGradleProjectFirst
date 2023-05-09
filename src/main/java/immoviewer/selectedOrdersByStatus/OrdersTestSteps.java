package immoviewer.selectedOrdersByStatus;

import com.codeborne.selenide.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static immoviewer.selectedOrdersByStatus.OrdersTestLocators.*;

public class OrdersTestSteps {

    @Step
    public static void goToListOfStatus() { panelOfStatus.click(); }
    @Step
    public static void chooseStatus() {
        buttonOfStatusDone.click(); }
    @Step
    public static void goNextPage() {
        JavascriptExecutor jse = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        jse.executeScript("arguments[0].click()", buttonNextPage);
    }
    @Step
    public static void checkStatusOfSelectedOrders() throws InterruptedException {
        String numberOfPagesOfResult = numberOfPages.getText();
        int num = Integer.parseInt(numberOfPagesOfResult);
        for (int i = 0; i < num; i++) {
            for (SelenideElement selectedOrdersStatus : selectedOrdersStatuses) {
                selectedOrdersStatus.shouldHave(Condition.text("DONE"));
            }
            goNextPage();
            Thread.sleep(10000);
        }
    }
    public static void addScreenshot() {
        Allure.getLifecycle().addAttachment(
                "finalPageScreenshot", "image/png", "png",
                ((TakesScreenshot) WebDriverRunner.getWebDriver())
                        .getScreenshotAs(OutputType.BYTES)
        );
    }
}

package immoviewer;

import com.codeborne.selenide.*;
import immoviewer.confProperties.ConfPropertiesProject;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
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
    public static void goNextPage() {
        JavascriptExecutor jse = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        jse.executeScript("arguments[0].click()", buttonNextPage);
    }
    @Step
    public static void checkStatusOfResult() throws InterruptedException {
        String numberOfPagesOfResult = numberOfPages.getText();
        int num = Integer.parseInt(numberOfPagesOfResult);
        System.out.println(num);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < statusOfSelectedRow.size(); j++) {
                statusOfSelectedRow.get(j).shouldHave(Condition.text("DONE"));
            } goNextPage();
            Thread.sleep(4000);
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

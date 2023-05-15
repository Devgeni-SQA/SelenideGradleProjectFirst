package immoviewer.steps;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.junit.Assert;
import java.util.Objects;
import static com.codeborne.selenide.Selenide.*;
import static immoviewer.locators.Locators2.*;

public class Steps2 {

    @Step
    public static void filterByStatus(String status) {
        tabStatus.shouldBe(Condition.enabled).click();
        ElementsCollection listOfStatusTypes = $$x("//div[contains(@class, 'status')]/p");
        for (SelenideElement typeOfStatus : listOfStatusTypes) {
            if (Objects.equals(status, typeOfStatus.getText())) {
                typeOfStatus.click();
            }
        }
        sendEscapeToTheBodyElement();
    }
    @Step
    public static void filterByAssignee(String assignee) {
        tabAssignee.shouldBe(Condition.visible).click();
        ElementsCollection listAssignees = $$x("//*[contains(@id, 'mat-option')]//p")
                .filter(Condition.innerText(assignee));
        for (SelenideElement typeOfassignee : listAssignees) {
            if (Objects.equals(assignee, typeOfassignee.getText())) {
                typeOfassignee.click();
            }
        }
        sendEscapeToTheBodyElement();
    }
    @Step
    public static void filterByCustomer(String customer) {
        tabCustomer.shouldBe(Condition.visible).click();
        for (SelenideElement typeOfCustomer : typesOfcustomers) {
            if (Objects.equals(customer, typeOfCustomer.getText())) {
                typeOfCustomer.click();
            }
        }
        sendEscapeToTheBodyElement();
    }
    @Step
    public static SelenideElement selectEditButton(String order) {
        ElementsCollection firstTabOfOrderRow = $$("tbody>tr");
        for (SelenideElement selenideElement : firstTabOfOrderRow) {
            if (order.equals(selenideElement.find("td:first-child p.mat-display-1")
                    .getText())) {
                return selenideElement.find("td:last-child > button:nth-child(2) i");
            }
        }
        return null;
    }
    @Step
    public static void verifyNewStatusAndReturnPreviousStatusOfOrder(String order, String status) throws InterruptedException {
        ElementsCollection firstTabOfOrderRow = $$("tbody>tr")
                .filterBy(Condition.innerText(order));
        Thread.sleep(2000);

        for (SelenideElement selenideElement : firstTabOfOrderRow) {
            if (Objects.equals(order, selenideElement.find("td:first-child p.mat-display-1")
                    .getText())) {
                Assert.assertEquals(status, selenideElement.find("td:first-child div.table-td:last-child p")
                        .shouldBe(Condition.visible).getText());

                selenideElement.find("td:last-child > button:nth-child(2) i")
                        .shouldBe(Condition.visible).click();
                clickNewIterationAndStartDrawingButtons();
                break;
        }
    }
}
    @Step
    public static void clickSendExternalProviderButton() {
        sendExternalProviderButton.shouldBe(Condition.appear).click();
    }
    public static void inputTime(Integer min) {
        inputTime.setValue(String.valueOf(min));
        logTimeAndFinishButton.click();
    }
    @Step
    public static void clickLeftsideMenuOrdersButton() {
        leftsideMenuOrdersButton.shouldBe(Condition.visible).click();
    }
    @Step
    public static void clickClearFilterOnAssigneeButton() {
        clearFilterOnAssigneeButton.click();
    }
    @Step
    public static void clickNewIterationAndStartDrawingButtons() {
        newIterationButton.shouldBe(Condition.enabled).click();
        startDrawingButton.shouldBe(Condition.enabled).click();
    }
    public static void sendEscapeToTheBodyElement() {
        $x("//body").pressEscape();
    }
}
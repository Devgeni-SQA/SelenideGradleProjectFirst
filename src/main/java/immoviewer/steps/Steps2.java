package immoviewer.steps;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.junit.Assert;
import java.util.Objects;
import static com.codeborne.selenide.Selenide.*;
import static immoviewer.checkOrderStatusChange.Locators2.*;

public class Steps2 {

    @Step
    public static void filterByStatus(String status) {
        tabStatus.shouldBe(Condition.appear).click();
        ElementsCollection typeOfStatus = $$x("//div[contains(@class, 'status')]/p");
        for (SelenideElement ofStatus : typeOfStatus) {
            if (Objects.equals(status, ofStatus.getText())) {
                ofStatus.click();
            }
        }
        sendEscapeToTheBodyElement();
    }
    @Step
    public static void filterByAssignee(String assignee) {
        tabAssignee.shouldBe(Condition.appear).click();
        ElementsCollection listAssignees = $$x("//*[contains(@id, 'mat-option')]//p");
        for (SelenideElement listAssignee : listAssignees) {
            if (Objects.equals(assignee, listAssignee.getText())) {
                listAssignee.click();
            }
        }
        sendEscapeToTheBodyElement();
    }
    @Step
    public static void filterByCustomer(String customer) {
        tabCustomer.shouldBe(Condition.appear).click();
        for (SelenideElement typesOfcustomer : typesOfcustomers) {
            if (Objects.equals(customer, typesOfcustomer.getText())) {
                typesOfcustomer.click();
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
            .shouldBe(CollectionCondition.size(10));
    Thread.sleep(2000);
    String actualStatus;
    SelenideElement editButton;
    for (SelenideElement selenideElement : firstTabOfOrderRow) {
        if (Objects.equals(order, selenideElement.find("td:first-child p.mat-display-1")
                .getText())) {
            actualStatus = selenideElement.find("td:first-child div.table-td:last-child p")
                    .shouldBe(Condition.visible).getText();
            editButton = selenideElement.find("td:last-child > button:nth-child(2) i")
                    .shouldBe(Condition.interactable);
            Assert.assertEquals(status, actualStatus);
            editButton.click();
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
        leftsideMenuOrdersButton.shouldBe(Condition.interactable).click();
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
package immoviewer.steps;
import com.codeborne.selenide.*;
import immoviewer.SlackIntegrationTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import java.io.IOException;
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
                break;
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
    public static SelenideElement selectedOrderEditButton(String order) {
        for (SelenideElement selenideElement : firstTabOfOrderRow) {
            if (order.equals(selenideElement.find("td:first-child p.mat-display-1")
                    .getText())) {
                return selenideElement.find("td:last-child > button:nth-child(2) i");
            }
        }
        return null;
    }
    @Step
    public static void verifyPresenceOfSelectedOrder(String order) throws IOException {
        ElementsCollection firstTabOfOrderRow = $$("tbody>tr td:first-child p.mat-display-1");
        String res = "fails";
        try {
            firstTabOfOrderRow
                    .shouldHave(CollectionCondition.itemWithText(order));
            res = "Success";
        } finally {
            SlackIntegrationTest.sendMsgToSlack(res);
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
        Assert.assertTrue(newIterationButton.shouldBe(Condition.visible).isDisplayed());
        newIterationButton.click();
        Assert.assertTrue(startDrawingButton.shouldBe(Condition.interactable).isDisplayed());
        startDrawingButton.click();
        Assert.assertTrue(sendExternalProviderButton.shouldBe(Condition.visible).isDisplayed());//
    }
    public static void sendEscapeToTheBodyElement() {
        $x("//body").pressEscape();
    }
    @Step
    public static void verifySingularityOfOrder(String order) throws InterruptedException {
        Thread.sleep(2000);
        ElementsCollection orderSelectedById = $$("tbody>tr")
                .filterBy(Condition.innerText(order));
        Assert.assertEquals(1, orderSelectedById.size());
    }
}
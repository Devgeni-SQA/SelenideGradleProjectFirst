package immoviewer.locators;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Locators2 {

    public static SelenideElement tabAssignee = $x("//div[@class='orders-filter']//div[4]//div/div/span[not(contains(@class, 'ripple'))]");
    public static SelenideElement tabStatus = $x("//div[@id='mat-select-value-5']/span");
    public static SelenideElement tabCustomer = $x("//body[@class='ff-app']//div[@class='filter-customer']//span");
    public static SelenideElement sendExternalProviderButton = $x("//span[text()=' Send to External Provider ']/ancestor::button");
    public static SelenideElement inputTime = $x("//input[@type='number']");
    public static SelenideElement logTimeAndFinishButton = $x("//span[text()='Log Time & Finish']");
    public static SelenideElement leftsideMenuOrdersButton = $x("//button[@routerlink='/orders']/span[@class='mat-button-wrapper']");
    public static SelenideElement IdOfFirstOrder = $("td:first-child p.mat-display-1");////div[@class='table-td']//p
    public static SelenideElement clearFilterOnAssigneeButton = $x("//button[@class='clear-button']/i");
    public static ElementsCollection typesOfcustomers = $$x("//mat-option//p");
    public static SelenideElement newIterationButton = $x("//div[@class='order-control-button']/button");
    public static SelenideElement startDrawingButton = $x("//span[text()=' Start drawing ']/ancestor::button");
}
package immoviewer;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class OrdersTestLocators {

    public static SelenideElement fieldLogin = $x("//input[@id='username']");
    public static SelenideElement fieldPassword = $x("//input[@id='password']");
    public static SelenideElement buttonSubmit = $x("//button[@type='submit']");
    public static SelenideElement panelOfStatus = $x(
            "//*[@class='mat-select-placeholder mat-select-min-line ng-tns-c122-8 ng-star-inserted']");
    public static SelenideElement buttonOfStatusDone = $x("//div[@id='mat-select-4-panel']//p[contains(text(),'DONE')]");
    public static SelenideElement statusOfSelectedRow = $x("//td[@role='cell']//p[@class='mat-caption m-0 bold status-font']");
}

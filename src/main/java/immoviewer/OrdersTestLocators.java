package immoviewer;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class OrdersTestLocators {

    public static SelenideElement fieldLogin = $x("//input[@id='username']");
    public static SelenideElement fieldPassword = $x("//input[@id='password']");
    public static SelenideElement buttonSubmit = $x("//button[@type='submit']");
    public static SelenideElement panelOfStatus = $x(
            "//div[@id='mat-select-value-5']/span");
    public static SelenideElement buttonOfStatusDone = $x("//div[@id='mat-select-4-panel']//p[contains(text(),'DONE')]");
    public static ElementsCollection statusOfSelectedRow = $$x("//tr[@role='row']//p[@class='mat-caption m-0 bold status-font']");
}

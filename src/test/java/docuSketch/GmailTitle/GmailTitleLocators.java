package docuSketch.GmailTitle;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GmailTitleLocators {

    protected static SelenideElement buttonEnterToGoogleAccount = $x("//*[@id='gb']//div[2]/a/span");
    public static SelenideElement fieldInputEmail = $x("//input[@type='email']");
    public static SelenideElement fieldInputPassword = $("div>input[type='password']");
    protected static SelenideElement buttonGmail = $x("//a[@aria-label='Почта (откроется новая вкладка)']");
    protected static SelenideElement titleOfGmailPage = $("meta+title");
}

package docuSketch;
import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;


public class FirstTest {

    @Test
    public void testMyGmailTitle() {
        open("https://www.google.com/");

        SelenideElement buttonEnter = $x("//*[@id='gb']//div[2]/a/span")
                .click(ClickOptions.usingDefaultMethod());

        SelenideElement inputEmail = $x("//input[@type='email']");
        inputEmail.should(Condition.visible, Duration.ofSeconds(8))
                .sendKeys("qae4488@gmail.com" + Keys.ENTER);

        SelenideElement inputPassword =  $("div>input[type='password']");
        inputPassword.should(Condition.visible, Duration.ofSeconds(8))
                .sendKeys("44884488" + Keys.ENTER);

        SelenideElement buttonEmail = $x("//a[@aria-label='Почта (откроется новая вкладка)']")
                .click(ClickOptions.usingDefaultMethod());

        SelenideElement titleOfEmailPage = $("meta+title")
                .shouldBe(Condition.innerText("qae4488@gmail.com"));

        closeWebDriver();
    }
}


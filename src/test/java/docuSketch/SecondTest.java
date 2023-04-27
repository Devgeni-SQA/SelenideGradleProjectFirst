package docuSketch;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

public class SecondTest {


    private static final String gmailUsername = System.getProperty( "gmailusername", "0");
    private static final String gmailPassword = System.getProperty( "gmailpassword", "0");

    @Test
    public void testGmailtitle() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        open("https://www.google.com/");

        $x("//*[@id='gb']//div[2]/a/span").click();

        SelenideElement inputEmail = $x("//input[@type='email']");
        inputEmail.should(Condition.visible, Duration.ofSeconds(10))
                .sendKeys(gmailUsername + Keys.ENTER);

        SelenideElement inputPassword =  $("div>input[type='password']");
        inputPassword.should(Condition.visible, Duration.ofSeconds(10))
                .sendKeys(gmailPassword + Keys.ENTER);

        $x("//a[@aria-label='Почта (откроется новая вкладка)']").click();

        SelenideElement titleOfEmailPage = $("meta+title")
                .shouldBe(Condition.innerText(gmailUsername));

        closeWebDriver();
    }
}

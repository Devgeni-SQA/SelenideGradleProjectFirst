import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;


public class FirstTest {

    @Test
    public void testMyGmailTitle() {
        open("https://www.google.com/");
        $x("//*[@id='gb']//div[2]/a/span").click();
        $x("//input[@type='email']").setValue("qae4488@gmail.com")
                .shouldBe(Condition.value("qae4488@gmail.com"))
                .pressEnter();
        $("div > input[type='password']").setValue("44884488")
                .shouldBe(Condition.value("44884488"))
                .pressEnter();
        $x("//a[@aria-label='Почта (откроется новая вкладка)']").click();
        $("meta+title").shouldBe(Condition.innerText("qae4488@gmail.com"));
        closeWebDriver();
    }
}

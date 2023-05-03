package immoviewer;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static immoviewer.OrdersTestSteps.*;
import static immoviewer.confProperties.AuthenticationProject.loginImmoviewer;

public class OrdersTest {

    @BeforeEach
    public void configurations() {
        Configuration.headless = true;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        openBaseUrl();
    }
    @Test
    public void testStatusDoneOfOrders() {
        loginImmoviewer(immoviewer.confProperties.ConfPropertiesProject.getLOGIN(),
                immoviewer.confProperties.ConfPropertiesProject.getPASSWORD());
        goToListOfStatus();
        chooseStatus();
        checkStatusOfResult();
    }
    @AfterEach
    public void afterTest() {
        addScreenshot();
        closeWebDriver();
    }
}

package immoviewer;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static immoviewer.steps.Steps1.*;
import static immoviewer.auth.AuthenticationProject.authentication;

public class OrdersTest {

    @BeforeEach
    public void configurations() throws IOException {
        Configuration.headless = true;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("conf.properties"));
        Selenide.open(System.getProperty("BaseURL"));
    }
    @Test
    public void testStatusOfOrders() throws InterruptedException {
        authentication(System.getProperty("login"), System.getProperty("password"));
        goToTabStatus();
        chooseStatus();
        checkStatusOfSelectedOrders();
    }
    @AfterEach
    public void afterTest() {
        addScreenshot();
        closeWebDriver();
    }
}

package immoviewer;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Objects;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static immoviewer.auth.AuthenticationProjects.authentication;
import static immoviewer.checkOrderStatusChange.Locators2.IdOfFirstOrder;
import static immoviewer.steps.Steps1.addScreenshot;
import static immoviewer.steps.Steps2.*;

public class OrderStatusChangeTest {

    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1440x900";
        Configuration.timeout = 10000;
        Configuration.headless = true;
    }

    @BeforeEach
    public void beforeTest() throws IOException {
        setUp();
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("conf.properties"));
        Selenide.open(System.getProperty("BaseURL"));
    }
    @Test
    public void testSettingOfOrderStatus() throws InterruptedException {
        authentication(System.getProperty("login"), System.getProperty("password"));

        filterByStatus("CORRECTION");
        filterByAssignee("Supervisor");
        final String idOfSelectedOrder = IdOfFirstOrder.getText();

        Objects.requireNonNull(selectEditButton(idOfSelectedOrder)).click();

        clickSendExternalProviderButton();
        inputTime(1);
        clickLeftsideMenuOrdersButton();

        clickClearFilterOnAssigneeButton();
        filterByCustomer("Zdravko");

        verifyNewStatusAndReturnPreviousStatusOfOrder(idOfSelectedOrder, "EXTERNAL_REVIEW");
    }
        @AfterEach
        public void afterTest () {
            addScreenshot();
            closeWebDriver();
        }
    }
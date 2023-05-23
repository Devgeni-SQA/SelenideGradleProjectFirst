package immoviewer;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Objects;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static immoviewer.auth.AuthenticationProject.authentication;
import static immoviewer.locators.Locators2.*;
import static immoviewer.steps.Steps1.addScreenshot;
import static immoviewer.steps.Steps2.*;

public class OrderStatusChangeTest {

    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1440x900";
        Configuration.timeout = 25000;
        Configuration.headless = true;
    }

    @BeforeEach
    public void beforeTest() throws IOException {
        setUp();
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("conf.properties"));
        Selenide.open(System.getProperty("BaseURL"));
    }
    @Test
    public void testSettingOfOrderStatus() {
        authentication(System.getProperty("login"), System.getProperty("password"));

        filterByStatus("CORRECTION");
        filterByAssignee("Supervisor");
        final String idOfSelectedOrder = IdOfFirstOrder.getText();

        Objects.requireNonNull(selectedOrderEditButton(idOfSelectedOrder)).click();
        clickSendExternalProviderButton();
        inputTime(1);

        clickLeftsideMenuOrdersButton();
        clickClearFilterOnAssigneeButton();

        filterByCustomer("Zdravko");
        filterByStatus("EXTERNAL_REVIEW");

        verifyPresenceOfSelectedOrder(idOfSelectedOrder);

        Objects.requireNonNull(selectedOrderEditButton(idOfSelectedOrder)).click();
        clickNewIterationAndStartDrawingButtons();
    }
        @AfterEach
        public void afterTest () {
            addScreenshot();
            closeWebDriver();
        }
    }
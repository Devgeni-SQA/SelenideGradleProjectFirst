package docuSketch.GmailTitle;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static GmailTitle.auth.Auth.login;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static GmailTitle.GmailTitleSteps.*;

public class GmailTitleTest {

    @BeforeEach
    public void configurations() throws IOException {
        Configuration.headless = true;
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("conf.properties"));
        Selenide.open(System.getProperty("gmailURL"));
    }
    @Test
    public void testGmailTitle() {
        login(System.getProperty("gmailusername"), System.getProperty("gmailpassword"));
        pushButtonGmail();
        checkTitleOfGmailPage();
    }
    @AfterEach
    public void afterMethod() {
        addScreenshot();
        closeWebDriver();
    }
}

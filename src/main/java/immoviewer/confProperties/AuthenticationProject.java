package immoviewer.confProperties;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static immoviewer.OrdersTestLocators.*;

public class AuthenticationProject {

    @Step
    public static void loginImmoviewer(String login, String password) {
        fieldLogin.shouldBe(Condition.visible).setValue(login);
        fieldPassword.shouldBe(Condition.visible).setValue(password);
        buttonSubmit.click();
    }
}

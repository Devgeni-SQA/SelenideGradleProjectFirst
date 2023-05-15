package immoviewer.auth;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import static immoviewer.selectedOrdersByStatus.Locators1.*;

public class AuthenticationProjects {

    @Step
    public static void authentication(String login, String password) {
        fieldLogin.shouldBe(Condition.visible).setValue(login);
        fieldPassword.shouldBe(Condition.visible).setValue(password);
        buttonSubmit.click();
    }
}

package GmailTitle.auth;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Condition.visible;
import static GmailTitle.GmailTitleLocators.fieldInputEmail;
import static GmailTitle.GmailTitleLocators.fieldInputPassword;
import static GmailTitle.GmailTitleSteps.clickButtonEnterGoogleAccount;

public class Auth {

        public static void login(String login, String password) {
            clickButtonEnterGoogleAccount();
            fieldInputEmail.shouldBe(visible).setValue(login).pressEnter();
            fieldInputPassword.should(Condition.exist).setValue(password).pressEnter();
        }
    }

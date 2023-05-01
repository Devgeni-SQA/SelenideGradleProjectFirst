package docuSketch.authentication;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Condition.visible;
import static docuSketch.GmailTitle.GmailTitleLocators.fieldInputEmail;
import static docuSketch.GmailTitle.GmailTitleLocators.fieldInputPassword;
import static docuSketch.GmailTitle.GmailTitleSteps.clickButtonEnterGoogleAccount;
import static docuSketch.authentication.ConfProperties.GMAILPASSWORD;
import static docuSketch.authentication.ConfProperties.GMAILUSERNAME;

public class Aythentication {

        public static void login() {
            clickButtonEnterGoogleAccount();
            fieldInputEmail.shouldBe(visible).setValue(GMAILUSERNAME).pressEnter();
            fieldInputPassword.should(Condition.exist).setValue(GMAILPASSWORD).pressEnter();
        }
    }

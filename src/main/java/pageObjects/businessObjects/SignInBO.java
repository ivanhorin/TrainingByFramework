package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.SignInPage;
import sun.rmi.runtime.Log;


public class SignInBO {
    private SignInPage signInPage;

    public SignInBO() {
        signInPage= new SignInPage();
    }

    public HomeBO login(String mail, String password) {
        signInPage.enterEmail(mail)
                .enterPassword(password)
                .clickSignInButton();
        return new HomeBO();
    }

    public void verifyFailedLoginErrorMessageDisplayed(){
        Assert.assertTrue(signInPage.isLoginFailedErrorMessageDisplayed(),
                "'Login failed' error message is not displayed");
    }
}

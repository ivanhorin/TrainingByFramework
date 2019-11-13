package pageObjects;

import decorator.elements.Button;
import decorator.elements.PageElement;
import decorator.elements.TextInput;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage{

    private static final Logger LOG = Logger.getLogger(SignInPage.class);

    private By mailInput = By.id("signInEmail");

    private By passwordInput = By.id("signInPassword");

    private By signInButton = By.className("popup-reg-sign-in-form__sign-in");

    private By loginFailedErrorMessage = By.xpath("//div[text()='Login failed. Please try again.']");

    public SignInPage enterEmail(String email){
        getElement(mailInput).sendKeys(email);
        LOG.info("Mail was entered.");
        return this;
    }

    public SignInPage enterPassword(String password){
        getElement(passwordInput).sendKeys(password);
        LOG.info("Password was entered.");
        return this;
    }

    public  HomePage clickSignInButton(){
        getElement(signInButton).click();
        LOG.info("Sign in button clicked.");
        return new HomePage();
    }

    public boolean isLoginFailedErrorMessageDisplayed() {
        boolean isDisplayed = isDisplayed(loginFailedErrorMessage);
        LOG.info(String.format("Is 'Login Failed' error message displayed': '%s'",isDisplayed));
        return isDisplayed;
    }
}

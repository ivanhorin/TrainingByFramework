package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static consts.Constants.BusinessConfigs.HOME_PAGE_URL;

public class HomePage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(HomePage.class);

    private By signInButton = By.xpath("//p[@class='header-auth__signin']//span");

    private By topRightCornerUserNameElement = By.className("user-info__name");

    private By trainingListPageButton = By.xpath("//ul[@class='main-nav__list']//a[contains(@class,'training')]");

    private By newsPageButton = By.className("//ul[@class='main-nav__list']//a[contains(@class,'news')]");

    private By aboutPageButton = By.className("//ul[@class='main-nav__list']//a[contains(@class,'about')]");

    private By FAQPageButton = By.xpath("//ul[@class='main-nav__list']//a[contains(@class,'faq')]");


    public SignInPage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("'Sign in' button clicked");
        return new SignInPage();
    }

    public HomePage proceedToHomePage() {
        proceedToPage(HOME_PAGE_URL);
        LOG.info(String.format("Proceeded to '%s' URL.",HOME_PAGE_URL));
        return this;
    }

    public boolean isUserNameDisplayed(){
        boolean isDisplayed = isDisplayed(topRightCornerUserNameElement);
        LOG.info(String.format("User is logged in: '%s'",isDisplayed));
        return isDisplayed;
    }
    public String getLoggedInUserName(){
        return getElement(topRightCornerUserNameElement).getText();
    }

    public TrainingListPage openTrainingListPage() {
        getElement(trainingListPageButton).click();
        LOG.info("Open 'Training List' page.");
        return new TrainingListPage();
    }

    public NewsPage openNewsPage() {
        getElement(newsPageButton).click();
        LOG.info("Open 'News Page' page.");
        return new NewsPage();
    }

    public AboutPage openAboutPage() {
        getElement(aboutPageButton).click();
        LOG.info("Open 'About' page.");
        return new AboutPage();
    }

    public FAQPage openFAQPage() {
        getElement(FAQPageButton).click();
        LOG.info("Open 'FAQ' page.");
        return new FAQPage();
    }


}

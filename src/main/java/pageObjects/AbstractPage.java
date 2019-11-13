package pageObjects;

import decorator.CustomDecorator;
import decorator.elements.PageElement;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPage {

    private static WebDriverWait wait =  new WebDriverWait(DriverFactory.getDriver(), 20);

     AbstractPage() {
    }

    void  proceedToPage(final String url) {
        DriverFactory.getDriver().get(url);
    }

     WebElement getElement(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    List<WebElement> getElements(By locator) {
        return DriverFactory.getDriver().findElements(locator);
    }


    public boolean isDisplayed(By locator) {
        try {
            return DriverFactory
                  .getDriver()
                  .findElement(locator)
                  .isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

}

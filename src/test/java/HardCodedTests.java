import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HardCodedTests {

    @Test(description = "Verify user is successfully logged in with appropriate credentials.")
    public void verifyUserIsSuccessfullyLoggedIn() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.by/#/Home");

        WebElement signInButton = driver.findElement(By.xpath("//p[@class='header-auth__signin']//span"));
        signInButton.click();
        WebElement mailInput = driver.findElement(By.id("signInEmail"));
        mailInput.sendKeys("ivanhorintest@gmail.com");
        WebElement passwordInput = driver.findElement(By.id("signInPassword"));
        passwordInput.sendKeys("ivanhorintestPassword");
        WebElement signIn = driver.findElement(By.className("popup-reg-sign-in-form__sign-in"));
        signIn.click();

        WebElement userName = driver.findElement(By.className("user-info__name"));
        Assert.assertTrue(userName.isDisplayed(),"Username is NOT displayed");

        driver.quit();

       // WebDriverWait wait = new WebDriverWait(driver, 20);
      //  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));


    }

    @Test(description = "Verify error message appears when user logging in with inappropriate credentials.")
    public void verifyErrorMessageAppearsForIncorrectUser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.by/#/Home");

        WebElement signInButton = driver.findElement(By.xpath("//p[@class='header-auth__signin']//span"));
        signInButton.click();
        WebElement mailInput = driver.findElement(By.id("signInEmail"));
        mailInput.sendKeys("incorrectMail@mail.com");
        WebElement passwordInput = driver.findElement(By.id("signInPassword"));
        passwordInput.sendKeys("incorrectPassword");
        WebElement signIn = driver.findElement(By.className("popup-reg-sign-in-form__sign-in"));
        signIn.click();

        WebElement userName = driver.findElement(By.className("user-info__name"));
        Assert.assertFalse(userName.isDisplayed(), "Username IS displayed");

        driver.quit();
    }

    @Test(description = "Verify 'Trainings' search works properly with searching in 'Skills'")
    public void verifyTrainingsSearchWorksProperlyForSkills() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.by/#/Home");

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement signInButton = driver.findElement(By.xpath("//p[@class='header-auth__signin']//span"));
        signInButton.click();
        WebElement mailInput = driver.findElement(By.id("signInEmail"));
        mailInput.sendKeys("ivanhorintest@gmail.com");
        WebElement passwordInput = driver.findElement(By.id("signInPassword"));
        passwordInput.sendKeys("ivanhorintestPassword");
        WebElement signIn = driver.findElement(By.className("popup-reg-sign-in-form__sign-in"));
        signIn.click();
        WebElement trainingInput = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//input[@name='training-filter-input']")));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        trainingInput = wait.until(ExpectedConditions
              .visibilityOfElementLocated(By.xpath("//input[@name='training-filter-input']")));
        trainingInput.click();

        WebElement bySkillsButton = wait.until(ExpectedConditions
              .visibilityOfElementLocated(By.xpath("//div[@class='navigation-item ng-binding' and contains(text(),'By skills')]")));
        bySkillsButton.click();
        trainingInput.sendKeys("Java");

        WebElement javaCheckBox = driver.findElement(By.xpath("//label[contains(.,'Java')]"));
        javaCheckBox.click();

        WebElement collapseSearchInput = driver.findElement(By.className("//div[contains(@class,'arrow-icon-rotate']"));
        collapseSearchInput.click();

        List<WebElement> skillsSearchResultsList = driver.findElements(By.xpath("//a[@class='training-item__title-link ng-binding']"));
        skillsSearchResultsList.forEach(element->Assert.assertTrue(element.getText().contains("Java"),
                String.format("Element %s does not contain 'Java' word.",element)));

        WebElement deleteJavaSkillButton =
              driver.findElement(By.xpath("//span[contains(text(),'Java')]//span[@ng-click='clearSkill(skillName)']"));
        deleteJavaSkillButton.click();
        trainingInput.click();

        trainingInput.click();
        bySkillsButton.click();
        trainingInput.sendKeys("DATA");

        WebElement  dataEngineeringCheckBox = driver.findElement(By.xpath("//label[contains(.,'Data Engineering')]"));
        dataEngineeringCheckBox.click();

        WebElement  dataScienceCheckBox = driver.findElement(By.xpath("//label[contains(.,'Data Science')]"));
        dataScienceCheckBox.click();

        collapseSearchInput.click();

        skillsSearchResultsList = driver.findElements(By.xpath("//a[@class='training-item__title-link ng-binding']"));
        skillsSearchResultsList.forEach(element->Assert.assertTrue(element.getText().contains("Data"),
              String.format("Element %s does not contain 'Data' word.",element)));



    }


}

package pageObjects;

import decorator.elements.Button;
import org.openqa.selenium.support.FindBy;

public class NewsPage extends AbstractPage {

    @FindBy(xpath = "//span[@class='ng-binding' and text()='News']")
    private Button newsButton;

    @FindBy(xpath = "//span[@class='ng-binding' and text()='Success Stories']")
    private Button successStoriesButton;

    @FindBy(xpath = "//span[@class='ng-binding' and text()='Materials']")
    private Button materialsButton;

    @FindBy(xpath = "//span[@class='ng-binding' and text()='News']")
    private Button videosButton;
}

package decorator.elements;

import org.openqa.selenium.WebElement;

public class Button extends PageElement {

    public Button(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click(){
        webElement.click();
    }

}

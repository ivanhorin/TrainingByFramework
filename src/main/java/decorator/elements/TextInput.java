package decorator.elements;

import org.openqa.selenium.WebElement;

public class TextInput extends  PageElement {

    public TextInput(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        webElement.click();
        webElement.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        webElement.clear();
    }
}

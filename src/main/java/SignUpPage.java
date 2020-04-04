import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emptyNameError = By.xpath("//dd[text() = \"Username can't be blank\"]");

    public String getErrorText(){
        return driver.findElement(emptyNameError).getText();
    }
}

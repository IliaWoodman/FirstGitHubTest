import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emptyNameError = By.xpath("//dd[text() = \"Username can't be blank\"]");
    private By emptyEmailError = By.xpath("//dd[text() = \"Email can't be blank\"]");
    private By emptyPasswordError = By.xpath("//dd[text() = \"Password can't be blank\"]");

    public String getErrorText(String errorName){
        if (errorName.equals("name")){
            return driver.findElement(emptyNameError).getText();
        }else if (errorName.equals("email")){
            return driver.findElement(emptyEmailError).getText();
        }else if (errorName.equals("password")){
            return driver.findElement(emptyPasswordError).getText();
        }
        else return "Error not found";
    }
}

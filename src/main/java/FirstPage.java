import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstPage {
    private WebDriver driver;

    public FirstPage (WebDriver driver){
        this.driver = driver;
    }
    private By userNameField = By.xpath("(//input[@name='user[login]'])[1]");
    private By emailField = By.xpath("(//input[@name='user[email]'])[1]");
    private By passwordField = By.xpath("(//input[@name='user[password]'])[1]");
    private By signUpForGitHubButton = By.xpath("(//button[text()=\"Sign up for GitHub\"])[1]");

    public FirstPage typeNameField(String username){
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }
    public FirstPage typeEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    public FirstPage typePasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public FirstPage clicksignUpForGitHubButton(){
        driver.findElement(signUpForGitHubButton).click();
        return this;
    }
    public SignUpPage registration (String username, String email, String password){
        this.typeNameField(username);
        this.typeEmailField(email);
        this.typePasswordField(password);
        this.clicksignUpForGitHubButton();
        return new SignUpPage(driver);
    }


}

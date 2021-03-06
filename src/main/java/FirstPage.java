import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//первая страница

public class FirstPage {
    private WebDriver driver;

    public FirstPage (WebDriver driver){
        this.driver = driver;
    }
    private By userNameField = By.xpath("(//input[@name='user[login]'])[1]");
    private By emailField = By.xpath("(//input[@name='user[email]'])[1]");
    private By passwordField = By.xpath("(//input[@name='user[password]'])[1]");
    private By signUpForGitHubButton = By.xpath("(//button[text()=\"Sign up for GitHub\"])[1]");
    private By signInButton = By.xpath("//a[@href = '/login']");

    private By nameError = By.xpath("//div[@class = \"mb-1 \"]");
    private By emailError = By.xpath("//dd[text() = 'Email is invalid or already taken']");

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
    public SignUpPage clicksignUpForGitHubButton(){
        driver.findElement(signUpForGitHubButton).click();
        return new SignUpPage(driver);
    }
    public SignInPage clickSignInButton(){
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }
    public SignUpPage registration (String username, String email, String password){
        this.typeNameField(username);
        this.typeEmailField(email);
        this.typePasswordField(password);
        this.clicksignUpForGitHubButton();
        return new SignUpPage(driver);
    }
    public String  getTextFromTag(String text){
        if (text.equals("name")){
            return driver.findElement(nameError).getText();
        }else if (text.equals("email")){
            return driver.findElement(emailError).getText();
        }else return null;
    }

}

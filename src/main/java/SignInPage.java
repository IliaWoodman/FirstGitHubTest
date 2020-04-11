import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
//Страница для ввода логина
public class SignInPage {
    WebDriver driver;
    private By h1 = By.xpath("//h1");
    private By loginField = By.xpath("//input[@id = 'login_field']");
    private By passwordField = By.xpath("//input[@id = 'password']");
    private By signInButton = By.xpath("//input[@value = 'Sign in']");
    private By incorrectValueError = By.xpath("//div[@class = 'container-lg px-2']");

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    public String getH1Text(){
        return driver.findElement(h1).getText();
    }
    public SignInPage typeLoginField(String login){
        driver.findElement(loginField).sendKeys(login);
        return this;
    }
    public SignInPage typePasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public MainPage clickSignInButton(){
         driver.findElement(signInButton).click();
         return new MainPage(driver);
    }

    public MainPage logIn(String login, String password){
        typeLoginField(login);
        typePasswordField(password);
        clickSignInButton();
        return new MainPage(driver);
    }
    public MainPage logInWithoutClickButton(String login, String password){
        typeLoginField(login);
        typePasswordField(password);
        driver.findElement(passwordField).sendKeys(Keys.ENTER);
        return new MainPage(driver);
    }
    public String getErrorText(){
       return driver.findElement(incorrectValueError).getText();
    }
}

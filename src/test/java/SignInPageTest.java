import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignInPageTest {
    WebDriver driver;
    SignInPage signInPage;
    private String login = PrivateData.getLOGIN();
    private String password = PrivateData.getPASSWORD();

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\QS_Specialist\\IdeaProjects\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://github.com/login");
        signInPage = new SignInPage(driver);
    }

    @Test
    public void checkLogInWithIncorrectValue(){
        SignInPage signInPage = new SignInPage(driver);
        signInPage.logInWithoutClickButton("qwe@rty.com", "123");
        String error = signInPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.",error);
    }
    @Test
    public void checkLogInWithCorrectValue(){
        MainPage mainPage = signInPage.logIn(login,password);
        Assert.assertEquals("https://github.com/", driver.getCurrentUrl());
        Assert.assertEquals("Dashboard", mainPage.getH1Text());
    }


}

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstPageTest {
    WebDriver driver;
    FirstPage firstPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\QS_Specialist\\IdeaProjects\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://github.com/");
        firstPage = new FirstPage(driver);
    }

/*    @Test
    public void transferToSignUpPage(){
        SignUpPage signUpPage = firstPage.clicksignUpForGitHubButton();
        String h1Text = signUpPage.getH1Text();
        Assert.assertEquals("Create your account", h1Text);
    }*/
    @Test
    public void checkInCorrectName(){
        FirstPage firstPage = new FirstPage(driver);
        String name = "qqwe";
        firstPage.typeNameField(name);
        String res = firstPage.getTextFromTag("name");
        String expectedRes = String.format("Username %s is not available.", name);
        Assert.assertEquals(expectedRes, res);
    }
    @Test
    public void checkInCorrectEmail(){
        FirstPage firstPage = new FirstPage(driver);
        String email = "qwe@.com";
        firstPage.typeEmailField(email);
        Assert.assertEquals("Email is invalid or already taken",firstPage.getTextFromTag("email"));

    }
    @Test
    public void registrationWithoutName(){
        SignUpPage signUpPage = firstPage.registration("", "qwe@rty.com", "QweRty123");
        String emptyNameError = signUpPage.getErrorText("name");
        Assert.assertEquals("Username can't be blank", emptyNameError);
    }
    @Test
    public void registrationWithoutEmail(){
        SignUpPage signUpPage = firstPage.registration("QweRty1POI", "", "QwerTqwe87");
        String emptyEmailError = signUpPage.getErrorText("email");
        Assert.assertEquals("Email can't be blank", emptyEmailError);
    }
    @Test
    public void registrationWithoutPassword(){
        SignUpPage signUpPage = firstPage.registration("QweRty1POI", "qwe@rty.com", "");
        String emptyPasswordError = signUpPage.getErrorText("password");
        Assert.assertEquals("Password can't be blank", emptyPasswordError);
    }
    @After
    public void TearDown(){
        driver.quit();
    }
}

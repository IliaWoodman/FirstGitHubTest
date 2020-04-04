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

    @Test
    public void incorrectRegistration(){
        SignUpPage signUpPage = firstPage.registration("", "qwe@rty.com", "QweRty123");
        String emptyNameError = signUpPage.getErrorText();
        Assert.assertEquals("Username can't be blank", emptyNameError);



    }
}
